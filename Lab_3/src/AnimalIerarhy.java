import java.util.LinkedList;
import java.util.List;

public class AnimalIerarhy {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){
        LinkedList<Mlekopit> animals = new LinkedList<>(List.of(
                new Manul("Манул Папа"), new Manul("Манул Мама"), new Manul("Маленький мануленок"),
                new Rus("Рысь Папа"), new Rus("Рысь Мама"), new Rus("Маленький рысенок"),
                new BasedEj("Ёж Папа"), new BasedEj("Ёж Мама"), new BasedEj("Маленький еженок")
        ));

        LinkedList<Ejovie> ejiki = new LinkedList<>();
        LinkedList<Cats> manulu = new LinkedList<>();
        LinkedList<Hishnie> rusi = new LinkedList<>();

        segregate(animals, ejiki, manulu, rusi);
    }
    public static void test2(){
        LinkedList<Hishnie> animals = new LinkedList<>(List.of(
                new Manul("Манул Папа"), new Manul("Манул Мама"), new Manul("Маленький мануленок"),
                new Rus("Рысь Папа"), new Rus("Рысь Мама"), new Rus("Маленький рысенок")
        ));

        LinkedList<Hordovie> ejiki = new LinkedList<>();
        LinkedList<Manul> manulu = new LinkedList<>();
        LinkedList<Cats> rusi = new LinkedList<>();

        segregate(animals, ejiki, manulu, rusi);
    }
    public static void test3(){
        LinkedList<Ejovie> animals = new LinkedList<>(List.of(
                new BasedEj("Ёж Папа"), new BasedEj("Ёж Мама"), new BasedEj("Маленький еженок")
        ));

        LinkedList<Nasekomoyadnie> ejiki = new LinkedList<>();
        LinkedList<Hishnie> manulu = new LinkedList<>();
        LinkedList<Hishnie> rusi = new LinkedList<>();

        segregate(animals, ejiki, manulu, rusi);
    }
    public static void segregate(LinkedList<? extends Hordovie> SrcCollection, LinkedList<? super BasedEj> Collection1, LinkedList<? super Manul> Collection2, LinkedList<? super Rus> Collection3){
        for (Hordovie animal : SrcCollection){
            if(animal instanceof BasedEj){
                Collection1.add((BasedEj) animal);
            } else if(animal instanceof Manul){
                Collection2.add((Manul) animal);
            } else if(animal instanceof Rus){
                Collection3.add((Rus) animal);
            }
        }

        System.out.println("Список лесных животных: " + printList(SrcCollection));
        System.out.println("Семья ежей: " + printList(Collection1));
        System.out.println("Семья манулов: " + printList(Collection2));
        System.out.println("Семья рысей: " + printList(Collection3));
    }

    private static String printList(LinkedList<?> list){
        return list.toString().replaceAll("^\\[|\\]$", "");
    }
}