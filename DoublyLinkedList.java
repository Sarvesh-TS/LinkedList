//Doubly linked list -
//Insert At Beginning
//Insert At End 
//Insert At Specific Position
//Delete At Beginning
//Delete At End
//Delete At Specific Position


class Node{
    int data;
    Node prev, next;
    
    Node(int data){
        this.data = data;
        this.prev = this.next =null;
    }
}

public class DoublyLinkedList{
    Node head;
    
    //Insert At Beginning
    public void InsertAtBeginning(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }
    
    //Insert At End
    public void InsertAtEnd(int data){
        Node newNode = new Node(data);
        
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next !=null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }
    
    //Insert At Specific Position
    public void InsertAtSpecificPosition(int data, int position){
        if(position<1){
            System.out.print("Invalid position");
            return;
        }
        if(position == 1){
            InsertAtBeginning(data);
            return;
        }
        
        Node temp = head;
        for(int i=1;i<position-1 && temp!=null;i++){
            temp = temp.next;
        }
        
        if(temp ==null){
            System.out.println("Position out of bounds");
            return;
        }
        
        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        
        if(temp.next!=null){
            temp.next.prev = newNode;
        }
        temp.next = newNode;
    }
    
    //Delete At Beginning
    public void DeleteAtBeginning(){
        if(head==null){
            return;
        }
        head = head.next;
        if(head!=null){
            head.prev = null;
        }
    }
    
    //Delete At End
      public void DeleteAtEnd() {
        if (head == null) {
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
        temp.prev = null;
    }

    
    //Delete At Specific position
    public void DeleteAtSpecificPosition(int position) {
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    if (position == 1) {
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return;
    }

    Node temp = head;
    for (int i = 1; i < position && temp != null; i++) {
        temp = temp.next;
    }

    if (temp == null) {
        System.out.println("Position out of range");
        return;
    }

    if (temp.prev != null) {
        temp.prev.next = temp.next;
    }

    if (temp.next != null) {
        temp.next.prev = temp.prev;
    }
}

    
    //displaying the list
    public void display(){
        Node temp = head;
        System.out.print("null <-> ");
        while(temp!=null){
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    public static void main(String[] args){
        DoublyLinkedList list = new DoublyLinkedList();
        list.InsertAtBeginning(10);
        list.InsertAtBeginning(20);
        list.InsertAtBeginning(30);
        list.InsertAtBeginning(40);
        list.InsertAtBeginning(50);
        
        list.InsertAtEnd(70);
        list.InsertAtEnd(80);
        list.InsertAtEnd(90);
        
        list.InsertAtSpecificPosition(60,6);
        
        list.DeleteAtBeginning();
        
        list.DeleteAtEnd();
        
        list.DeleteAtSpecificPosition(3);
        
        list.display();
    }
}