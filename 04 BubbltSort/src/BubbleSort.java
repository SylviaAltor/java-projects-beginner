public class BubbleSort {

    public static void main(String[] args) {
        MyTools mytool = new MyTools();
        int[] arr = {10, -1, 8, 0, 35};
        mytool.bubble(arr);

        System.out.println("array after sorting:");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
