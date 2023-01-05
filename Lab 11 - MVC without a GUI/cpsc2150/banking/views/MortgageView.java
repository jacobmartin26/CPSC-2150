package cpsc2150.banking.views;
import cpsc2150.banking.controllers.IMortgageController;
import cpsc2150.banking.controllers.MortgageController;

import java.util.*;

public class MortgageView implements IMortgageView {
    private Scanner scanner;
    private IMortgageController controller;

    /**
     * This constructor initializes the scanner for the class
     *
     * @post [The scanner for the class is initialized]
     */
    public MortgageView() {
        //Constructor initializes the scanner
        scanner = new Scanner(System.in);
    }

    public void setController(IMortgageController c){
        //Adds a controller for the view
        controller = c;
    }

    public double getHouseCost()
    {
        //Prompt for cost and return the answer
        System.out.println("How much does the house cost?");
        return scanner.nextDouble();
    }

    public double getDownPayment(){
        //Prompt for dp and return answer
        System.out.println("How much is the down payment?");
        return scanner.nextDouble();
    }

    public int getYears(){
        //Prompt for years and return answer
        System.out.println("How many years?");
        return scanner.nextInt();
    }

    public double getMonthlyDebt(){
        //Prompt for monthly payments and return answer
        System.out.println("How much are your monthly debt payments?");
        return scanner.nextDouble();
    }

    public double getYearlyIncome(){
        //Prompt for income and return answer
        System.out.println("How much is your yearly income?");
        return scanner.nextDouble();
    }

    public int getCreditScore(){
        //Prompt for credit score and return answer
        System.out.println("What is your credit score?");
        return scanner.nextInt();
    }

    public String getName(){
        //Prompt for name and return answer
        System.out.println("What's your name?");
        return scanner.nextLine();
    }

    public void printToUser(String s){
        //Prints out whatever string is passed in to the method
        System.out.println(s);
    }

    public void displayPayment(double p){
        //Prints out the principal amount
        String string = "";
        string += "Principal Amount: $" + p + "\n";
        System.out.println(string);
    }

    public void displayRate(double r){
        //Prints out Interest rate with proper formatting
        String string = "";
        string += "Interest Rate: ";
        string += String.format("%.1f", (r * 100)) + "%\n";
        System.out.println(string);
    }

    public void displayApproved(boolean a){
        //Signals if the loan was approved or not for the user

       /*if(a == false)
        {
            System.out.println("Your loan was not approved");
        }
        else
        {
            System.out.println("Your loan was approved");
        }*/
    }

    public boolean getAnotherMortgage(){
        //Prompts the user for a new mortgage or not
        System.out.println("Would you like to apply for another mortgage? Y/N");

        //Swallow the end of line character
        String choice = scanner.nextLine();

        //Get input from user
        choice = scanner.nextLine();
        choice = choice.toUpperCase();

        if(choice.equals("N"))
        {
            return false;
        }
        else if(choice.equals("Y"))
        {
            return true;
        }
        return false;
    }

    public boolean getAnotherCustomer(){
        //Prompts user for a new customer, if Y then will repeat entire process
        System.out.println("Would you like to consider another customer? Y/N");
        String choice = scanner.nextLine();
        choice = choice.toUpperCase();

        if(choice.equals("N"))
        {
            return false;
        }
        else if(choice.equals("Y"))
        {
            return true;
        }
        return false;
    }
}
