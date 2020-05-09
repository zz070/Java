package Sort;

import java.util.Arrays;

public class Test0509 {
    public static void insertSort(int[] array){
        //升序排序
        //一个元素的情况一定有序，bound从1考试
        for(int bound = 1;bound<array.length;bound++){
            int val = array[bound];
            int cur = bound-1;  //该位置的元素是有序区间的最后一个元素
            //在有序区间从后向前比较
            for(;cur>=0;cur--){
                if(array[cur]>val){
                    //遇见比val大的就将有序位置的元素向后挪一位
                    array[cur+1] = array[cur];
                }else{
                    //此时说明已经找到合适的位置
                    break;
                }
            }
            //循环结束,将val放到合适的位置
            array[cur+1] = val;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,3,0,9,2,4,7,5};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        insertSort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }
}
