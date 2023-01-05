package cpsc2150.banking.controllers;

import cpsc2150.banking.models.Customer;
import cpsc2150.banking.models.ICustomer;
import cpsc2150.banking.models.IMortgage;
import cpsc2150.banking.models.Mortgage;
import cpsc2150.banking.views.*;

public class MortgageGUIController implements IMortgageController {
    private IMortgageView view;

    public MortgageGUIController(IMortgageView v) {
        view = v;
    }

    public void submitApplication() {
        boolean cust = true;

        // get a user's name
        String name = view.getName();

        // get their income
        double income = view.getYearlyIncome();
        if(income <= 0)
        {
            // validation
            view.printToUser("Income must be greater than 0.");
            income = view.getYearlyIncome();
        }

        // get their debt
        double debt = view.getMonthlyDebt();
        if(debt < 0)
        {
            // validation
            view.printToUser("Debt must be greater than or equal to 0.");
            debt = view.getMonthlyDebt();
        }

        // get their credit score
        int creditScore = view.getCreditScore();
        if(creditScore <= 0 || creditScore >= 850)
        {
            // validation
            view.printToUser("Credit score must be greater than 0 and less than 850.");
            creditScore = view.getCreditScore();
        }

        boolean mort = true;

        // get their house cost
        double cost = view.getHouseCost();
        if(cost <= 0)
        {
            // validation
            view.printToUser("Cost must be greater than 0.");
            cost = view.getHouseCost();
        }

        // get the down payment
        double dp = view.getDownPayment();
        if(dp <= 0 || dp >= cost)
        {
            // validation
            view.printToUser("Down payment must be greater than 0 and less than house cost");
            dp = view.getDownPayment();
        }

        // get the years
        int years = view.getYears();
        if(years <= 0)
        {
            // validation
            view.printToUser("Years must be greater than 0.");
            years = view.getYears();
        }

        // create customer object to hold the info
        ICustomer customer = new Customer(debt, income, creditScore, name);

        // mortgage object to hold rest of info
        IMortgage newMortgage = new Mortgage(cost, dp, years, customer);

        // see if loan was approved or not and tell user
        boolean approved = newMortgage.loanApproved();
        view.printToUser(customer.toString());

        if(approved)
        {
            view.printToUser(newMortgage.toString());
        }

        view.displayApproved(approved);
        view.displayRate(newMortgage.getRate());
        view.displayPayment(newMortgage.getPayment());

        mort = view.getAnotherMortgage();
        cust = view.getAnotherCustomer();
    }
}