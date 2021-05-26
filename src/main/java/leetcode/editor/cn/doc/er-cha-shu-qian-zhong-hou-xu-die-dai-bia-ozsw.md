**前序遍历**

```
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()){
            if(cur != null){
                res.add(cur.val); // root
                s.push(cur); 
                cur = cur.left; // left
            }else{
                cur = s.pop();
                cur = cur.right; // right
            }
        }
        return res;
    }
```

**中序遍历**

```
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){ 
                stack.push(cur);
                cur = cur.left; // left
            }else{
                cur = stack.pop();
                res.add(cur.val); // root
                cur = cur.right; // right
            }
        }
        return res;
    }
```

**后序遍历**

```
    // 前序遍历顺序为：根 -> 左 -> 右
    // 后序遍历顺序为：左 -> 右 -> 根
    // 所以, 我们可以把前序遍历的稍作修改: 根 -> 右 -> 左, 
    // 然后结果存放到栈里进行倒序, 之后再遍历结果栈就可以输出后序遍历了
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        Stack<TreeNode> resStack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()){
            if(cur != null){
                resStack.push(cur); // root
                s.push(cur); 
                cur = cur.right; // right
            }else{
                cur = s.pop();
                cur = cur.left; // left
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!resStack.isEmpty()){
            res.add(resStack.pop().val);
        }
        return res;
    }
```