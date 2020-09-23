package Sort;

import java.util.Arrays;

public class BubbleTest {
    private static void Bsort(int[] array){
        for(int i  = 0;i< array.length-1;i++){
            for(int j  = 0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int t = array[j+1];
                    array[j+1] = array[j];
                    array[j] = t;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1,8,6,3,0,9,2,4,7,5};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        Bsort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }
}
