/**
 * Copied the official solution from jiuzhang
 * Don't understand at all!!
 * 
 * Here have explanation and thoughts:
 *      http://www.cnblogs.com/yuzhangcmu/p/4174781.html
 */
class Solution {
    public int fastPower(int a, int b, int n) {
        if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }
        
        long product = fastPower(a, b, n / 2);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;
    }
};