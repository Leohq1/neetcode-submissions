class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edge : prerequisites){
            adjList.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
        }

        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;

        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                q.addLast(i);
                result[index] = i;
                index++;
            }
        }

        while(!q.isEmpty()){
            int cur = q.removeFirst();
            List<Integer> neighbors = adjList.get(cur);
            for(int neighbor : neighbors){
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0){
                    result[index] = neighbor;
                    index++;
                    q.addLast(neighbor);
                }
            }
        }
        for(int i : inDegree){
            if(i != 0){
                return new int[]{};
            }
        }
        return result;
    }
}