// Link - https://leetcode.com/problems/search-in-rotated-sorted-array/description/

// Description -

// There is an integer array nums sorted in ascending order (with distinct values).
// Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

// Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:

// Input: nums = [4,5,6,7,0,1,2], target = 0
// Output: 4
// Example 2:

// Input: nums = [4,5,6,7,0,1,2], target = 3
// Output: -1
// Example 3:

// Input: nums = [1], target = 0
// Output: -1

class Solution {
    public int search(int[] nums, int target) {
        int pivot=getPivot(nums);
        if(nums[pivot]==target) return pivot;
        int ans=-1;
        if(nums[0]>target){
            ans=binarySearch(nums,target,pivot+1,nums.length-1);
            return ans;
        }
        ans=binarySearch(nums,target,0,pivot);
        return ans;
    }
    public int getPivot(int[] arr){
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid==e) return mid;
            if(arr[mid]>arr[mid+1])return mid;
            if(mid>s && arr[mid-1]>arr[mid])return mid-1;
            if(arr[s]>arr[mid]){
                e=mid-1;
            }
            else s=mid+1;
        }
        return -1;
    }
    public int binarySearch(int[] arr,int target, int s, int e){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]==target)return mid;
            else if(arr[mid]<target)s=mid+1;
            else e=mid-1;
        }
        return -1;
    }
}
