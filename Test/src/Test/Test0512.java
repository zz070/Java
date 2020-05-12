package Test;

public class Test0512 {
    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++){
            System.out.println(i+"   a   "+i);
            Thread.sleep(1000);
        }
    }
}
