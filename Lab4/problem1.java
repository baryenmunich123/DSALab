package Lab4;

public class problem1 {
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();

        list.delete(4);
        list.display();

        System.out.println("The position of the 4 is: " + list.search(4));
    }
}
