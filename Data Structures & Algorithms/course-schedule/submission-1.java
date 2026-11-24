class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map=new HashMap<>();
        int n=prerequisites.length;
       Set<Integer> visit=new HashSet<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());            
                for(int j=0;j<n;j++){
                    if(prerequisites[j][0]==i){
                        map.get(i).add(prerequisites[j][1]);
                    }
                }
            }
            for(int i=0;i<numCourses;i++){
                if(!dfs(map,visit,i)) return false;;
            }
            return true;
       
                         
    }
    public boolean dfs( HashMap<Integer, List<Integer>> map,Set<Integer> visit, int course){
            if(visit.contains(course)){
                return false;
            }
            if(map.get(course).size()==0){
                return true;
            }
            visit.add(course);
            for(int i:map.get(course)){
                if(dfs(map,visit,i)==false) return false;
            }
            visit.remove(course);
            map.get(course).clear();
            return true;
    }
    }


