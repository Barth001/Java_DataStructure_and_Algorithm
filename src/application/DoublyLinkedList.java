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

    public void delete(int index){
        if(index < 0 || index > (size - 1)){
            System.out.println("Index is out of range");
        }
        Node current = findNode(index);
        Node previousNode = current.prev;
        Node nextNode = current.next;
        if(current == head){
            head = head.next;
            head.prev = null;
        } else  if(current == tail){
            tail = tail.prev;
            tail.next = null;
        } else {
            previousNode.next = nextNode;
            nextNode.prev = previousNode;
            current.prev = current.next = null;
        }
        size--;
        System.out.println(this);
    }

    public void deleteObj(int data){
        Node current = head;
        while (current != null && current.data != data){
            current = current.next;
        }
        if (current == null){
            System.out.println("Data not found");
            return;
        }
        Node previousNode = current.prev;
        Node nextNode = current.next;
        if(current == head){
            head = head.next;
            if (head != null){
                head.prev = null;
            } else {
                head = tail = null;
            }
        } else  if(current == tail){
            tail = tail.prev;
            tail.next = null;
        } else {
            previousNode.next = nextNode;
            nextNode.prev = previousNode;
            current.prev = current.next = null;
        }
        size--;
        System.out.println(this);
    }

    public int indexOf(int data){
        int i = 0;
        Node current = head;
        while (current != null && current.data != data){
            current = current.next;
            i++;
        }
        if (current == null){
            return Integer.MIN_VALUE;
        }
        return i;
    }

    public int lastIndexOf(int data){
        int i = size - 1;
        Node current = tail;
        while (current != null && current.data != data){
            current = current.next;
            i--;
        }
        if (current == null){
            return Integer.MIN_VALUE;
        }
        return i;
    }

    public boolean contains(int data){
        return indexOf(data) >= 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        head = tail = null;
        size = 0;
    }
    public void set(int data, int index){
        if(index < 0 || index > (size - 1)){
            System.out.println("Index is out of range");
            return;
        }
        Node current = findNode(index);
        current.data = data;
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
        dll.add(74);
        dll.add(70);
        dll.set(78, 0);
//        System.out.println(dll.indexOf(70));
//        System.out.println(dll.lastIndexOf(70));
//        System.out.println(dll.contains(72));
//        System.out.println(dll.size());
//        System.out.println(dll.isEmpty());
//        dll.clear();
//        System.out.println(dll);
//        dll.deleteObj(74);
        //System.out.println(dll.get(2));
        //dll.insert(78, 2);
    }
}
