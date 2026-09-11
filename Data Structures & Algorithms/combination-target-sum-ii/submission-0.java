class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(
            int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void dfs(
            int[] candidates,
            int index,
            int target,
            List<Integer> cur) {

        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > target) {
                break;
            }

            cur.add(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}