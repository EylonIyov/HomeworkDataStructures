import java.time.Period;
import java.util.Arrays;
import java.util.Scanner;

public class TesterClass {

    public static Integer[] GenerateArray(int size, int MinNumber, int MaxNumber) {
        Integer[] array = new Integer[size];
        for (int i =0; i < size; i++){
            array[i] = MinNumber+(int)(Math.random()*(MaxNumber-MinNumber) );
        }
        return array;
    }

    public static void main(String[] args) {
        String TestCase = " ";
        while (!TestCase.equals("exit")){
            System.out.println("Enter a case to test \n 1. Build an empty heap \n 2. Build a heap with a capacity argument \n 3. Build a heap from an array \n 4. Insert function");
            TestCase = new Scanner(System.in).nextLine();
            switch (TestCase) {
                case "1":
                    GeneralPurposeHeap<Integer> TestHeap0 = new GeneralPurposeHeap<Integer>();
                    System.out.println(Arrays.toString(TestHeap0.heap));
                    break;
                case "2":
                    System.out.println("Enter the capacity of the array");
                    Integer capacity = new Scanner(System.in).nextInt();
                    GeneralPurposeHeap<Integer> TestHeap1 = new GeneralPurposeHeap<Integer>();
                    System.out.println(Arrays.toString(TestHeap1.heap));
                    break;
                case "3":
                    Integer[] exampleArray = GenerateArray(16, 1, 16);
                    System.out.println("Array before sorting into heap: \n"+Arrays.toString(exampleArray));
                    GeneralPurposeHeap<Integer> TestHeap2 = new GeneralPurposeHeap<Integer>(exampleArray);
                    System.out.println("Array after sorting into heap: \n"+Arrays.toString(TestHeap2.heap));
                    break;
                case "4":
                    Integer[] ArrayInteger = GenerateArray(16, 1, 16);
                    GeneralPurposeHeap<Integer> TestHeap3 = new GeneralPurposeHeap<Integer>(ArrayInteger);
                    System.out.println("Write number to insert");
                    Integer number = new Scanner(System.in).nextInt();
                    TestHeap3.insert(number);
                    System.out.println("size: "+ TestHeap3.getSize());
                    System.out.println(Arrays.toString(TestHeap3.heap));

            }
        }

    }
}
