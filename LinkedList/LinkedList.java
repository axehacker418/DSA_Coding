package LinkedList;
public class LinkedList {

    // to create a linked list using Node class make class static alwyas

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Now to create operation on the LinkedlISt for that we need head and tail of
    // the linkedlist

    public static Node head;
    public static Node tail;
    // to acess linkedlist;

    public static int llsize = 0;

    // cteate functions : add first and add last

    public void addfirst(int data) {

        // to create at first i need to access head
        // then create newnode
        // newnode link =head
        // head= newnode
        // base case nothing in the list

        Node newNode = new Node(data);
        llsize++;

        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addlast(int data) {
        // create Newnode -> search last node ; tail.next = newnode thean tail =newnode

        Node newnNode = new Node(data);
        llsize++;

        // base case
        if (head == null) {
            head = tail = newnNode;
            return;
        }

        tail.next = newnNode;
        tail = newnNode;
    }

    public void addidx(int data, int idx) {
        if (idx == 0) {
            addfirst(data);
            return;
        }
        Node newNode = new Node(data);
        llsize++;

        Node temp = head;
        int i = 0; // index

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // prev node found
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void deletefirst() {
        // head = head.next thats all
        // head.next ==null

        int value = 0;
        // base case
        if (head == null || llsize == 0) {
            System.out.println("List is empty fill it first");
            return;
        } else if (llsize == 1 || head.next == null) {
            value = head.data;
            head = tail = null;
            llsize--;
            return;

        }
        // remove
        value = head.data;
        head = head.next;
        llsize--;
        System.out.println("value " + value + " has been deleted! ");

    }

    public void deletelast() {
        // last mean tail-1=null

        if (head == null) {
            System.out.println("List is empty Bro!");
            return;
        } else if (head.next == null) {
            head = tail = null;
            return;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;
    }

    public void deleteAt(int idx) {
        if (head == null) {
            System.out.println("List is empty — cannot delete from any index!");
            return;
        }

        // Case 1: delete at index 0 (first node)
        if (idx == 0) {
            System.out.println("Deleted value: " + head.data);
            head = head.next;
            if (head == null) { // if list became empty
                tail = null;
            }
            return;
        }

        Node temp = head;
        int i = 0;

        // Traverse until the node *before* the one to delete
        while (i < idx - 1 && temp.next != null) {
            temp = temp.next; //prev one 
            i++;
        }

        // If index is out of bounds
        if (temp.next == null) {
            System.out.println("Index out of range — cannot delete!");
            return;
        }

        System.out.println("Deleted value: " + temp.next.data);

        // Delete the node
        temp.next = temp.next.next;

        // If last node was deleted, update tail
        if (temp.next == null) {
            tail = temp;
        }
    }

    public void search() {

        
    }

    public static void main(String[] args) {

        LinkedList l1 = new LinkedList();

        // manual value insertion into array

        // l1.head=new Node(1);
        // l1.head.next=new Node(2);
        // l1.printList();

        // through function value insertion

        l1.addfirst(2);
        l1.addlast(3);
        l1.addidx(1, 1);
        System.out.println("Size of the Linkedlist is " + llsize);

        System.out.println("list is this ");
        l1.printList();

    }

    // print function for this LinkedList

    public void printList() {
        // call temp = head then temp next = head next then same again

        if (head == null) {
            System.out.println("this Linked list is empty Buddy!");
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.printf("null");
    }

}
