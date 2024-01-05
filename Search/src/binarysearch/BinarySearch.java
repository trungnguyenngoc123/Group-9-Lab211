//sử dụng thuật toán tìm kiếm nhị phân để tìm vị trí (index) của một số trong một chuỗi
package binarysearch;

import java.util.Scanner;

public class BinarySearch {
    public static final Scanner sc = new Scanner (System.in);
    private static int checkInputInt() {
        //loop until user input correct
        do{
            try {
                int result = Integer.parseInt(sc.nextLine().trim());//chuyển đổi chuỗi thành số nguyên nếu là chữ thì sẽ ném ra lỗi
                return result;
            } catch (NumberFormatException e) {//bắt lỗi
                System.out.print("Wrong number format please enter again: ");
            }
        }while(true);
    }
    private static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");//nhập vào số lượng phần tử mảng
        int n = checkInputInt();//kiểm tra format của số nhập nếu là chữ thì bảo người dùng nhập lại
        return n;
    }
    private static int[] inputValueOfArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter a[" + i + "]: ");//nhập vào phần tử mảng
            a[i] = checkInputInt();//kiểm tra format
        }
        System.out.print("Array: ");
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "");//in ra chuỗi ban đầu
            if (i < a.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        return a;
    }
    
    private static int binarySearch(int[]a, int target){
        int left = 0;
        int right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (a[mid] == target) {
                return mid; // Element found, return its index
            } else if (a[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }

        return -1; // Element not found
    }
    
    public static void main(String[] args) {
        int n = inputSizeOfArray();
        int []a = inputValueOfArray(n);
        System.out.print("\nEnter value to search: ");
        int target = sc.nextInt();
        int result = binarySearch(a, target);
        if (result == -1){
            System.out.println(target + " is not found");
        }else{
            System.out.println(target + " is found at index: "+ result);
        }
    }
}
