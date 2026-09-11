class Solution {
    //private Set<List<Integer>> rot = new HashSet<>();
    private Set<List<Integer>> fresh = new HashSet<>();

    public int orangesRotting(int[][] grid) {
        Deque<List<Integer>> starts = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    List<Integer> coord = Arrays.asList(i, j);
                    starts.addLast(coord);
                    //rot.add(coord);
                } else if(grid[i][j] == 1){
                    List<Integer> coord = Arrays.asList(i, j);
                    fresh.add(coord);
                }
            }
        }
        return bfs(grid, starts);
    }

    private int bfs(int[][] grid, Deque<List<Integer>> coordinates){
        Deque<List<Integer>> q = coordinates;
        int time = -1;
        if(fresh.isEmpty() && q.isEmpty()) return 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                List<Integer> temp = q.removeFirst();
                int r = temp.get(0);
                int c = temp.get(1);
                if(fresh.contains(Arrays.asList(r + 1, c))){
                    fresh.remove(Arrays.asList(r + 1, c));
                    //rot.add(Arrays.asList(r + 1, c));
                    q.addLast(Arrays.asList(r + 1, c));
                }
                if(fresh.contains(Arrays.asList(r, c + 1))){
                    fresh.remove(Arrays.asList(r, c + 1));
                    //rot.add(Arrays.asList(r, c + 1));
                    q.addLast(Arrays.asList(r, c + 1));
                }
                if(fresh.contains(Arrays.asList(r - 1, c))){
                    fresh.remove(Arrays.asList(r - 1, c));
                    //rot.add(Arrays.asList(r - 1, c));
                    q.addLast(Arrays.asList(r - 1, c));
                }
                if(fresh.contains(Arrays.asList(r, c - 1))){
                    fresh.remove(Arrays.asList(r, c - 1));
                    //rot.add(Arrays.asList(r, c - 1));
                    q.addLast(Arrays.asList(r, c - 1));
                }
            }
            time++;
        }
        return (fresh.isEmpty()) ? time : -1;
    }
}