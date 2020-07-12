package Sort;

import java.util.Arrays;

public class TestSelect {
    public static void selectSort(int[] a){
        //[0,array.length - bound)是未排序区域，[array.length - bound,array.length)是已排序区域
        //以bound位置元素作为擂主，打擂成功就交换位置
        for(int bound = 0; bound < a.length - 1; bound++){
            for(int cur = bound + 1; cur < a.length;cur++){
                //升序排序
                if(a[bound] > a[cur]){
                    int t = a[bound];
                    a[bound] = a[cur];
                    a[cur] = t;
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
