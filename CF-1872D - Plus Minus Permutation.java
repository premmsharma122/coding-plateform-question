import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long n = sc.nextLong();
            long x = sc.nextLong();
            long y = sc.nextLong();

            // 1. Common indices nikalo (LCM ke through)
            long common = n / getLCM(x, y);

            // 2. Sirf x wale aur sirf y wale kitne bache?
            long plusCount = (n / x) - common; 
            long minusCount = (n / y) - common;

            // 3. Sum of Largest 'plusCount' numbers
            // Formula: Sum(1 to n) - Sum(1 to n-plusCount)
            long sumX = sumOfFirst(n) - sumOfFirst(n - plusCount);

            // 4. Sum of Smallest 'minusCount' numbers
            // Formula: Sum(1 to minusCount)
            long sumY = sumOfFirst(minusCount);

            System.out.println(sumX - sumY);
        }
    }

    // Pehle 'k' numbers ka sum: 1 + 2 + ... + k
    static long sumOfFirst(long k) {
        return (k * (k + 1)) / 2;
    }

    static long getLCM(long a, long b) {
        return (a / getGCD(a, b)) * b;
    }

    static long getGCD(long a, long b) {
        while (b > 0) {
            a %= b;
            long temp = a; a = b; b = temp;
        }
        return a;
    }
}
