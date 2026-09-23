class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length, i = 0;
        while(i < n && intervals[i][1] < newInterval[0]){
            result.add(intervals[i]);
            i++;
        }
        if(i == n || newInterval[1] < intervals[i][0]){
            result.add(newInterval);
        } else{
            int[] toAdd = new int[2];
            toAdd[0] = Math.min(newInterval[0], intervals[i][0]);
            while(i < n && newInterval[1] >= intervals[i][0]){
                toAdd[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            result.add(toAdd);
        }
        while(i < n){
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[0][0]);
    }
}
