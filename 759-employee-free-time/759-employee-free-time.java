/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

// class Solution {
//     public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
//         List<Interval> merged = new ArrayList<>();
//         List<Interval> res = new ArrayList<>();
//         int lastEnd = 0;
        
//         for(int i = 0 ; i < schedule.size() ; i++) {
//             for(int j = 0 ; j < schedule.get(i).size() ; j++) {
//                 merged.add(schedule.get(i).get(j));
//             }
//         }
        
//         Collections.sort(merged, (a, b) -> a.start - b.start);
        
//         lastEnd = merged.get(0).end;
        
//         for(int i = 1 ; i < merged.size(); i++) {
//             int start = merged.get(i).start;
//             int end = merged.get(i).end;
            
//             if(lastEnd < start) {
//                 res.add(new Interval(lastEnd, start));
//             }
//             if(end > lastEnd) {
//                 lastEnd = end;
//             }
//         }
        
//         return res;
//     }
// }



/*

[[[1,2],[5,6]] , [[1,3]] ,   [[4,10]]]








*/



class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        
        List<Interval> busy = new ArrayList<>();
        int lastEnd = 0;
        List<Interval> free = new ArrayList<>();
        
        for(List<Interval> list : schedule) {
            for(Interval interval : list) {
                busy.add(interval);
            }
        }
        Collections.sort(busy, (int1, int2) -> int1.start - int2.start);
        
        lastEnd = busy.get(0).end;
        
        for(int i = 1 ; i < busy.size() ; i++) {
            int start = busy.get(i).start;
            int end = busy.get(i).end;
            
            if(start <= lastEnd) {
                lastEnd = Math.max(lastEnd, end);
            }
            else if(start > lastEnd) {
                free.add(new Interval(lastEnd, start));
                lastEnd = Math.max(lastEnd, end);
            }
        }
        return free;
    }
}



/*

[[[1,2],[5,6]],[[1,3]],[[4,10]]]

[3,4]

[1,2][5,6][1,3][4,10] 

[1,2][1,3][4,10][5,6] busy
      ^

lastEnd = 2


start = 1
end = 3

if(start < lastEnd) {
    //no free time
    //update lastEnd
}

*/











