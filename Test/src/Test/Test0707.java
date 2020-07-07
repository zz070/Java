package Test;

public class Test0707 {
    public static void shellSort(int[] array){
        //升序排序
        //先对整个数组进行分组
        int gap = array.length/2;   //分成的组数是元素数出除2
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

}
