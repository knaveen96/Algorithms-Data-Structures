class UndergroundSystem {

    Map<Integer, Pair<String, Integer>> checkIn;
    Map<String, Pair<Double,Double>> tracker;
    
    public UndergroundSystem() {
        checkIn = new HashMap<>();
        tracker = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String src = checkIn.get(id).getKey();
        String dest = stationName;
        String srcDest = src + "-" + dest;
        
        int checkInTime = checkIn.get(id).getValue();
        int checkOutTime = t;
        double totalTime = checkOutTime - checkInTime;
        double visitCount = 1.0; 
        
        if(tracker.containsKey(srcDest)) {
            visitCount += tracker.get(srcDest).getValue();
            totalTime += tracker.get(srcDest).getKey();
        }

        tracker.put(srcDest, new Pair<>(totalTime, visitCount));
        checkIn.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "-" + endStation;
        Double totalTime = tracker.get(routeKey).getKey();
        Double totalTrips = tracker.get(routeKey).getValue();
        return totalTime / totalTrips;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */


/*

map->  Integer, Pair<String, Integer>
45 leyton   3
32 paradise 8
27 leyton   10

map->
leyton-waterloo     12
paradise-cambridge  







*/











