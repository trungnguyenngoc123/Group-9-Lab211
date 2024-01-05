package Control;

import Model.Model;
import View.Validation;
import java.util.Scanner;

public class Manager extends Model {
    public Manager() {
        super();//thừa kế các attribute của Model
    }
    public static final Scanner sc = new Scanner(System.in);
    public static int inputSizeOfArray() {
        System.out.print("Enter number of array: ");
        int size = Validation.checkInputPositiveInt();
        return size;
    }

    public static Model[] inputValueOfArray(int size) {//trả về một mảng các đối tượng (size, value) thuộc kiểu Model
        Model[] models = new Model[size];//tạo một mảng tên là models trong class Model với size người dùng đã nhập
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for element " + (i + 1) + ": ");
            int value = Validation.checkInputInt();
            models[i] = new Model(size, value);//gán cho mỗi phần tử của mảng models trỏ đến đối tượng Model được tạo mới
        }

        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i].getValue());//in ra từng phần tử trong mảng (user nhập)
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
    //thuật toán bubble sort là so phần tử n với phần tử n+1 nếu lớn hơn thì swap, bé hơn thì giữ nguyên và so với phần tử kế tiếp

    public static void print(Model[] models) {
        System.out.print("\nSorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i].getValue());//in ra từng phần tử trong mảng (sau khi đã sort)
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
        Model[] models = new Model[m];//tạo một mảng tên là models trong class Model với size người dùng đã nhập
        for (int i = 0; i < m; i++) {
            System.out.print("Enter value for element " + (i + 1) + ": ");
            int value = Validation.checkInputInt();
            models[i] = new Model(m, value);//gán cho mỗi phần tử của mảng models trỏ đến đối tượng Model được tạo mới
        }

        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i].getValue());//in ra từng phần tử trong mảng (user nhập)
            if (i < models.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        return models;
    }

    public static int partition(Model[] models, int left, int right) {
        int tmp;
        int pivot = models[(left + right) / 2].getValue();//chọn 1 phần từ giữa mảng làm pivot
        while (left <= right) {//sắp xếp lại
            while (models[left].getValue() < pivot) {//phần tử nhỏ hơn pivot nằm bên trái và tăng thêm số chỉ left thêm 1
                left++;
            }
            while (models[right].getValue() > pivot) {//phần tử lớn hơn pivot nằm bên phải và giảm số chỉ right đi 1 
                right--;
            }
            if (left <= right) {//kiểm tra xem còn phần tử nào chưa hoán đổi hay không nếu đúng thì vẫn còn trong quá trình phân chia
                tmp = models[left].getValue();//lưu giá trị left vào tmp
                models[left].setValue(models[right].getValue());//gán giá trị phần tử ở vị trí right cho phần tử ở vị trí left
                models[right].setValue(tmp);//gán giá trị biến tmp cho phần tử ở vị trí left
                left++;//di chuyển chỉ số left sang phải để trỏ đến phần tử tiếp theo trong mảng bên trái
                right--;//di chuyển chỉ số right sang trái để trỏ đến phần tử tiếp theo trong mảng bên phải
            }
        }
        return left;
    }

    public static void quicksort(Model[] models, int left, int right) {
        int index = partition(models, left, right);
        if (left < index - 1) {//kiểm tra có cần sắp xếp mảng con bên trái của pivot không nếu true (còn 2 phần tử) thì tiến hành đệ quy
            quicksort(models, left, index - 1);
        }
        if (index < right) {//kiểm tra có cần sắp xếp mảng con bên phải của pivot không nếu true (còn 2 phần tử) thì tiến hành đệ quy
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
    //thuật toán Quick sort 
    
    //thuật toán Binary search
    public static int inputSizeOfArray3() {
        System.out.print("Enter number of array: ");
        int size = Validation.checkInputPositiveInt();
        return size;
    }
    public static int inputIndexOfSearch(){
            System.out.print("\nEnter search value: ");
            int target = Validation.checkInputPositiveInt();
            
            return target;
        }
    public static Model[] inputValueOfArray3(int size) {//trả về một mảng các đối tượng (size, value) thuộc kiểu Model
        Model[] models = new Model[size];//tạo một mảng tên là models trong class Model với size người dùng đã nhập
        for (int i = 0; i < size; i++) {
            System.out.print("Enter value for element " + (i + 1) + ": ");
            int value = Validation.checkInputInt();
            models[i] = new Model(size, value);//gán cho mỗi phần tử của mảng models trỏ đến đối tượng Model được tạo mới
        }

        System.out.print("Unsorted array: ");
        System.out.print("[");
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i].getValue());//in ra từng phần tử trong mảng (user nhập)
            if (i < models.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
        return models;
    }
    
    public static int binarySearch(Model[] models, int target){
        int left = 0;
        int right = models.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparisonResult = models[mid].getValue() - target;
            if (comparisonResult == 0) {
                return mid; // Element found, return its index
            } else if (comparisonResult < 0) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Element not found
    }
    
}