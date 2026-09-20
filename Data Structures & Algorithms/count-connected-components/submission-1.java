class Solution {
    public int countComponents(int n, int[][] edges) {
        Dsu dsu = new Dsu(n);
        for(int[] edge : edges){
            dsu.union(edge[0], edge[1]);
        }
        return dsu.groups();
    }

    private class Dsu{
        private int[] parent;
        private int[] rank;
        
        public Dsu(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
            rank = new int[n];
        }

        public int find(int node){
            if(node == parent[node]){
                return node;
            }
            parent[node] = find(parent[node]);
            return parent[node];
        }

        public void union(int node1, int node2){
            int parent1 = find(node1);
            int parent2 = find(node2);

            if(parent1 == parent2) return;

            if(rank[parent1] < rank[parent2]){
                parent[parent1] = parent2;
            } else if(rank[parent1] > rank[parent2]){
                parent[parent2] = parent1;
            } else{
                parent[parent2] = parent1;
                rank[parent1]++;
            }
        }

        public int groups(){
            int groups = 0;
            for(int i = 0; i < parent.length; i++){
                if(i == parent[i]) groups++;
            }
            return groups;
        }
    }
}
