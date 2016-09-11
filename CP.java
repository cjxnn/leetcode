/**
 * Description: Count the number of prime numbers less than a non-negative number, n.
 * Hint: Let's start with a isPrime function. To determine if a number is prime, we need to check if it is not divisible by any number less than n. The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?
 */

public class Solution {
    public int countPrimes(int n) {
        if (n < 3)
            return 0;
            
        if (n == 3)
            return 1;
            
        int count = 1, composite = 0;
        boolean[] numbers = new boolean[n - 3];
        
        for (int i = 0; i < n - 3; i += 2){
            if (!numbers[i]){
                count++;
                
                composite = 3 * i + 6;
                while (composite < n - 3){
                    numbers[composite] = true;
                    composite += 2 * i + 6;
                }
            }
        }
        
        return count;
    }
}