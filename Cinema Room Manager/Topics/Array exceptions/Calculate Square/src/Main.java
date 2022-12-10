class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        // write your code here
        int size = array == null ? 0 : array.length;
        if (index < 0 || index > size -1 ) {
            System.out.println("Exception!");
            return;
        }
        System.out.println(array[index] * array[index]);
    }
}