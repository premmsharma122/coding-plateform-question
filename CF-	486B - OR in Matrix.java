import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();   
        int n = sc.nextInt();   
        
        int[][] B = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Step 1: Assume A is all 1s
        int[][] A = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(A[i], 1);
        }

        // Step 2: For every B[i][j] = 0, set row i and col j in A to 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (B[i][j] == 0) {
                    // set entire row i = 0
                    for (int k = 0; k < n; k++) {
                        A[i][k] = 0;
                    }
                    // set entire column j = 0
                    for (int k = 0; k < m; k++) {
                        A[k][j] = 0;
                    }
                }
            }
        }

        // Step 3: Recalculate new B' from A
        int[][] checkB = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = 0;
                // OR of row i
                for (int k = 0; k < n; k++) {
                    val |= A[i][k];
                }
        
                for (int k = 0; k < m; k++) {
                    val |= A[k][j];
                }
                checkB[i][j] = val;
            }
        }

        
        boolean same = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (checkB[i][j] != B[i][j]) {
                    same = false;
                    break;
                }
            }
        }

        if (!same) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(A[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
