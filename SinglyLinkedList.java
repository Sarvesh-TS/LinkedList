class Node {
    int data;
    Node next;

    // constructor

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList {
    Node head;

    // Insert At Beginning
    public void InsertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert At End
    public void InsertAtEnd(int data) {
        Node temp = head;
        Node newNode = new Node(data);
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert At Specific Position
    public void InsertAtSpecificPosition(int data, int position) {
        if (position < 1) {
            System.out.println("Invalid Position");
            return;
        }
        if (position == 1) {
            InsertAtBeginning(data);
            return;
        }
        Node temp = head;
        Node newNode = new Node(data);
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
        } else {
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Delete At Beginning
    public void DeleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    // Delete At End
    public void DeleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Delete At Specific Position
    public void DeleteAtSpecificPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 1) {
            head = head.next; // delete 1st node
            return;
        }
        Node temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of range");
            return;
        }
        temp.next = temp.next.next; // skip over the node to delete
    }

    // displaying elements
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.InsertAtBeginning(10);
        list.InsertAtBeginning(20);
        list.InsertAtBeginning(30);
        list.InsertAtBeginning(40);
        list.InsertAtBeginning(50);

        list.InsertAtEnd(70);
        list.InsertAtEnd(80);
        list.InsertAtEnd(90);

        list.InsertAtSpecificPosition(60, 6);

        list.DeleteAtBeginning();

        list.DeleteAtEnd();

        list.DeleteAtSpecificPosition(3);

        list.display();
    }
}