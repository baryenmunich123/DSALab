package Lab4;

public class CircularLinkedList {
    private Link last;
    private int size;

    private class Link {
        private Link next;
        private int data;

        public Link(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularLinkedList() {
        if (this.last != null) {
            this.last.next = last;
        }
    }

    public void insert(int data) {
        Link first = new Link(data);
        if (last == null) {
            first.next = first;

        } else {
            first.next = last.next;
            last.next = first;
        }
        last = first;
    }

    public void delete(int data) {
        System.out.println("After delete: ");
        if (last == null) {
            System.out.println("Nothing to delete");
        }
        Link previous = null;
        Link current = last;
        while (current.data != data) {
            if (current.next == last) {
                System.out.println("Cant find to delete");
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == last && current.next == last) {
            last = null;
        }
        if (current == last) {
            previous = last;
            while (previous.next != last) {
                previous = previous.next;
            }
            last = current.next;
            previous.next = last;
        } else if (current.next == last) {
            previous.next = last;
        } else {
            previous.next = current.next;
        }
    }

    public int search(int data) {
        Link current = last.next;
        int pos = 0;
        do {
            if (current.data == data) {
                return pos;
            } else {
                pos++;
            }
            current = current.next;
        } while (current != last.next);
        return pos;
    }

    public void Josephus() {
        Link current = last.next;
        int count = 0;
        do {
            size++;
            current = current.next;
        } while (current != last.next);

        while (size > 1) {
            count++;
            if (count == 3) {
                System.out.print(current.next.data + " ");
                current = current.next.next;
                count = 0;
                size--;
            } else {
                current = current.next;
            }
        }
    }

    public void display() {
        Link current = last.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != last.next);
        System.out.println();
    }
}
