package application;

public class SinglyLinkedList {
    Node head;
    Node tail;
    int size = 0;

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
           tail.next = newNode;
        }
        tail = newNode;
        size++;
        System.out.println(this);
    }

    public void insert(int data, int index){
        if(index < 0 || index > size - 1){
            System.out.println("Index is out of range");
        } else {
            Node current = head;
            Node previous = null;
            int i = 0;
            while (current != null && i != index){
                previous = current;
                current = current.next;
                i++;
            }
            Node newNode = new Node(data);
            if(previous == null){
                newNode.next = head;
                head = newNode;
            } else {
                previous.next = newNode;
                newNode.next = current;
            }
            size++;
            System.out.println(this);
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null){
            sb.append(current.data).append("-->");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.add(70);
        sll.add(71);
        sll.add(73);
        sll.insert(80, 0);
        sll.insert(78, 3);
    }
}
