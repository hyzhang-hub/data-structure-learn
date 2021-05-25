package advanced.class01;

public class Code_08_PrintUniquePairAndTriad {

    /**
     * 给定一个数组arr， 和一个整数aim， 请返回哪两个位置的数可以加出aim来。
     * @param arr
     * @param k
     */
    public static void printUniquePair(int[] arr, int k){
        if (arr == null || arr.length < 2){
            return;
        }

        int left = 0;
        int right = arr.length - 1;
        while (left < right){
            if (arr[left] + arr[right] < k){
                left++;
            }else if (arr[left] + arr[right] > k){
                right++;
            }else {
                if (left == 0 || arr[left] != arr[left - 1]){

                    System.out.println(arr[left] + "," + arr[right]);
                }
                left++;
                right--;
            }
        }
    }

    String str=null;

    public static void printUnique(){

    }
}
