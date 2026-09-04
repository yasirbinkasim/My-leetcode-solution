class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        
        findCombinations(0, target, candidates, currentCombination, result);
        return result;
    }

    private void findCombinations(int idx, int target, int[] candidates, 
                                 List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (idx == candidates.length) {
            return;
        }

        if (candidates[idx] <= target) {
            current.add(candidates[idx]);
            findCombinations(idx, target - candidates[idx], candidates, current, result);
            current.remove(current.size() - 1);
        }

        findCombinations(idx + 1, target, candidates, current, result);
    }
}