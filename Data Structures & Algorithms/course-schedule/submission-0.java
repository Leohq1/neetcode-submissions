class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            adjList.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Deque<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.addLast(i);
            }
        }
        
        while(!q.isEmpty()){
            int temp = q.removeFirst();
            for(int neighbor : adjList.get(temp)){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    q.addLast(neighbor);
                }
            }
        }

        for(int i : inDegree){
            if(i != 0) return false;
        }
        return true;
    }
}