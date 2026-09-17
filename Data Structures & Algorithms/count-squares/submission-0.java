class CountSquares {

    List<int[]> points;
    Map<String, Integer> map;

    public CountSquares() {
        points = new ArrayList<>();
        map = new HashMap<>();
    }

    public void add(int[] point) {

        points.add(point);

        String key = point[0] + "," + point[1];

        map.put(key, map.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {

        int px = point[0];
        int py = point[1];

        int res = 0;

        for (int[] p : points) {

            int x = p[0];
            int y = p[1];

            // Must be a diagonal point
            if (Math.abs(px - x) != Math.abs(py - y) || x == px || y == py)
                continue;

            String key1 = px + "," + y;
            String key2 = x + "," + py;

            res += map.getOrDefault(key1, 0)
                 * map.getOrDefault(key2, 0);
        }

        return res;
    }
}