package Sort;

import java.util.Arrays;

public class Bubble {
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j = 0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int t=array[j];
                    array[j]=array[j+1];
                    array[j+1] = t;
                }
            }
        }
    }
    public static void bubbleSort1(int[] array) {
        // 按照每次找最小的方式来进行排序. (从后往前比较交换)
        for (int bound = 0; bound < array.length; bound++) {
            // [0, bound) 已排序区间
            // [bound, size) 待排序区间
            // cur > bound 而不是 >= , 当 bound 为 0 的时候, 如果 >= , cur 也为 0, cur - 1 也就下标越界了
            for (int cur = array.length - 1; cur > bound; cur--) {
                // 此处 cur - 1 是因为 cur 初始值是 array.length - 1. 如果取 cur + 1 下标的元素, 就越界了
                // 此处的条件如果写成 >= 同样无法保证稳定性
                if (array[cur - 1] > array[cur]) {
                    int t=array[cur];
                    array[cur]=array[cur-1];
                    array[cur-1] = t;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {1,8,6,3,0,9,2,4,7,5};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        bubbleSort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }
}
