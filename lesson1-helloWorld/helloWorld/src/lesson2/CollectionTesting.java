package lesson2;

import java.util.*;

public class CollectionTesting {

    public static void main(String[] args) {
        int[] numbers1 = new int[]{
                3, 4, 5, 6
        };

        System.out.print("PRINT ARRAY");
        int[] numbers2 = new int[3];
        numbers2[0] = 5;
        numbers2[1] = 5;
        numbers2[2] = 3;
        //numbers2[3] = 8; //Runtime Error: Array index of bound exception

        System.out.print(Arrays.toString(numbers2) + "\n");


        System.out.print("PRINT LIST");
        List<Integer> integerList = new ArrayList<>();
        print(Collections.singleton(integerList));


        System.out.print("PRINT SET");
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(6);
        integerSet.add(6);
        integerSet.add(5);
        integerSet.add(3);

        Integer[] numbers = integerSet.toArray(new Integer[0]);
        Integer someNumber = 5;
        int someeNumber = 7;
        int someNumber2 = someeNumber;

        print(Collections.singleton(integerSet));
    }

    static void print(Collection<Object> objects) {
        for (Object element : objects) {
            System.out.println("Element is: " + element);
        }
    }

    static void print(int[] objects) {
        for (Object element : objects) {
            System.out.println("Element is: " + element);
        }
    }
}