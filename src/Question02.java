import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

class FirstNonRepeatingStream
{
    private final int[] charFrequency;
    private final Queue<Character> charQueue;

    public FirstNonRepeatingStream()
    {
        charFrequency = new int[256];
        charQueue = new LinkedList<>();
    }

    public void add(char c)
    {
        if (c >= 'a' && c <= 'z')
        {
            charFrequency[c]++;
            charQueue.add(c);

        } else
        {
            System.out.println("Invalid character input. Please enter a valid character in the range 'a' to 'z'.");
        }

    }

    public char getFirstNonRepeating()
    {
        while (!charQueue.isEmpty())
        {
            char currentChar = charQueue.peek();

            if (charFrequency[currentChar] == 1) {
                return currentChar;
            }
            while (!charQueue.isEmpty() && charFrequency[charQueue.peek()] > 1)
            {
                charQueue.poll();
            }
        }

        return '-';
    }

    public void displayStream()
    {
        System.out.print("Current Stream: ");
        for (char ch : charQueue) {
            System.out.print(ch);
        }
        System.out.println();
    }
}


public class Question02 {
    public static void main(String[] args)
    {
        FirstNonRepeatingStream stream1 = new FirstNonRepeatingStream();
        stream1.add('a');
        stream1.add('b');
        stream1.add('a');
        stream1.displayStream();
        char result = stream1.getFirstNonRepeating();
        if (result != '-') {
            System.out.println("The first non-repeating character is: " + result+"\n");
        } else {
            System.out.println("No non-repeating character found.\n");
        }

        FirstNonRepeatingStream stream2 = new FirstNonRepeatingStream();
        stream2.add('a');
        stream2.add('b');
        stream2.add('a');
        stream2.add('b');
        stream2.displayStream();
        char result2 = stream2.getFirstNonRepeating();
        if (result2 != '-') {
            System.out.println("The first non-repeating character is: " + result2+"\n");
        } else {
            System.out.println("No non-repeating character found.\n");
        }


        FirstNonRepeatingStream stream3 = new FirstNonRepeatingStream();
        stream3.add('a');
        stream3.add('b');
        stream3.add('b');
        stream3.displayStream();
        char result3 = stream3.getFirstNonRepeating();
        if (result3 != '-') {
            System.out.println("The first non-repeating character is: " + result3+"\n");
        } else {
            System.out.println("No non-repeating character found.\n");
        }


        FirstNonRepeatingStream stream = new FirstNonRepeatingStream();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true)
        {
            System.out.print("\n");
            try {
                System.out.println("Options:");
                System.out.println("1. Add character");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                if (choice == 1) {
                    try {
                        System.out.print("Enter character: ");
                        char character = scanner.next().charAt(0);
                        stream.add(character);
                        char result1 = stream.getFirstNonRepeating();
                        stream.displayStream();
                        if (result1 != '-') {
                            System.out.println("The first non-repeating character is: " + result1);
                        } else {
                            System.out.println("No non-repeating character found.");
                        }
                    } catch (java.util.InputMismatchException e)
                    {
                        System.out.println("Invalid character input. Please enter a valid character.");
                        scanner.nextLine();
                    }
                } else if (choice == 2)
                {
                    scanner.close();
                    System.out.println("Exiting the program.");
                    break;
                } else
                {
                    System.out.println("Invalid choice. Please select 1 or 2.");
                }
            } catch (java.util.InputMismatchException e)
            {
                System.out.println("Invalid choice input. Please enter a valid choice (1 or 2).");
                scanner.nextLine();
            }
        }
    }
}
