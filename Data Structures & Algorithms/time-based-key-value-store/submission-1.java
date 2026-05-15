class Time {
    String value;
    int timestamp;

    public Time(String value, int timestamp) {
        this.timestamp = timestamp;
        this.value = value;
    }
}

public class TimeMap {
    Map<String, ArrayList<Time>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Time(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String res = "";
        if (map.containsKey(key)) {
            ArrayList<Time> values = map.get(key);
            int target = timestamp;
            int start = 0;
            int end = values.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (values.get(mid).timestamp <= target) {
                    res = values.get(mid).value;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return res;
    }
}