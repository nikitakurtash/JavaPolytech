public abstract class Hordovie {
    private final String animal;
    protected Hordovie(String animal) {
        this.animal = animal;
    }
    @Override
    public String toString(){
        return animal;
    }
}
