class Solution {
    public boolean validTree(int n, int[][] edges) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(edges, (a, b) -> a[0] - b[0]);
        set.add(0);
        for(int[] edge : edges){
            if((set.contains(edge[0]) && set.contains(edge[1])) || 
                (!set.contains(edge[0]) && !set.contains(edge[1]))){
                return false;
            }
            set.add(edge[0]);
            set.add(edge[1]);
        }
        return true;
    }
}
