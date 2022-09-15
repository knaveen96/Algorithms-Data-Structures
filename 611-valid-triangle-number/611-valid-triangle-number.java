class Solution {
    public int triangleNumber(int[] nums) {
        
        if(nums.length < 3) return 0;
        int res = 0;
        Arrays.sort(nums);
        
        for(int c = 2 ; c < nums.length ; c++) {
            int b = c - 1;
            int a = 0;
            
            while(a < b) {
                if(nums[a] + nums[b] > nums[c]) {
                    res += b - a;
                    b--;
                }
                else {
                    a++;
                }
            }
        }
        return res;
    }
}

/*
check for
a + b > c
(a,b,c)

a+b > c
b+c > a
c+a > b


 0 1 2 3 4
[4,2,3,5,4]


 0 1 2 3 4
[2,3,4,4,5]
         c
 a     b
 
 res = 1 + 2 + 3



- to find the 3rd element;
    - 3rd element should be < sum of the other 2 elements 
    - 3rd element should be > Math.abs(a-b)

*/