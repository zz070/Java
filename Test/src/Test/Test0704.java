package Test;

public class Test0704 {
    //希尔排序
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
    //快排
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
}
