package application;

public class Queue {
    int size = 6;
    int[] arr = null;
    int front = 0;
    int rear = -1;
    public Queue(){
        this.arr = new int[size];
    }
    public Queue(int size){
        this.size = size;
        this.arr = new int[size];
    }
    public int length(){
        return rear+1;
    }
    public boolean isFull(){
        return length() == size;
    }
    public boolean isEmpty(){
        return length() == front;
    }
    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is filled up");
            return;
        }
        arr[++rear] = data;
        System.out.println(data+ " enqueue into queue");
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int data = arr[front];
        for(int i = front; i<rear; i++){
            arr[i] = arr[i+1];
        }
        rear--;
        System.out.println(data+ " dequeued");
    }
    public int rear(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }
    public int front(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public static void main(String[] args){
        Queue obj = new Queue();
        obj.enqueue(70);
        obj.enqueue(72);
        obj.enqueue(74);
        obj.enqueue(75);
        obj.enqueue(78);
        obj.enqueue(82);
        obj.enqueue(70);
        System.out.println("Front value: "+obj.front());
        System.out.println("Rear value: "+obj.rear());
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        obj.dequeue();
        System.out.println("Front value: "+obj.front());
        System.out.println("Rear value: "+obj.rear());
    }
}
