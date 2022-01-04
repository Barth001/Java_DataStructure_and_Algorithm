package application;

public class ArrayList {
    int size = 10;
    int length = 0;
    int[] arr = null;

    public ArrayList(){
        this.arr = new int[size];
    }
    public ArrayList(int size){
        this.size = size;
        this.arr = new int[size];
    }

    private void increaseSize(){
        if(length == size){
            System.out.println("Array is overflowing");
            size = size + size / 2;
            System.out.println("New size is "+size);
            int[] newArr = new int[size];
            for (int i = 0; i < length; i++){
                newArr[i] = arr[i];
            }
            this.arr = newArr;
        }
    }

    public void add(int data){
        increaseSize();
        arr[length] = data;
        System.out.println(data+ " added at index "+length);
        length++;
    }

    public void insert(int data, int index){
        if(index > (length - 1) || index < 0){
            System.out.println("index out of position");
            return;
        }
        increaseSize();
        for(int i = length; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = data;
        System.out.println(data+ " inserted at index "+ index);
        length++;
    }

    public void delete(int index){
        if(index > (length - 1) || index < 0){
            System.out.println("index out of position");
        }
        int data = arr[index];
        for(int i = index; i < length-1; i++){
            arr[i] = arr[i+1];
        }
        length--;
        System.out.println(data+" is deleted from the list");
    }

    public void deleteObj(int data){
        delete(indexOf(data));
    }

    public int indexOf(int data){
        int index = -1;
        for(int i = 0; i < length; i++){
            if(arr[i] == data){
                index = i;
                break;
            }
        }
        return index;
    }
    public int lastIndexOf(int data){
        int index = -1;
        for(int i = length-1; i >= 0; i--){
            if(arr[i] == data){
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean contain(int data){
        return indexOf(data) != -1;
    }

    public int length(){
        return length;
    }

    public void clear(){
        this.length = 0;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < length; i++){
            sb.append(arr[i]).append(",");
        }
        if(sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        ArrayList obj = new ArrayList();
        obj.add(70);
        obj.add(72);
        obj.add(74);
        obj.add(78);
        System.out.println("List is empty: "+obj.isEmpty());
        obj.add(80);
        obj.add(70);
        obj.insert(86, 3);
        obj.add(82);
        obj.delete(3);
        obj.deleteObj(78);
        System.out.println("Is 82 in the list: "+obj.contain(82));
        System.out.println("Is 99 in the list: "+obj.contain(99));
        System.out.println("Index is: "+obj.indexOf(70));
        System.out.println("last Index is: "+obj.lastIndexOf(70));
        System.out.println("list length is: "+obj.length());
        System.out.println(obj);
        obj.clear();
        System.out.println("List is empty: "+obj.isEmpty());
        System.out.println(obj);

    }
}
