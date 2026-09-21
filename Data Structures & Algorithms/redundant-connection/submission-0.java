class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Dsu dsu = new Dsu();
        for(int[] edge : edges){
            if(!dsu.union(edge[0] - 1, edge[1] - 1)) return edge;
        }
        return new int[]{-1, -1};
    }

    private class Dsu{
        int[] parent;
        int[] rank;

        public Dsu(){
            parent = new int[1000];
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
            }
            rank = new int[1000];
        }
        
        public Dsu(int n){
            parent = new int[n];
            for(int i = 0; i < parent.length; i++){
                parent[i] = i;
            }
            rank = new int[n];
        }

        public int find(int node){
            if(node == parent[node]){
                return node;
            }
            rank[node] = 0;
            parent[node] = find(parent[node]);
            return parent[node];
        }

        public boolean union(int node1, int node2){
            int parent1 = find(node1);
            int parent2 = find(node2);
            if(parent1 == parent2) return false;
            if(rank[parent1] > rank[parent2]){
                parent[parent2] = parent1;
            } else if(rank[parent1] < rank[parent2]){
                parent[parent1] = parent2;
            } else{
                parent[parent2] = parent1;
                rank[parent1]++;
            }
            return true;
        }
    }
}