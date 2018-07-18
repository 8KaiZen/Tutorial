public class AnimalList {
    private Animal[] thelist = new Animal[5];
    private int i = 0;

    public void add (Animal A){
        if (i < thelist.length) {
            thelist[i] = A;
            System.out.println("Animal added at index " + i);
            i++;
        }
    }

}
