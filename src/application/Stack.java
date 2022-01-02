package application;

public class Stack {
    int[] arr = null;
    int size = 6;
    int top = -1;
    public Stack(){
        this.arr = new int[size];
    }
    public Stack(int size){
        this.size = size;
        this.arr = new int[size];
    }
    public boolean isEmpty(){
        return top - 1 == -1;
    }
    public boolean isFull(){
        return top + 1 == size;
    }
    public void push(int data){
        if(isFull()){
            System.out.println("Stack is full");
            return;
        }
        arr[++top] = data;
        System.out.println(data + " inserted");
    }
    public void pop(){
        if(isEmpty()){System.out.println("Stack is empty"); return;}
        int data = arr[top];
        top -= 1;
        System.out.println(data+ " removed");
    }
    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return arr[top];
    }
    public int length(){
        return top;
    }
    public static void main(String[] args){
        Stack obj = new Stack();
        obj.push(70);
        obj.push(71);
        obj.push(72);
        obj.push(73);
        obj.push(74);
        obj.push(88);
        System.out.println(obj.isFull());
        obj.push(99);
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        obj.pop();
        System.out.println(obj.isEmpty());
        obj.push(82);
        System.out.println(obj.peek());
        System.out.println(obj.length());
        System.out.println(obj.isEmpty());

    }
}
