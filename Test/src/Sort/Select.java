package Sort;

import java.util.Arrays;

public class Select {
    public static void selectSort(int[] array){
        //升序排序
        //[0,array.length - bound)是未排序区域，[array.length - bound,array.length)是已排序区域
        //以bound位置元素作为擂主，打擂成功就交换位置
        for(int bound = 0;bound<array.length-1;bound++){
            for(int cur = bound+1;cur<array.length;cur++){
                if(array[bound]>array[cur]){
                    int t = array[bound];
                    array[bound] = array[cur];
                    array[cur] = t;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,3,0,9,2,4,7,5};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        selectSort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }
}
