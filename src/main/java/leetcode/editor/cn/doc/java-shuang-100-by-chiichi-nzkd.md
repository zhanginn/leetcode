### 解题思路

### 代码

```java
class Solution {
    public int sumBase(int n, int k) {
        int ans = 0;
        while(n>0){
            ans += n%k;
            n = n/k;
        }
        return ans;
    }
}
```