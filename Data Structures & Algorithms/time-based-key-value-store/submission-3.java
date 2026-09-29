class TimeMap {
  public record Pair<K, V>(K key, V value) {}
  HashMap<String,List<Pair<Integer,String>>> map;
    public TimeMap() {
        map=new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>(List.of(new Pair<Integer, String>(timestamp, value))));
        }  
        else{
            map.get(key).add(new Pair<Integer, String>(timestamp, value));
        }      
    }
    
    public String get(String key, int timestamp) {
        String res="";
        List<Pair<Integer,String>> val=new ArrayList<>();
        if(map.containsKey(key)){
        val=map.get(key);
        }
        int s=0;
        int e=val.size()-1;
        while(s<=e){
            int mid=(s+e)/2;
            if(val.get(mid).key<=timestamp){
                res=new String(val.get(mid).value);
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return res;


    }
}
