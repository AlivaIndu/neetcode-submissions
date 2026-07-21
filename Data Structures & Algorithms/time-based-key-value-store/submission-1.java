class TimeMap {

    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key,new ArrayList<>());
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";

        String res = "";
        List<Pair> list = map.get(key);
        int l=0,h=list.size()-1;

        while(l<=h){
            int mid = l+(h-l)/2;
            if(list.get(mid).timestamp<=timestamp)
            {
                res = list.get(mid).value;
                l=mid+1;
            }
            else h=mid-1;
        }

        return res;
    }

    class Pair{
        String value;
        int timestamp;

        Pair(String value,int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
}

