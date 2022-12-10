import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        // solve
        if (k == m || k == n) {
            System.out.println("YES");
            return;
        }
        for (int i = 2; i <= m; i++) {
            if (n * i == k) {
                System.out.println("YES");
                return;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (m * i == k) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

}