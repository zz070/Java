package Sort;

import java.util.Arrays;

public class BubbleS {
    //升序排序
    public static void bubbleSort(int[] array){
        //采用从后往前的方式进行交换
        //已排序区域[0,bound)
        //未排序区域[bound,array.length)
        for(int bound = 0;bound<array.length-1;bound++){
            for(int cur = array.length - 1;cur > bound;cur--){
                if(array[cur-1]>array[cur]){
                    swap(array,cur-1,cur);
                }
            }
        }
    }
    public static void bubbleSort2(int[] array){
        //采用从前往后的方式进行交换
        //已排序区域[bound,array.length)
        //未排序区域[0,bound)
        for(int bound = 0;bound<array.length-1;bound++){
            for(int cur = 0;cur<array.length-bound-1;cur++){
                if(array[cur+1]<array[cur]){
                    swap(array,cur+1,cur);
                }
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,3,0,9,2,4,7,5};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        bubbleSort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        bubbleSort2(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }
}
