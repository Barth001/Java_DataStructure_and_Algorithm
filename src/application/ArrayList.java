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
        if(index > (length - 1)){
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

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < length; i++){
            sb.append(arr[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args){
        ArrayList obj = new ArrayList();
        obj.add(70);
        obj.add(72);
        obj.add(74);
        obj.add(78);
        obj.add(80);
        obj.insert(86, 3);
        obj.add(82);
        obj.add(88);
        obj.add(71);
        obj.add(70);
        obj.add(72);
        obj.add(74);
        obj.add(78);
        obj.add(80);
        obj.add(70);
        System.out.println(obj);

    }
}
