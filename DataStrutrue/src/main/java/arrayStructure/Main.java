package arrayStructure;

public class Main {
    public static void main(String[] args) {
        Myarray arr = new Myarray();

        arr.insert(90);
        arr.insert(344);
        arr.insert(128);

        arr.display();

//        System.out.println(arr.search(55));
//        System.out.println(arr.get(2));
//
//        arr.delete(2);
//        arr.display();
//        arr.change(0,12);
//        arr.display();
        System.out.println(arr.binarySearch(344));
    };
}
