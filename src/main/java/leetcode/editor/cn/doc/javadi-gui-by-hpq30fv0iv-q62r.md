### 解题思路
递归判断p的左子树和q的左子树，p的右子树和q的右子树是否相同。

### 代码

```java
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)  //如果都为空代表都遍历完了，返回true
            return true;
        if(p == null || q == null)  //有一个为空代表不相同
            return false;
        if(p.val != q.val)  //值不同
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);//递归比较
    }
}
```
### 复杂度分析
- 时间复杂度：O(min(n,m))
- 空间复杂度：O(min(n,m))