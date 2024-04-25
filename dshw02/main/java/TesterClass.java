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
            System.out.println("Enter a case to test \n 1. Build an empty heap \n 2. Build a heap with a capacity argument \n 3. Build a heap from an array \n 4. Insert function \n" +
                    " 5. Get minimum value \n 6. deleteMin test \n 'exit' to exit" );
            TestCase = new Scanner(System.in).nextLine();
            switch (TestCase) {
                case "1":
                    GeneralPurposeHeap<Integer> TestHeap0 = new GeneralPurposeHeap<Integer>();
                    System.out.println(Arrays.toString(TestHeap0.heap));
                    break;
                case "2":
                    System.out.println("Enter the capacity of the array");
                    Integer capacity = new Scanner(System.in).nextInt();
                    GeneralPurposeHeap<Integer> TestHeap1 = new GeneralPurposeHeap<Integer>(capacity);
                    System.out.println(Arrays.toString(TestHeap1.heap));
                    break;
                case "3":
                    Integer[] exampleArray = GenerateArray(10, 1, 100);
                    System.out.println("Array before sorting into heap: \n"+Arrays.toString(exampleArray));
                    GeneralPurposeHeap<Integer> TestHeap2 = new GeneralPurposeHeap<Integer>(exampleArray);
                    System.out.println("Array after sorting into heap: \n"+Arrays.toString(TestHeap2.heap));
                    break;
                case "4":
                    Integer[] ArrayInteger = {5,7,6,9,1,4,1,6,null};
                    GeneralPurposeHeap<Integer> TestHeap3 = new GeneralPurposeHeap<Integer>(ArrayInteger);
                    System.out.println("Write number to insert");
                    Integer number = new Scanner(System.in).nextInt();
                    TestHeap3.insert(number);
                    System.out.println("size: "+ TestHeap3.getSize());
                    System.out.println(Arrays.toString(TestHeap3.heap));
                    break;
                case "5":
                    Integer[] ArrayInteger1 = GenerateArray(8,1,8);
                    GeneralPurposeHeap<Integer> TestHeap4 = new GeneralPurposeHeap<Integer>(ArrayInteger1);
                    System.out.println(Arrays.toString(TestHeap4.heap));
                    System.out.println(TestHeap4.getMin());
                    break;
                case "6":
                    Integer[] ArrayInteger2 = GenerateArray(8,1,100);
                    GeneralPurposeHeap<Integer> TestHeap5 = new GeneralPurposeHeap<Integer>(ArrayInteger2);
                    System.out.println("The array before the deletion: \n"+ Arrays.toString(TestHeap5.heap) + "\n");
                    System.out.println("The minimal value: " + TestHeap5.deleteMin() + '\n');
                    System.out.println("The array after the deletion: \n" + Arrays.toString(TestHeap5.heap) + "\n");
                    break;
                case "exit":
                    System.out.println("Exiting program, Thanks for using the TesterClass made by Eylon Iyov");
            }
        }

    }
}
