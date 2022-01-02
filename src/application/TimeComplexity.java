package application;

public class TimeComplexity {
    public static void main(String[] args){
        double timeStarted = System.currentTimeMillis();
        TimeComplexity obj = new TimeComplexity();
        System.out.println(obj.findSum(8888888));

        System.out.println("It took "+ (System.currentTimeMillis() - timeStarted)+ " MS");


    }
//    public int findSum(int n){
//        return n * (n + 1) / 2;
//    }
    public int findSum(int n){
        int sum = 0;
        for(int i = 0; i <= n; i++){
            sum += i;
        }
        return sum;
    }
}
