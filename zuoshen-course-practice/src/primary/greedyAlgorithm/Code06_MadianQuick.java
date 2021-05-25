package primary.greedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Code06_MadianQuick {
    /**
     * 一个数据流中， 随时可以取得中位数
     */
    public static class MedianHolder {

        PriorityQueue<Integer> minPQ;
        PriorityQueue<Integer> maxPQ;

        public MedianHolder(){
            this.maxPQ = new PriorityQueue<>(new MaxComparator());
            this.minPQ = new PriorityQueue<>(new MinComparator());
        }

        private void modifyTwoHeapSize(){
            if (this.maxPQ.size() == this.minPQ.size() + 2){
                this.minPQ.add(this.maxPQ.poll());
            }
            if (this.minPQ.size() == this.maxPQ.size() + 2){
                this.maxPQ.add(this.minPQ.poll());
            }
        }

        public void addNumber(int num){
            if (maxPQ.isEmpty() || num < maxPQ.peek()){
                maxPQ.add(num);
            }else{
                minPQ.add(num);
            }
            modifyTwoHeapSize();
        }

        public Integer getMedian(){
            int maxSize = maxPQ.size();
            int minSize = minPQ.size();
            if (maxSize + minSize == 0){
                return null;
            }
            if (maxSize == 0 || minSize == 0){
                return maxSize == 0 ? minPQ.peek() : maxPQ.peek();
            }

            int minHead = minPQ.peek();
            int maxHead = maxPQ.peek();
            if ((minSize + maxSize) % 2 == 0){
                return (minHead + maxHead) / 2;
            }
            return minSize > maxSize ? minHead : maxHead;
        }

    }

    public static class MinComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 > o2){
                return 1;
            }else {
                return -1;
            }
        }
    }

    public static class MaxComparator implements Comparator<Integer>{

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o1 < o2){
                return 1;
            }else {
                return -1;
            }
        }
    }

    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }

    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.addNumber(arr[j]);
            }
            if (medianHold.getMedian() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");

    }
}
