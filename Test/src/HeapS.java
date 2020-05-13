import java.util.Arrays;

public class HeapS {
    private static void HeapSort(int[] array) {
        //升序排序（建一个大根堆）
        //先建一个堆，将堆顶元素与堆的最后一个元素交换，并调整堆
        createHeap(array);
        //在这里，循环只进行array.length - 1次即可（最后堆中只剩一个元素的情况下，一定是有序的）
        for(int i = 0;i<array.length -1;i++){
            int heapSize = array.length - i; // 当前堆的元素个数
            swap(array,0,heapSize-1);
            heapSize--; //此时堆的长度减一
            shiftDown(array,heapSize,0);  //调整堆
        }
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private static void createHeap(int[] array) {
        //采用向下调整的方式建一个堆
        for(int i = (array.length-1-1)/2;i>=0;i--){
            /*i从 (array.length-1-1)/2开始的原因：
            （1）数组下标从0开始
            （2）已知叶子节点，计算双亲节点的方式：（child - 1）/2）
             */
            shiftDown(array,array.length,i);
        }
    }

    private static void shiftDown(int[] array, int heapSize, int index) {
        int parent = index;
        int child = 2*parent+1;  //此时的child并不知道是左子树还是右子树
        while(child < heapSize){
            if(child + 1 < heapSize && array[child + 1] > array[child]){
                child ++;
            }
            //此时child位置是左右子树中比较大的值
            if(array[child]>array[parent]){   //若孩子结点大于双亲结点，就交换
                swap(array,child,parent);
            }else{
                break;
            }
            //更新结点
            parent = child;
            child = parent*2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,8,6,3,0,9,2,4,7,5};
        System.out.print("排序前：");
        System.out.print(Arrays.toString(array));
        System.out.println();
        HeapSort(array);
        System.out.print("排序后：");
        System.out.print(Arrays.toString(array));
    }
}
