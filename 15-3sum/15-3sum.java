class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length-2; i++) {
            if(i ==0 || (i>0 && nums[i] != nums[i-1])) {
                //int sum = 0 - nums[i];
                int left = i+1;
                int right = nums.length-1;
                
                while(left < right) {
                    if(nums[left] + nums[right] + nums[i] == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        
                        while(left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        
                        while(left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if(nums[left] + nums[right] + nums[i] > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return res;
    }
}