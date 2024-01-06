
package Control;

import Model.Model;
import View.Validation;
import java.util.Random;
import java.util.Scanner;

public class Manager extends Model {
    public Manager() {
        super();
    }
    public static final Scanner sc = new Scanner(System.in);
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

    public static void print(Model[] models) {
        System.out.print("\nSorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i].getValue());
            if (i < models.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    

    public static int inputSizeOfArray2() {
        System.out.print("Enter number of array: ");
        int m = Validation.checkInputPositiveInt();
        return m;
    }

    public static Model[] RandomValueOfArray(int m) {
        Model[] models = new Model[m];
        for (int i = 0; i < m; i++) {
            int value = new Random().nextInt(m);
            models[i] = new Model(1, value); 
        }
        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < m; i++) {
            System.out.print(models[i].getValue());
            if (i < m - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        return models;
    }

    public static int partition(Model[] models, int left, int right) {
        int tmp;
        int pivot = models[(left + right) / 2].getValue();
        while (left <= right) {
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

    public static void print2(Model[] models) {
        System.out.print("\nSorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i].getValue());
            if (i < models.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}