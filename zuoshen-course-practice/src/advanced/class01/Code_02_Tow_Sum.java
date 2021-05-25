package advanced.class01;

public class Code_02_Tow_Sum {
    /**
     * 给定一个数组arr， 和一个整数aim， 请返回哪两个位置的数可以加出aim来。
     * 例如
     * arr = {2, 7, 11, 15}， target = 9
     * 返回{0,1}， 因为arr[0] + arr[1] = 2 + 7 = 9
     * 可以假设每个数组里只有一组答案
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target){
        int[] indices = new int[nums.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        sort(nums, indices);
        int left = 0;
        int right = nums.length;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum < target){
                left++;
            }else if (sum > target){
                right--;
            }else{
                return new int[]{indices[left], indices[right]};
            }
        }

        return new int[]{-1, -1};
    }

    public void sort(int[] nums, int[] indices){
        for (int i = 0; i < nums.length; i++) {
            heapInsert(nums, indices, i);
        }
        for (int i = nums.length; i >= 0; i--) {
            swap(nums, indices, 0, i);
            heapify(nums, indices, i);
        }
    }

    public void heapInsert(int[] nums, int[] indices, int i){
        while (i > 0){
            int p = (i - 1) / 2;
            if (nums[i] <= nums[p]){
                break;
            }
            swap(nums, indices, i, p);
            i = p;
        }
    }

    public void heapify(int[] nums, int[] indices, int size){
        int i = 0;
        int left = 1;
        int right = 2;
        int largest;
        while (left < size){
            largest = nums[left] > nums[i] ? left : i;
            largest = right < size && nums[right] > nums[largest] ? right : largest;
            if (largest == i){
                break;
            }
            swap(nums, indices, largest, i);
            i = largest;
            left = i * 2 + 1;
            right = i * 2 + 2;
        }

    }

    public void swap(int[] nums, int[] indices, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        temp = indices[i];
        indices[i] = indices[j];
        indices[j] = temp;
    }

}
