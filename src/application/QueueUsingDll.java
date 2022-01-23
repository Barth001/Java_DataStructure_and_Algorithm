package application;

public class QueueUsingDll {

    private DoublyLinkedList list = null;
    public QueueUsingDll(){
        this.list = new DoublyLinkedList();
    }
    public void enqueue(int data){
        list.add(data);
        System.out.println(data + " Added into the queue");
    }
    public int front(){
        return list.get(0);
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int data = front();
        list.delete(0);
        System.out.println(data + " successfully removed");
    }
    public int sizeOf(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int rear(){
        return list.get(sizeOf() - 1);
    }
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args) {
        QueueUsingDll qdll = new QueueUsingDll();
        qdll.enqueue(70);
        qdll.enqueue(71);
        qdll.enqueue(74);
        qdll.enqueue(78);
        qdll.enqueue(72);
        qdll.dequeue();
        qdll.enqueue(80);
        qdll.dequeue();
        System.out.println(qdll);
    }
}
