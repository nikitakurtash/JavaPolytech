import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MethodCaller {
    private static final Map<Class<?>, Object> defaultValues = new HashMap<>();
    static {
        defaultValues.put(Byte.TYPE, (byte)0);
        defaultValues.put(Short.TYPE, (short) 0);
        defaultValues.put(Integer.TYPE, 0);
        defaultValues.put(Long.TYPE, 0L);
        defaultValues.put(Float.TYPE, 0.0F);
        defaultValues.put(Double.TYPE, 0.0);
        defaultValues.put(Character.TYPE, '\u0000');
        defaultValues.put(Boolean.TYPE, false);
    }

    public static void callAnnotatedMethods(Object obj) {
        Class<?> mClass = obj.getClass();
        Method[] methods = mClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RepeatCount.class)) {
                int repeatCount = method.getAnnotation(RepeatCount.class).value();
                for (int i = 0; i < repeatCount; ++i) {
                    try {
                        method.setAccessible(true);
                        Class<?>[] types = method.getParameterTypes();
                        Object[] params = new Object[types.length];
                        for (int j = 0; j < types.length; ++j) {
                            params[j] = defaultValues.getOrDefault(types[j], null);
                        }
                        method.invoke(obj, params);
                    } catch (IllegalAccessException e) {
                        System.err.println("Не удалось получить доступ к методу: " + method.getName());
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        System.err.println("Метод " + method.getName() + " выбросил исключение: " + e.getTargetException());
                        e.getTargetException().printStackTrace();
                    } catch (IllegalArgumentException e) {
                        System.err.println("Некорректные аргументы для метода: " + method.getName());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        HandfulOfMethods handfulOfMethods = new HandfulOfMethods();
        try {
            callAnnotatedMethods(handfulOfMethods);
        }
        catch (Exception e) {
            System.err.println("Произошла ошибка во время выполнения:");
            e.printStackTrace();
        }
    }
}
