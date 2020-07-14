package Test;

public class Test0714 {
    public static void quickSort(int[] array) {
        // 辅助完成递归过程
        // 此处为了代码简单, 区间设定成前闭后闭.
        quickSortHelper(array, 0, array.length - 1);
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            // 区间中有 0 个元素或者 1 个元素. 此时不需要排序
            return;
        }
        // 针对 [left, right] 区间进行整理
        // index 返回值就是整理完毕后, left 和 right 的重合位置. 知道了这个位置, 才能进一步进行递归
        int index = partition(array, left, right);
        quickSortHelper(array, left, index - 1);
        quickSortHelper(array, index + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int beg = left;
        int end = right;
        // 取最右侧元素为基准值
        int base = array[right];
        while (beg < end) {
            // 从左往右找到比基准值大的元素
            while (beg < end && array[beg] <= base) {
                beg++;
            }
            // 当上面的循环结束时, beg 要么和 end 重合, 要么 beg 就指向一个大于 base 的值

            // 从右往左找比基准值小的元素, 初始情况下, end = right. array[end] 就和 base 相等.
            // 此时要把这个基准值就直接跳过. 始终保持基准值位置就在原位.
            while (beg < end && array[end] >= base) {
                end--;
            }
            // 当上面的循环结束之后, beg 要门和 end 重合, 要么 end 就指向一个小于 base 的值

            // 交换 beg 和 end 的值
            swap(array, beg, end);
        }
        // 当 beg 和 end 重合的时候, 最后一步, 要把重合位置的元素和基准值进行交换
        // [思考] 为啥下面交换了之后, 仍然能满足快排的顺序要求呢?
        // right 这是一个序列中最后的位置. 就要求 beg end 重合位置的元素必须是大于等于基准值的元素, 才可以放到最后面.
        // 如何证明找到的  beg 位置的元素一定 >= 基准值呢?
        // a) beg++ 导致和 end 重合
        //    此时最终的值取决于上次循环中 end 指向的值. 上次循环中, end 应该是找到了一个小于基准值的元素, 然后和一个大于基准值的元素交换了.
        //    此处最终的 end 一定是大于基准值的元素
        // b) end-- 导致和 beg 重合
        //    此时上面 beg++ 的循环退出就一定是因为 beg 位置找到了一个比基准值大的元素, end 和 beg 重合最终元素也一定大于等于基准值.
        swap(array, beg, right);
        return beg;
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
