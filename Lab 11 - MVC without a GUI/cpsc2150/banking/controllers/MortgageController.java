package cpsc2150.banking.controllers;

import cpsc2150.banking.models.Customer;
import cpsc2150.banking.models.ICustomer;
import cpsc2150.banking.models.IMortgage;
import cpsc2150.banking.models.Mortgage;
import cpsc2150.banking.views.IMortgageView;
import cpsc2150.banking.views.MortgageView;

public class MortgageController implements IMortgageController{

    IMortgageView view;
    public MortgageController(IMortgageView c)
    {
        //new object for the view
        view = c;
    }

    public void submitApplication()
    {
        boolean user = true;

        while (user == true)
        {
            //Gets customer name
            String name = view.getName();

            //Customer income
            double yearlyIncome = view.getYearlyIncome();

            //Validation
            while (yearlyIncome <= 0)
            {
                view.printToUser("Income must be greater than 0.");
                yearlyIncome = view.getYearlyIncome();
            }

            //Customer debt payments
            double monthlyDebt = view.getMonthlyDebt();

            //Validation
            while (monthlyDebt < 0)
            {
                view.printToUser("Debt must be greater than or equal to 0.");
                monthlyDebt = view.getMonthlyDebt();
            }

            //Customer credit score
            int creditScore = view.getCreditScore();

            //Validation
            while (creditScore >= 850 || creditScore <= 0)
            {
                view.printToUser("Credit Score must be greater than 0 and less than 850");
                creditScore = view.getCreditScore();
            }

            //Customer object
            ICustomer customer = new Customer(monthlyDebt, yearlyIncome, creditScore, name);

            //Loop condition
            boolean mortgage;
            do
            {
                //Get cost
                double houseCost = view.getHouseCost();

                //Validation
                while (houseCost <= 0)
                {
                    view.printToUser("Cost must be greater than 0.");
                    houseCost = view.getHouseCost();
                }

                //Get dp
                double downPayment = view.getDownPayment();

                //Validation
                while (downPayment >= houseCost || downPayment <= 0)
                {
                    view.printToUser("Down Payment must be greater than 0 and less than the cost of the house.");
                    downPayment = view.getDownPayment();
                }

                //get years
                int years = view.getYears();

                //Validation
                while (years <= 0)
                {
                    view.printToUser("Years must be greater than 0.");
                    years = view.getYears();
                }

                //New mortgage object
                IMortgage newMortgage = new Mortgage(houseCost, downPayment, years, customer);

                //Variable for if loan approved or not
                boolean accepted = newMortgage.loanApproved();

                //Print customre info
                view.printToUser(customer.toString());

                //Approved
                if (accepted == true)
                {
                    //Print info and that loan approved
                    view.printToUser(newMortgage.toString());
                    view.displayApproved(accepted);
                }
                else
                {
                    //Print that loan denied
                    view.displayApproved(accepted);
                }
                //Ask for a new mortgage or not
                mortgage = view.getAnotherMortgage();
            } while (mortgage == true); //Loop until user doesn't want to enter new mortgage

            //Ask for a new customer or not
            user = view.getAnotherCustomer();
        }
    }
}
