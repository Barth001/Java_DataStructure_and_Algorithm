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

    public int get(int index){
        if(index < 0 || index > (size - 1)){
            System.out.println("Index is out of range");
            return Integer.MIN_VALUE;
        }
        int mid = (size - 1)/2;
        Node target;
        if(index > mid){
            target = forwardFind(index);
        } else {
            target = backwardFind(index);
        }
        return target.data;
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
        int i = size - 1;
        Node current = tail;
        while (current != null && i != index){
            current = current.next;
            i++;
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
        System.out.println(dll.get(0));
    }
}
