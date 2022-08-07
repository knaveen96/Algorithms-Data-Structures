class MyCalendar {

    List<int[]> calendar;
    
    public MyCalendar() {
        calendar = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] slot : calendar) {
            int oldStart = slot[0];
            int oldEnd = slot[1];
            
            if((oldStart <= start && start < oldEnd) || 
               (oldStart < end && end < oldEnd) || 
               (start < oldStart && end >= oldEnd)) {
                return false;
            }
        }
        calendar.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

/*


[[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
                              ^
[null,true,true,false,true,true,false,true,true,true,false]
[null,true,true,false,false,true,false,true,true,true,false]

[47,50] [33,41] []


- if newstart lies b/w oldstart and oldend return false
- if newend lies b/w oldstart and oldend return false
- if (newstart < oldstart) && (newend > oldend) return false





*/