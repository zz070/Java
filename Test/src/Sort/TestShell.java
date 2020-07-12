package Sort;

import java.util.Arrays;

public class TestShell {
    private static void shellSort(int[] array) {
        int gap = array.length/2;
        if(gap>1){
            insertSortGap(array,gap);  //对每一组进行排序
            gap/=2;  //每次组数依次减少
        }
        insertSortGap(array,1); //组数为1时，对所有元素进行排序
    }

    private static void insertSortGap(int[] array, int gap) {
        //还是和插入排序相同，通过 bound 来划分出两个区间
        // [0, bound) 已排序区间
        // [bound, size) 待排序区间
        //若gap=1，此时就是插入排序
        for(int bound = gap;bound<array.length;bound++){
            int val = array[bound];
            int cur = bound -gap; //cur位置是上一组的同一位置的元素
            for(;cur >=0;cur-=gap){
                if(array[cur]>val){
                    array[cur+gap] = array[cur];
                }else{
                    break;
                }
            }
            array[cur+gap] = val;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,3,0,9,2,4,7,5};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        shellSort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }
}
