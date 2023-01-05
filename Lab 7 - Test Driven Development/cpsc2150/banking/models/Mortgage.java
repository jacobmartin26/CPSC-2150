package cpsc2150.banking.models;
/**
 * This class..
 * @invariants mYears >= 0 AND payment >= 0 AND mRate >= 0 AND APR >= BASERATE
 *             AND debtToIncomeRatio >= 0 AND principal >= 0 AND
 *             numberOfPayments >= 0 AND percentDown >= 0
 *
 * @correspondences self.Payment = payment AND self.Rate = mRate AND self.Customer = mCustomer
 *                  AND self.DebtToIncomeRatio = debtToIncomeRatio AND self.Principal = principal
 *                  AND self.NumberOfPayments = numberOfPayments AND self.PercentDown = percentDown
 */

public class Mortgage extends AbsMortgage implements IMortgage{
    public static final double MINDOWN = 3.5;
    public static final int MONTHS = 12;
    public static final int GOODYEARS = 30;
    public static final int THRESHOLD = 20;
    public static final int PERCENTMULTI = 100;
    private ICustomer mCustomer;
    private int mYears;
    private double payment;
    private double mRate;
    private double debtToIncomeRatio;
    private double principal;
    private double numberOfPayments;// Z - total number of payments the customer will make on the loan
    private double percentDown; // R - The percent of the house cost covered by the down payment

    /**
     * Assigns values to many private variables that are then used to calculate
     * things such as APR and whether a loan is approved or not
     *
     * @param cost the cost of the home
     * @param down down payment on the home
     * @param years number of years for loan
     * @param customer object that is applying for loan
     *
     * @pre cost >= 0 AND down >= 0 AND years >= 0 AND [customer must contain appropriate values]
     *
     * @post mYears = years AND mCustomer = customer AND
     *       principal = cost - down AND numberOfPayments = mYears * MONTHS AND
     *       percentDown = (down / cost) * PERCENTMULTI AND
     *       APR = [varying rates depending on conditions] AND mRate = APR / MONTHS
     *       AND payment = (mRate*principal)/(1-(Math.pow((1 + mRate),(-1 * numberOfPayments))))
     *       AND debtToIncomeRatio = (mCustomer.getMonthlyDebtPayments()+payment)/(mCustomer.getIncome()/MONTHS)
     */
    public Mortgage(double cost, double down, int years, ICustomer customer){
       //Assigning values to variables to use later
        mYears = years;
        mCustomer = customer;
        numberOfPayments = mYears * MONTHS;
        percentDown = (down / cost) * PERCENTMULTI;
        principal = cost - down;

        //Calculating APR from given conditions
        double APR = BASERATE;
        if(mYears < GOODYEARS)
        {
            APR = APR + GOODRATEADD;
        }
        else
        {
            APR = APR + NORMALRATEADD;
        }

        if(percentDown < THRESHOLD)
        {
            APR = APR + GOODRATEADD;
        }

        //Further APR calculation using the customer's credit score
        if(mCustomer.getCreditScore() < BADCREDIT)
        {
            APR = APR + VERYBADRATEADD;
        }
        else if(BADCREDIT <= mCustomer.getCreditScore() && mCustomer.getCreditScore() < FAIRCREDIT)
        {
            APR = APR + BADRATEADD;
        }
        else if(FAIRCREDIT <= mCustomer.getCreditScore() && mCustomer.getCreditScore() < GOODCREDIT)
        {
            APR = APR + NORMALRATEADD;
        }
        else if(GOODCREDIT <= mCustomer.getCreditScore() && mCustomer.getCreditScore() < GREATCREDIT)
        {
            APR = APR + GOODRATEADD;
        }
        //Setting value for rate using final APR value
        mRate = APR / MONTHS;

        //Calculating values for last 2 variables now that other variable values have been obtained
        payment = (mRate * principal) / (1-(Math.pow((1 + mRate),(-1 * numberOfPayments))));
        debtToIncomeRatio = ((mCustomer.getMonthlyDebtPayments()+getPayment()) / (mCustomer.getIncome()/MONTHS));
    }

    public boolean loanApproved()
    {
        //Conditions return false if the loan is not approved for a given condition
        if (percentDown < MINDOWN)
        {
            return false;
        }
        if(mRate * MONTHS >= RATETOOHIGH)
        {
            return false;
        }
        if (debtToIncomeRatio > DTOITOOHIGH)
        {
            return false;
        }
        //Returns true if approved for a loan
        return true;
    }

    public double getPayment()
    {
        return payment;
    }

    public double getRate()
    {
        //Returns yearly rate
        return mRate * MONTHS;
    }

    public double getPrincipal()
    {
        return principal;
    }

    public int getYears()
    {
        return mYears;
    }
}
