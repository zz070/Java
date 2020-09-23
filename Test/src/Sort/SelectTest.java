package Sort;

import java.util.Arrays;

public class SelectTest {
    public static void main(String[] args) {
        int[] array = {1,8,6,3,0,9,2,4,7,5};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        Ssort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }

    private static void Ssort(int[] array) {
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
}
