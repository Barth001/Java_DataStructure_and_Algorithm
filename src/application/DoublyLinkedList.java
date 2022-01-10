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

    public void insert(int data, int index){
        if(index < 0 || index > (size - 1)){
            System.out.println("Index is out of range");
        }
        Node newNode = new Node(data);
        Node current = findNode(index);
        Node previousNode = current.prev;
        if(current == head){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            previousNode.next = newNode;
            newNode.prev = previousNode;
        }
        newNode.next = current;
        current.prev = newNode;
        size++;
        System.out.println(this);
    }

    public int get(int index){
        if(index < 0 || index > (size - 1)){
            System.out.println("Index is out of range");
            return Integer.MIN_VALUE;
        }
        Node target = findNode(index);
        return target.data;
    }

    public Node findNode(int index){
        int mid = (size - 1)/2;
        if(index <= mid){
            return forwardFind(index);
        }
        return backwardFind(index);
    }

    private Node forwardFind(int index){
        int i = 0;
        Node current = head;
        while (current != null && i != index){
            current = current.next;
            i++;
        }
        return current;
    }

    private Node backwardFind(int index){
        int i = (size - 1);
        Node current = tail;
        while (current != null && i != index){
            current = current.next;
            i--;
        }
        return current;
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
        dll.add(74);
        System.out.println(dll.get(1));
        dll.insert(78, 0);
    }
}
