class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> resultList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        resultList.add(intervals[0]);
        for(int i = 0; i < intervals.length - 1; i++){
            int[] temp = resultList.remove(resultList.size() - 1);
            int[] next = intervals[i + 1];
            if(next[1] <= temp[1]){
                resultList.add(temp);
                if(i == intervals.length - 1) break;
                continue;
            }
            if(temp[1] >= next[0]){
                resultList.add(new int[]{temp[0], next[1]});
                if(i == intervals.length - 1){
                    break;
                }
            } else{
                resultList.add(temp);
                resultList.add(next);
                if(i == intervals.length - 1){
                    resultList.add(next);
                    break;
                }
            }
        }
        int[][] result = new int[resultList.size()][2];
        for(int i = 0; i < resultList.size(); i++){
            result[i] = resultList.get(i);
        }
        return result;
    }
}