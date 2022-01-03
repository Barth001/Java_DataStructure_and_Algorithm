package application;

public class CircularQueue {
    int size = 5;
    int[] arr = null;
    int front = 0;
    int rear = -1;
    int length = 0;

    public CircularQueue(){
        this.arr = new int[size];
    }
    //Parameter constructor
    public CircularQueue(int size){
        this.size = size;
        this.arr = new int[size];
    }
    public int length(){
        return length;
    }
    public boolean isFull(){
        return length() == size;
    }
    public boolean isEmpty(){
        return length() == 0;
    }
    public int front(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }
    public int rear(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is filled up");
            return;
        }
        rear = (rear + 1) % size;

        arr[rear] = data;
        length++;
        System.out.println(data+" enqueue into queue");
        System.out.println("Now rear is: "+rear);
    }
    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int data = arr[front];
        front = (front + 1) % size;
        length--;
        System.out.println(data+" dequeued");
        System.out.println("Front position is: "+front);
    }

    public static void main(String[] args){
        CircularQueue obj = new CircularQueue();
        obj.enqueue(70);
        obj.enqueue(74);
        obj.enqueue(76);
        obj.enqueue(78);
        obj.enqueue(80);
        obj.enqueue(70);
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        System.out.println("Size of queue is: "+obj.length());
        obj.enqueue(88);
        obj.enqueue(82);
        System.out.println("Front queue is: "+obj.front());
        System.out.println("Rear queue is: "+obj.rear());
    }
}
