### 解题思路

此处撰写解题思路

### 代码

```java
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        dfs(nums, list, list1);
        return list;
    }

    public void dfs(int[] nums, List<List<Integer>> list, List<Integer> list1) {
        if (list1.size() == nums.length) {
            list.add(new ArrayList<>(list1));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list1.contains(nums[i])) continue;
            list1.add(nums[i]);
            dfs(nums, list, list1);
            list1.remove(list1.size() - 1);
        }
    }
}
```