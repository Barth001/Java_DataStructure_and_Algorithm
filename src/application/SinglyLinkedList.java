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

    public void delete(int index){
        if(index < 0 || index > size - 1){
            System.out.println("Index is out of range");
            return;
        }
        Node current = head;
        Node previous = null;
        int i = 0;

        while (current != null && i != index){
            previous = current;
            current = current.next;
            i++;
        }
        if(previous == null){
            assert head != null;
            head = head.next;
        } else  {
            assert current != null;
            previous.next = current.next;
        }
        current.next = null;
        size++;
        System.out.println(this);
    }

    public void deleteObject(int data){
        Node current = head;
        Node previous = null;

        while (current != null && current.data != data){
            previous = current;
            current = current.next;
        }
        if(current == null){
            System.out.println("Data isn't in the system");
            return;
        }
        if(previous == null){
            head = head.next;
        } else  {
            previous.next = current.next;
        }
        current.next = null;
        size++;
        System.out.println(this);

    }

    public int get(int index){
        if(index < 0 || index > size - 1){
            System.out.println("Index is out of range");
            return Integer.MIN_VALUE;
        }
        Node current = find(index);
        return current.data;
    }

    private Node find(int index){
        Node current = head;
        int i = 0;
        while (current != null && i != index){
            current = current.next;
            i++;
        }
        return current;
    }

    public void set(int data, int index){
        if(index < 0 || index > size - 1){
            System.out.println("Index is out of range");
            return;
        }
        Node target = find(index);
        target.data = data;
        System.out.println(this);
    }

    public int indexOf(int data){
        Node current = head;
        int i = 0;
        int index = -1;
        while (current != null){
            if(current.data == data){
                index = i;
                break;
            }
            current = current.next;
            i++;
        }
        return index;
    }

    public int lastIndexOf(int data){
        Node current = head;
        int i = 0;
        int index = -1;
        while (current != null){
            if(current.data == data){
                index = i;
            }
            current = current.next;
            i++;
        }
        return index;
    }

    public boolean contain(int data){
        return indexOf(data) != -1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
        head = tail = null;
        size = 0;
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
        sll.add(71);
        sll.clear();
        System.out.println(sll.isEmpty());
    }
}
