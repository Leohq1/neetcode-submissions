class Solution {
    Map<Integer, List<Integer>> adjList;
    Set<Integer> seen;
    public int countComponents(int n, int[][] edges) {
        adjList = new HashMap<>();
        for(int i = 0; i < n; i++) adjList.put(i, new ArrayList<>());
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        seen = new HashSet<>();
        int result = 0;
        for(int i = 0; i < n; i++){
            if(!seen.contains(i)){
                result++;
                dfs(i);
            }
        }
        return result;
    }

    private void dfs(int node){
        List<Integer> neighbors = adjList.get(node);
        seen.add(node);
        for(int neighbor : neighbors){
            if(!seen.contains(neighbor)){
                dfs(neighbor);
            }
        }
    }
}
