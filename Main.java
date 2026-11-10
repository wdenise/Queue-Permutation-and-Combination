package permutationandcombination;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    // Queue implementation
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    addElements();
                    break;
                case 2:
                    displayQueue();
                    break;
                case 3:
                    generatePermutations();
                    break;
                case 4:
                    generateCombinations();
                    break;
                case 5:
                    System.out.println("Program terminated.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
    }

    // TODO 1: Accept elements and add them to the Queue
    static void addElements() {
    	// Ask how many elements to add
        // Use queue.add() to insert elements
    	
        System.out.print("How many elements to add? ");
        int count = input.nextInt();
        input.nextLine();

        for (int i = 0; i < count; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            String element = input.nextLine();
            queue.add(element);
        }
    }

    // TODO 2: Display all elements in the Queue
    static void displayQueue() {
    	// Display the contents of the Queue
    	
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.println("Queue: " + queue);
        System.out.println("Head element: " + queue.peek());
    }

    // TODO 3: Generate all possible permutations
    static void generatePermutations() {
    	// Ask how many elements should be selected (r)
        // Generate all possible arrangements
        // Display the total number of permutations
    	
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        
        System.out.println("Queue: " + queue);
        System.out.print("Enter number of elements to arrange: ");
        int r = input.nextInt();

        int size = queue.size();
        String[] elements = new String[size];
        for (int i = 0; i < size; i++) {
            String val = queue.poll();
            elements[i] = val;
            queue.add(val);
        }

        int[] count = new int[1];
        permute(elements, "", new boolean[size], r, count);
        System.out.println("\nTotal Permutations: " + count[0]);
    }

    private static void permute(String[] elements, String current, boolean[] used, int r, int[] count) {
        if (current.length() == r) {
            System.out.print(current + "\n");
            count[0]++;
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                permute(elements, current + elements[i], used, r, count);
                used[i] = false;
            }
        }
    }

    // TODO 4: Generate all possible combinations
    static void generateCombinations() {
    	// Ask how many elements should be selected (r)
        // Generate all possible selections
        // Avoid duplicate combinations
        // Display the total number of combinations
    	
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("Queue: " + queue);
        System.out.print("Enter number of elements to select: ");
        int r = input.nextInt();
        System.out.println();

        int size = queue.size();
        String[] elements = new String[size];
        for (int i = 0; i < size; i++) {
            String val = queue.poll();
            elements[i] = val;
            queue.add(val);
        }

        int[] count = new int[1];
        combine(elements, 0, "", r, count);
        System.out.println("\nTotal Combinations: " + count[0]);
    }

    private static void combine(String[] elements, int start, String current, int r, int[] count) {
        if (current.length() == r) {
            System.out.println(current);
            count[0]++;
            return;
        }
        for (int i = start; i < elements.length; i++) {
            combine(elements, i + 1, current + elements[i], r, count);
        }
    }
}