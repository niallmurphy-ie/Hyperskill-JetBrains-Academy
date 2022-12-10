import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int[][] arrays = new int[n][n];
        String[] inputArray;
        for (int i = 0; i < n; i++) {
            inputArray = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                arrays[i][j] = Integer.valueOf(inputArray[j]);
            }
        }
        // Check
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arrays[i][j] != arrays[j][i]) {
                    System.out.println("NO");
                    return;
                }
            }

        }
        System.out.println("YES");
    }
}