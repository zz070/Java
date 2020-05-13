package Sort;

import java.util.Arrays;

public class Heap {
    private static void HeapSort(int[] array) {
        createHeap(array);
        // 循环把堆顶元素交换到最后. 并进行调整堆
        // 循环此时是 length - 1. 当堆中只剩一个元素的时候, 也就一定是有序的了.
        for (int i = 0; i < array.length - 1; i++) {
            // 当前堆的元素个数
            int heapSize = array.length - i;
            // 交换 堆顶元素 和 堆的最后一个元素
            // 堆的元素个数相当于 array.length - i
            // 堆的最后一个元素下标 array.length - i - 1
            // 取堆的最后一个元素
            int t=array[0];
            array[0] = array[heapSize -1];
            array[heapSize-1] =t;
            heapSize--; // 就把最后一个元素从堆中排除掉. 堆的 size 就 --

            // 交换完成之后, 要把最后一个元素从堆中删掉
            // 堆的长度就又进一步缩水了 array.length - i - 1
            // 数组中
            // [0, array.length - i - 1) 待排序区间
            // [array.length - i - 1, array.length) 已排序区间
            // [注意!!!!] 这个代码中的边界条件特别容易搞错~~ -1 还是 不减 还是 + 1, 最好代入数值来验证.
            // 例如可以验证下 i = 0 的时候, 咱们的逻辑是否合理.
            shiftDown(array, heapSize, 0);
        }
    }

    private static void createHeap(int[] array) {
        // 从最后一个非叶子节点出发向前循环, 依次进行向下调整
        for (int i = (array.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, array.length, i);
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        // 这里咱们是升序排序, 建立的是大堆. 大堆就需要找出左右子树中的较大值, 再和根节点比较
        int parent = index;
        int child = 2 * parent + 1;
        while (child < heapLength) {
            if (child + 1 < heapLength && array[child + 1] > array[child]) {
                child = child + 1;
            }
            // 条件结束意味着, child 就已经是左右子树比较大的值的下标了
            if (array[child] > array[parent]) {
                // 需要交换两个元素
                int t=array[child];
                array[child] = array[parent];
                array[parent] =t;
            } else {
                break;
            }
            parent = child;
            child = 2 * parent + 1;
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
