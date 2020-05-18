package Sort;

public class Test0518 {
    private static void mergeSort(int[] array){
        mergeHelper(array,0,array.length);     //用于辅助递归
    }

    private static void mergeHelper(int[] array, int left, int right) {
        if(right - left<= 1){
            //数组中元素个数为 1 或者为 0 时，认为本身是有序的
            return;
        }
        //开始递归分割数组
        int mid = (left+right)/2;
        mergeHelper(array,left,mid);  //执行到这里，[left,mid)排序成功
        mergeHelper(array, mid, right);//执行到这里，[mid，right)排序成功
        //将分割的数据合并
        merge(array,left,mid,right);
    }

    /*
    此时数组中的元素:
    [left,mid)是有序的
    [mid,right)是有序的
    现在要将它们合并在一个数组中
     */
    private static void merge(int[] array, int left, int mid, int right) {
        int[] output = new int[right - left];         //用于存放合并后的数组
        int outputNum = 0;         //记录output数组中元素的个数
        int cur1 = left;
        int cur2 = mid;
        while(cur1<mid  && cur2<right){
            if(array[cur1] <= array[cur2]){
                output[outputNum] = array[cur1];
                outputNum++;
                cur1++;
            }else {
                output[outputNum] = array[cur2];
                outputNum++;
                cur2++;
            }
        }//循环进行到这里cur1或者cur2，其中一定有一个已经到达结尾
        //此时再将剩余元素放入output中
        while(cur1 < mid){
            output[outputNum] = array[cur1];
            outputNum++;
            cur1++;
        }
        while(cur2 < right){
            output[outputNum] = array[cur2];
            outputNum++;
            cur2++;
        }//循环进行到这里所有的元素全都放到output中了
        //现在再将所有元素转移到array中
        for(int i = 0;i<right - left;i++){
            array[left+i] = output[i];
        }
    }

}
