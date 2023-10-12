import java.util.InputMismatchException;
import java.util.Scanner;

class Node<T>
{
    T data;
    Node<T> next;

    Node(T value)
    {
        next = null;
        this.data = value;
    }
}

class StackOverloadException extends RuntimeException {
    public StackOverloadException(String message) {
        super(message);
    }
}

class StackEmptyException extends RuntimeException {
    public StackEmptyException(String message) {
        super(message);
    }
}

class GenericStack<T> {
    private Node<T> top;
    private final int  maxSize;
    private int currentSize;

    GenericStack(int maxSize) {
        top = null;
        this.maxSize = maxSize;
        this.currentSize = 0;
    }

    public void push(T value) {
        if (currentSize >= maxSize)
        {
            System.out.println("Warning: Stack is overloaded. Cannot push more elements.");
            return;
        }

        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        currentSize++;
    }

    public T pop() {
        if (isEmpty())
        {
            throw new StackEmptyException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        currentSize--;
        return data;
    }

    public boolean isEmpty()
    {
        if(top==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int size() {
        return currentSize;
    }

    public T getTop()
    {
        return top.data;
    }

}


class Question1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int size = 0;
        boolean validSize = false;

        while (!validSize)
        {
            System.out.print("Enter the size of stack: ");
            try {
                size = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                validSize = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the stack size.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
        System.out.println("\n");

        GenericStack<Integer> stack = new GenericStack<>(size);

        int choice;
        while(true)
        {
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Top");
            System.out.println("4. Size");
            System.out.println("5. IsEmpty");
            System.out.println("6. Quit");
            System.out.print("Enter Choice: ");

            try
            {
                choice = scanner.nextInt();
                if(choice==1)
                {
                    System.out.print("Enter your element: ");
                    int value = scanner.nextInt();
                    stack.push(value);

                }
                else if(choice==2)
                {
                    try {
                        int value = stack.pop();
                        System.out.println("Popped element: " + value);
                    } catch (StackEmptyException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                else if(choice==3)
                {
                    if(!stack.isEmpty())
                    {
                        System.out.println("Top element: "+stack.getTop());
                    }
                    else
                    {
                        System.out.println("Stack is empty!");
                    }
                }
                else if(choice==4)
                {
                    System.out.println("Current size of stack: "+stack.size());
                }
                else if(choice==5)
                {
                    if(!stack.isEmpty())
                    {
                        System.out.println("Stack is not empty!");
                    }
                    else
                    {
                        System.out.println("Stack is empty!");
                    }
                }
                else if(choice==6)
                {
                    scanner.close();
                    System.exit(0);
                }
                else
                {
                    System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.nextLine();
            }

            System.out.println("\n");

        }



        //String type Stack:


        // GenericStack<String> stack = new GenericStack<String>(size);

        //     int choice;
        //     while (true) {
        //         System.out.println("1. Push");
        //         System.out.println("2. Pop");
        //         System.out.println("3. Top");
        //         System.out.println("4. Size");
        //         System.out.println("5. IsEmpty");
        //         System.out.println("6. Quit");
        //         System.out.print("Enter Choice: ");

        //         String input = scanner.nextLine();

        //         try {
        //             choice = Integer.parseInt(input);

        //             if (choice == 1) {
        //                 System.out.print("Enter your element: ");
        //                 String value = scanner.nextLine();
        //                 stack.push(value);
        //             } else if (choice == 2) {
        //                 try {
        //                     String value = stack.pop();
        //                     System.out.println("Popped element: " + value);
        //                 } catch (StackEmptyException e) {
        //                     System.out.println("Warning: " + e.getMessage());
        //                 }
        //             } else if (choice == 3) {
        //                 if (!stack.isEmpty()) {
        //                     System.out.println("Top element: " + stack.getTop());
        //                 } else {
        //                     System.out.println("Stack is empty!");
        //                 }
        //             } else if (choice == 4) {
        //                 System.out.println("Current size of stack: " + stack.size());
        //             } else if (choice == 5) {
        //                 if (!stack.isEmpty()) {
        //                     System.out.print("Stack is not empty!");
        //                 } else {
        //                     System.out.println("Stack is empty!");
        //                 }
        //             } else if (choice == 6) {
        //                 scanner.close();
        //                 System.exit(0);
        //             } else {
        //                 System.out.println("Invalid choice. Please enter a valid option.");
        //             }
        //         } catch (NumberFormatException e)
        // {
        //             System.out.println("Invalid input. Please enter a valid integer choice.");
        //         }
        //     }

    }

    // public static void clearScreen() {
    //     System.out.print("\033[H\033[2J");
    //     System.out.flush();
    // }


}
