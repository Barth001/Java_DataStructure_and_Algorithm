package application;

public class StackUsingDll {
    private DoublyLinkedList list = null;
    public StackUsingDll(){
        this.list = new DoublyLinkedList();
    }
    public void push(int data){
        list.add(data);
        System.out.println(data+" is added");
    }
    public void pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            return;
        }
        int data = peek();
        list.deleteObj(data);
        System.out.println("Successfully deleted");
    }
    public int peek(){
        return list.get(size() - 1);
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public String toString(){
        return list.toString();
    }

    public static void main(String[] args) {
        StackUsingDll st = new StackUsingDll();
        st.push(77);
        st.push(74);
        st.push(72);
        st.pop();
        st.pop();
        st.pop();
    }
}
