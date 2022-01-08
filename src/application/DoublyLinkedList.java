package application;

public class DoublyLinkedList {
    Node head;
    Node tail;
    int size = 0;

    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data = data;
        }
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        System.out.println(this);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head;
        while (current != null){
            sb.append("<--").append(current.data).append("-->");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.add(70);
        dll.add(72);
    }
}
