//ở trong code này đã sửa đổi từ array thành arrayList 

package ManagerVer2;

import Model.Model;
import View.Validation;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Manager extends Model {
    public Manager() {
        super();
    }

    public static final Scanner sc = new Scanner(System.in);

    public static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        return Validation.checkInputPositiveInt();
    }

    public static ArrayList<Model> inputValueOfArray(int size) {
        ArrayList<Model> models = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for element " + (i + 1) + ": ");
            int value = Validation.checkInputInt();
            models.add(new Model(size, value));
        }

        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.size(); i++) {
            System.out.print(models.get(i).getValue());
            if (i < models.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        return models;
    }

    public static void sortArrayByBubbleSort(ArrayList<Model> models) {
        for (int i = 0; i < models.size(); i++) {
            for (int j = 0; j < models.size() - i - 1; j++) {
                if (models.get(j).getValue() > models.get(j + 1).getValue()) {
                    Model temp = models.get(j);
                    models.set(j, models.get(j + 1));
                    models.set(j + 1, temp);
                }
            }
        }
    }

    public static void print(ArrayList<Model> models) {
        System.out.print("\nSorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.size(); i++) {
            System.out.print(models.get(i).getValue());
            if (i < models.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int inputSizeOfArray2() {
        System.out.print("Enter number of array: ");
        return Validation.checkInputPositiveInt();
    }

    public static ArrayList<Model> randomValueOfArray(int m) {
        ArrayList<Model> models = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int value = new Random().nextInt(m);
            models.add(new Model(1, value));
        }
        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < m; i++) {
            System.out.print(models.get(i).getValue());
            if (i < m - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        return models;
    }
    
    // Other methods remain the same...
    public static int partition(ArrayList<Model> models, int left, int right) {
        int tmp;
        int pivot = models.get((left + right) / 2).getValue();
        while (left <= right) {
            while (models.get(left).getValue() < pivot) {
                left++;
            }
            while (models.get(right).getValue() > pivot) {
                right--;
            }
            if (left <= right) {
                tmp = models.get(left).getValue();
                models.get(left).setValue(models.get(right).getValue());
                models.get(right).setValue(tmp);
                left++;
                right--;
            }
        }
        return left;
    }
    public static void quicksort(ArrayList<Model> models, int left, int right) {
        int index = partition(models, left, right);
        if (left < index - 1) {
            quicksort(models, left, index - 1);
        }
        if (index < right) {
            quicksort(models, index, right);
        }
    }

    public static void print2(ArrayList<Model> models) {
    System.out.print("\nSorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.size(); i++) {
            System.out.print(models.get(i).getValue());
                if (i < models.size() - 1) {
                   System.out.print(", ");
                }
            }
            System.out.print("]");
        }
}
