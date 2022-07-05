class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        List<Integer> res = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        
        while(p1 < slots1.length && p2 < slots2.length) {
            
            int start1 = slots1[p1][0];
            int end1 = slots1[p1][1];
            int start2 = slots2[p2][0];
            int end2 = slots2[p2][1];
            
            int freeTimeStart = Math.max(start1, start2);
            int freeTimeEnd = Math.min(end1, end2);
            
            if(freeTimeEnd - freeTimeStart >= duration) {
                
                res.add(freeTimeStart);
                res.add(freeTimeStart + duration);
                
                return res;
            }
            
            if(end2 > end1) {
                p1++;
            } else if(end1 > end2) {
                p2++;
            } else {
                p1++;
                p2++;
            }
        }
        
        return res;
    }
}


/*

slots1 = [[10,50],[60,120],[140,210]] 
            ^
slots2 = [[0,15],[60,70]]
                    ^
duration = 8


start1 = 10
end1 = 50

start2 = 0
end2 = 15

[10,15]



*/