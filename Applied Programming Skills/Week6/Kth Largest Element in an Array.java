import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        int pivot = nums[right];
        int pIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pIndex++);
            }
        }

        swap(nums, pIndex, right);

        if (pIndex == kSmallest) {
            return nums[pIndex];
        } else if (pIndex < kSmallest) {
            return quickSelect(nums, pIndex + 1, right, kSmallest);
        } else {
            return quickSelect(nums, left, pIndex - 1, kSmallest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
