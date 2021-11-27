//https://leetcode.com/problems/sort-an-array/
class Solution {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void merge(int[] nums, int left, int right, int middle) {
        int i = left, j = middle + 1, k = 0;
        int[] sortedArray = new int[right - left + 1];
        while (i <= middle && j <= right) {
            if (nums[i] < nums[j]) {
                sortedArray[k] = nums[i];
                i++;
            }
            else {
                sortedArray[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i <= middle) {
            sortedArray[k] = nums[i];
            i++;
            k++;
        }
        while (j <= right) {
            sortedArray[k] = nums[j];
            j++;
            k++;
        }
        for (i = 0, j = left; i < sortedArray.length; i++, j++) {
            nums[j] = sortedArray[i];
        }
    }
    
    private void sort(int[] nums, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            
            sort(nums, l, m);
            sort(nums, m + 1, r);
            
            merge(nums, l, r, m);
        }
    }
}