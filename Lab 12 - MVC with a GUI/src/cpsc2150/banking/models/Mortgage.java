package cpsc2150.banking.models;
/**
 * This class..
 * @invariants
 * @correspondences
 */

public class Mortgage extends AbsMortgage implements IMortgage{
    private ICustomer mCustomer;
    private int mYears;
    private double mDown;
    private double mCost;
    private double payment;
    private double rate;
    private double debtToIncomeRatio;
    private double principal;
    private int numberOfPayments;// Z - total number of payments the customer will make on the loan
    private double percentDown; // R - The percent of the house cost covered by the down payment
    /**
     * This constructor...
     *
     */
    public Mortgage(double cost, double down, int years, ICustomer customer){
        mCost = cost;
        mDown = down;
        mYears = years;
        mCustomer = customer;
        principal = mCost - mDown;
        numberOfPayments = mYears * 12;
        percentDown = mDown / mCost;
        rate = BASERATE;
        if(years < MAX_YEARS)
            rate += GOODRATEADD;
        else
            rate += NORMALRATEADD;

        if(percentDown < PREFERRED_PERCENT_DOWN)
            rate += GOODRATEADD;

        if(mCustomer.getCreditScore() < BADCREDIT)
            rate += VERYBADRATEADD;
        else if(mCustomer.getCreditScore() < FAIRCREDIT)
            rate += BADRATEADD;
        else if(mCustomer.getCreditScore() < GOODCREDIT)
            rate += NORMALRATEADD;
        else if(mCustomer.getCreditScore() < GREATCREDIT)
            rate += GOODRATEADD;

        rate = rate/12;
        payment = (rate*principal) / (1- Math.pow((1 + rate), - numberOfPayments));
        debtToIncomeRatio = (mCustomer.getMonthlyDebtPayments() + getPayment()) / (mCustomer.getIncome() / 12);
    }

    /**
     * This method checks to see if the mortgage loan has been approved or not.
     *
     * @return true if the loan is approved, false otherwise.
     *
     * @post loanApproved iff (Rate*12 < RATE_TOO_HIGH AND PercentDown >= MIN_PERCENT_DOWN AND DebtToIncomeRatio <= DTOITOOHIGH) AND
     *          Payment = #Payment AND Rate = #Rate AND Customer = #Customer AND DebtToIncomeRatio = #DebtToIncomeRatio AND
     *          Principal = #Principal AND NumberOfPayments = #NumberOfPayments AND PercentDown = #PercentDown
     */
    public boolean loanApproved()
    {
        if(getRate() >= RATETOOHIGH || percentDown < MIN_PERCENT_DOWN || debtToIncomeRatio > DTOITOOHIGH)
            return false;
        else
            return true;
    }

    public double getPayment()
    {
        return payment;
    }

   public double getRate()
    {
        return rate * 12;
    }

    public double getPrincipal()
    {
        return principal;
    }

    public int getYears()
    {
        return numberOfPayments / 12;
    }
}
