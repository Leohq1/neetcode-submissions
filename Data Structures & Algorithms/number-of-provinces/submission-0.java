class Solution {
    private int[] parent;
    private int[] rank;
    public int findCircleNum(int[][] isConnected) {
        parent = new int[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            parent[i] = i;
        }
        rank = new int[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            for(int j = i + 1; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1) union(i, j);
            }
        }
        int count = 0;
        for(int i = 0; i < parent.length; i++){
            if(i == parent[i]) count++;
        }
        return count;
    }

    private int find(int i){
        if(i == parent[i]){
            return i;
        }
        parent[i] = find(parent[i]);
        return parent[i];
    }

    private void union(int i, int j){
        int parentI = find(i);
        int parentJ = find(j);
        if(parentI == parentJ) return;
        if(rank[parentI] < rank[parentJ]){
            parent[parentI] = parentJ;
        } else if(rank[parentI] > rank[parentJ]){
            parent[parentJ] = parentI;
        } else{
            parent[parentJ] = parentI;
            rank[parentI]++;
        }
    }
}