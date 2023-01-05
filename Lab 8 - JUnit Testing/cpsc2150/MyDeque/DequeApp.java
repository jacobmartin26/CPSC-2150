// By: Jacob Martin and David Novo

package cpsc2150.MyDeque;
import java.util.*;

public class DequeApp {

    public static void main(String[] args){
        IDeque<Double> q;
        Scanner keyScanner = new Scanner(System.in);

        /**
         Prompt the user to pick an implementation using the following
         message: "Enter 1 for array implementation or 2 for List
         implementation"
         Your code needs to make sure that they only enter either 1 or 2.
         Re-print the message to prompt the user to enter it again. Once
         you have gotten an answer, use it to initialize q appropriately.
         */
        int choice = 0;
        while (choice != 1 && choice != 2)
        {
            System.out.println("Enter 1 for array implementation or 2 for List implementation");
            choice = Integer.parseInt(keyScanner.nextLine());
        }
        if(choice == 1)
        {
            q = new ArrayDeque<Double>();
        }
        else
        {
            q = new ListDeque<Double>();
        }

        //menu for the deque methods
        choice = 0;
        while(choice != 12) {
            System.out.println("Select an option:");
            System.out.println("1. Add to the end of the Deque");
            System.out.println("2. Add to the front of the Deque");
            System.out.println("3. Remove from the front of the Deque");
            System.out.println("4. Remove from the end of the Deque");
            System.out.println("5. Peek from the front of the Deque");
            System.out.println("6. Peek from the end of the Deque");
            System.out.println("7. Insert to a position in the Deque");
            System.out.println("8. Remove from a position in the Deque");
            System.out.println("9. Get a position in the Deque");
            System.out.println("10. Get the length of the Deque");
            System.out.println("11. Clear the Deque");
            System.out.println("12. Quit");

            choice = Integer.parseInt(keyScanner.nextLine());
            int userIndex;
            double userInput;

            switch(choice)
            {
                case 1:
                    System.out.println("What double to enqueue to the end of the Deque?");
                    userInput = Double.parseDouble(keyScanner.nextLine());
                    q.enqueue(userInput);
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 2:
                    System.out.println("What double to inject to the front of the Deque?");
                    userInput = Double.parseDouble(keyScanner.nextLine());
                    q.inject(userInput);
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 3:
                    if(q.length() == 0)
                    {
                        System.out.println("Deque is empty!");
                    }
                    else
                    {
                        System.out.println("Double at the front: " + q.dequeue());
                    }
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 4:
                    if(q.length() == 0)
                    {
                        System.out.println("Deque is empty!");
                    }
                    else
                    {
                        System.out.println("Double at the end: " + q.removeLast());
                    }
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 5:
                    if(q.length() == 0)
                    {
                        System.out.println("Deque is empty!");
                    }
                    else
                    {
                        System.out.println("Double at the front: " + q.peek());
                    }
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 6:
                    if(q.length() == 0)
                    {
                        System.out.println("Deque is empty!");
                    }
                    else
                    {
                        System.out.println("Double at the front: " + q.endOfDeque());
                    }
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 7:
                    if(q.length() == 0)
                    {
                        System.out.println("Deque is empty!");
                    }
                    else
                    {
                        System.out.println("What double to insert to the Deque?");
                        userInput = Double.parseDouble(keyScanner.nextLine());
                        System.out.println("What position to insert in?");
                        userIndex = Integer.parseInt(keyScanner.nextLine());
                        while(userIndex < 0 && userIndex > q.length() - 1)
                        {
                            System.out.println("Not a valid position in the Deque!");
                            System.out.println("What position to insert in?");
                            userIndex = Integer.parseInt(keyScanner.nextLine());
                        }
                        q.insert(userInput, userIndex);
                    }
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 8:
                    if(q.length() == 0)
                    {
                        System.out.println("Deque is empty!");
                    }
                    else
                    {
                        System.out.println("What position to remove from the Deque?");
                        userIndex = Integer.parseInt(keyScanner.nextLine());
                        if(userIndex >= q.length())
                        {
                            System.out.println("Invalid position in Deque!");
                            System.out.println("Deque is:");
                            System.out.println(q.toString());
                            break;
                        }
                        while(userIndex < 0 && userIndex > q.length() - 1)
                        {
                            System.out.println("Not a valid position in the Deque!");
                            System.out.println("What position to insert in?");
                            userIndex = Integer.parseInt(keyScanner.nextLine());
                        }
                        System.out.println(q.get(userIndex) + " was at position "+ userIndex + " in the Deque.");
                        q.remove(userIndex);
                    }
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 9:
                    if(q.length() == 0)
                    {
                        System.out.println("Deque is empty!");
                    }
                    else
                    {
                        System.out.println("What position to get from the Deque?");
                        userIndex = Integer.parseInt((keyScanner.nextLine()));
                        while(userIndex < 0 && userIndex > q.length() - 1)
                        {
                            System.out.println("Not a valid position in the Deque!");
                            System.out.println("What position to get from the Deque?");
                            userIndex = Integer.parseInt((keyScanner.nextLine()));
                        }
                        System.out.println(q.get(userIndex) + " is at position " + userIndex + " in the Deque!");
                    }
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 10:
                    System.out.println("Length of Deque: " + q.length());
                    if(q.length() == 0)
                    {
                        System.out.println("Deque is empty!");
                    }
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 11:
                    q.clear();
                    System.out.println("Deque is now empty!");
                    System.out.println("Deque is:");
                    System.out.println(q.toString());
                    break;
                case 12:
                    System.out.println("Quitting Program!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Not a valid option!");
                    break;
            }
        }
    }
}
