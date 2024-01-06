package Control;

import Model.Model;
import View.Validation;
import java.util.Scanner;

public class Manager extends Model {

    public Manager() {
        super();
    }
    public static final Scanner sc = new Scanner(System.in);

    //nhập vào
    public static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int size = Validation.checkInputPositiveInt();
        return size;
    }

    public static Model[] inputValueOfArray(int size) {
        Model[] models = new Model[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for element " + (i + 1) + ": ");
            int value = Validation.checkInputInt();
            models[i] = new Model(size, value);
        }

        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i].getValue());
            if (i < models.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        return models;
    }

    public static void sortArrayByBubbleSort(Model[] models) {
        for (int i = 0; i < models.length; i++) {
            for (int j = 0; j < models.length - i - 1; j++) {
                if (models[j].getValue() > models[j + 1].getValue()) {
                    Model temp = models[j];
                    models[j] = models[j + 1];
                    models[j + 1] = temp;
                }
            }
        }
        
    }

    //in ra
    public static int partition(Model[] models, int left, int right) {
        int tmp;
        int pivot = models[(left + right) / 2].getValue();
        while (left <= right) {//sắp xếp lại
            while (models[left].getValue() < pivot) {
                left++;
            }
            while (models[right].getValue() > pivot) {
                right--;
            }
            if (left <= right) {
                tmp = models[left].getValue();
                models[left].setValue(models[right].getValue());
                models[right].setValue(tmp);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void quicksort(Model[] models, int left, int right) {
        int index = partition(models, left, right);
        if (left < index - 1) {
            quicksort(models, left, index - 1);
        }
        if (index < right) {
            quicksort(models, index, right);
        }
    }

    public static void print(Model[] models) {
        System.out.print("\nSorted array: [");
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i].getValue());
            if (i < models.length - 1) {
                System.out.print(", ");
            }

        }
        System.out.println("]");
    }
    //thuật toán Quick sort 

    //thuật toán Binary search
    public static int inputIndexOfSearch() {
        System.out.print("\nEnter search value: ");
        int target = Validation.checkInputPositiveInt();
        return target;
    }

    public static int binarySearch(Model[] models, int target) {
        int left = 0;
        int right = models.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonResult = models[mid].getValue() - target;
            if (comparisonResult == 0) {
                return mid;
            } else if (comparisonResult < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int linearSearch(Model[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].getValue() == target) {
                return i;
            }
        }
        return -1; // Element not found
    }

    public static void search(Model[] Search) {
        System.out.print("\nEnter value to search: ");
        int target = sc.nextInt();
        int result = linearSearch(Search, target);
        if (result == -1) {
            System.out.println(target + " is not found");
        } else {
            System.out.println(target + " is found at index: " + result);
        }

    }
}
