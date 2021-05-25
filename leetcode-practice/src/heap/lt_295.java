package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class lt_295 {

}

/**
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * 例如，
 * [2,3,4] 的中位数是 3
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * 设计一个支持以下两种操作的数据结构：
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 */
class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    /** initialize your data structure here. */
    public MedianFinder() {
        this.minHeap = new PriorityQueue<>(new MinComparator());
        this.maxHeap = new PriorityQueue<>(new MaxComparator());
    }

    public void modifyHeapSize(){
        if (this.minHeap.size() == this.maxHeap.size() + 2){
            this.maxHeap.add(this.minHeap.poll());
        }
        if (this.maxHeap.size() == this.minHeap.size() + 2){
            this.minHeap.add(this.minHeap.poll());
        }
    }

    public void addNum(int num) {
        if (this.maxHeap.isEmpty() || num < this.maxHeap.peek()){
            this.maxHeap.add(num);
        }else {
            this.minHeap.add(num);
        }
        modifyHeapSize();
    }

    public double findMedian() {
        int maxSize = this.maxHeap.size();
        int minSize = this.minHeap.size();
        if (maxSize + minSize == 0){
            return 0;
        }
        if (minSize == 0 || maxSize == 0){
            return minSize == 0 ? maxHeap.peek() : minHeap.peek();
        }
        double maxHead = (double)maxHeap.peek();
        double minHead = (double)minHeap.peek();
        if ((minSize + maxSize) % 2 == 0){
            return (maxHead + minHead) / 2;
        }else {
            return maxSize > minSize ? maxHead : minHead;
        }
    }

    class MinComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2){
                return 1;
            }
            return -1;
        }
    }

    class MaxComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2){
            if (o2 > o1){
                return 1;
            }
            return -1;
        }
    }
}
