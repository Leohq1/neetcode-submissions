class TimeMap {
    Map<String, List<TimeValue>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            map.get(key).add(new TimeValue(timestamp, value));
        } else{
            map.put(key, new ArrayList<>());
            map.get(key).add(new TimeValue(timestamp, value));
        }
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key) ||
            map.get(key).get(0).time > timestamp) return "";
        List<TimeValue> list = map.get(key);
        int left = 0;
        int right = map.get(key).size() - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            TimeValue cur = list.get(mid);
            if(cur.time == timestamp){
                return cur.value;
            }
            if(cur.time > timestamp){
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        if(list.get(right).time <= timestamp) return list.get(right).value;
        return list.get(right - 1).value;
    }

    private class TimeValue {
        public int time;
        public String value;

        public TimeValue(int time, String value) {
            this.time = time;
            this.value = value;
        }
    }
}
