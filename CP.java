/**
 * Description: Count the number of prime numbers less than a non-negative number, n.
 * Hint: Let's start with a isPrime function. To determine if a number is prime, we need to check if it is not divisible by any number less than n. The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2). Could we do better?
 */

public class Solution {
    public int countPrimes(int n) {
        if (n < 3){
            return 0;
        }
        else{
            int tmp, start = 0, prime = 0, number = 1;
            boolean[] numbers = new boolean[n/2 - 1];
            while (start < numbers.length){
                while (numbers[start]){
                    start++;
                    if (start == numbers.length)
                        return number;
                }
                number++;
                prime = 2 * start + 3;
                
                for(tmp = start; tmp < numbers.length; tmp += prime)
                    numbers[tmp] = true;
            }
            
            return number;
        }
    }
}