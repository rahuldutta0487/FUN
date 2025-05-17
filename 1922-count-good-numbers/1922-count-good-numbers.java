class Solution {
    public int countGoodNumbers(long n) {
        int mod = 1000000007;
        long odd = (n + 1) / 2;
        long even = n / 2;
        long part1 = power(5, odd, mod);
        long part2 = power(4, even, mod);
        return (int)((part1 * part2) % mod);
    }

    long power(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    boolean good(int n) {
        int count = 1;
        while (n > 0) {
            int dig = n % 10;
            if ((count & 1) != 0 && !isprime(dig)) return false;
            if ((count & 1) == 0 && (dig & 1) != 0) return false;
            n /= 10;
            count++;
        }
        return true;
    }

    boolean isprime(int n) {
        if (n == 2 || n == 3) return true;
        if (n <= 1 || n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }
}