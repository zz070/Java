package Sort;

import java.util.Arrays;

public class QuickT {
    public static void quickSort(int[] array){
        //辅助完成递归操作
        quickHelper(array,0,array.length-1);
    }

    private static void quickHelper(int[] array, int left, int right) {
        if(left >= right){
            //此时数组为空，或者只有一个元素不用排序
            return;
        }
        int index = partition(array,left,right);
        quickHelper(array,left,index-1);
        quickHelper(array,index+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int start = left;
        int end = right;
        //取最左侧元素为基准值
        int base = array[left];
        while(start < end){
            while(start < end && array[end] >= base){
                end--;
            }// 循环结束时，end指向小于base的值或者与start重合
            while(start<end  && array[start]<=base){
                start++;
            } // 循环结束时，start指向大于base的值或者与end重合
            swap(array,start,end);
        }
        swap(array,left,start);
        return start;
    }

    private static void swap(int[] array, int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }
    public static void main(String[] args) {
        int[] array = {6,3,8,4,2,9};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        quickSort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }
}
