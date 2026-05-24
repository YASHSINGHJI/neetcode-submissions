public class TimeMap {
    HashMap<String, HashMap<Integer,List<String>>> hashMap;

    public TimeMap() {
        hashMap=new HashMap<>();        
    }
    
    public void set(String key, String value, int timestamp) {       
        if(!hashMap.containsKey(key)){
            hashMap.put(key,new HashMap<>());
        } 
        if(!hashMap.get(key).containsKey(timestamp)){
            hashMap.get(key).put(timestamp,new ArrayList<>());
        }
        hashMap.get(key).get(timestamp).add(value);        
        
    }
    
    public String get(String key, int timestamp) {
        if(!hashMap.containsKey(key)) return "";
        int seen=0;
        for(int time:hashMap.get(key).keySet()){
            if(time<=timestamp){
                seen=Math.max(time, seen);
            }
        }        
        if(seen==0) return "";
        int temp=hashMap.get(key).get(seen).size()-1;
        return hashMap.get(key).get(seen).get(temp);
    }
}
