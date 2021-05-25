### 解题思路
![image.png](https://pic.leetcode-cn.com/1621076285-YTSbVz-image.png)
1.自己定义一个 pow数组，存的是 x的1次方，2次方，4次方，8次方，16次方……这样可以简便最后的运算
2.通过while求取pow
3.再来一个while 通过位运算计算当前位是否需要×上对应pow数组
4.返回结果
### 代码

```java
class Solution {
    public double myPow(double x, int n) {
        if(x == 1 || n == 0 || (x == -1 && n % 2 == 0)) return 1;
        if(x == -1 && n % 2 == 1) return -1;
        if(x == 0 || n == Integer.MIN_VALUE) return 0;

        if(n < 0){n = -n; x = 1.0 / x;}

        int temp = 1;
        double result = 1;
        double[] pow = new double[32];
        pow[1] = x;

        while(temp < 31 && pow[temp] >= -10000 && pow[temp] <= 10000){
            temp++;
            pow[temp] = pow[temp - 1] * pow[temp - 1];
        }
        int flag = temp;
        temp = 1;
        while(temp < flag){
            if((n & 1) == 1) result *= pow[temp];
            n = n >> 1;   
            temp++;
        }

        return result;

    }
}
```