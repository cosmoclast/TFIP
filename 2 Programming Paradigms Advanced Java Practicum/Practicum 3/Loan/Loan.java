package Loan;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract class to calculate the optimum repayment amount with interest for the student loan.<br>
 * It also calculates the total amount of interest payable for the repayment period.
 *
 * @author Bernard Yeo
 */

public abstract class Loan {
    /**
     * Annual percentage rate, aka interest rate
     */
    protected BigDecimal annualRates;
    /**
     * Initial loan amount, down payment already subtracted from this amount
     */
    private BigDecimal principleAfterDownPayment;
    /**
     * Length of the loan period in months/ total number of payments, assuming monthly repayments
     */
    private int termInMonths;
    /**
     * Type of loan
     */
    protected String loanType;
    /**
     * RoundingMode used in optimumRepaymentWithInterest calculation
     */
    protected RoundingMode interestCalcRounding;
    /**
     * Divide the annualRate by the annualRateDivisor
     */
    protected BigDecimal annualRateDivsior;

    /**
     * Constructor for the Loan
     *
     * @param principle Initial loan amount
     * @param downPayment Down payment to offset initial loan amount
     * @param mths Length of the loan period in months
     */
    public Loan(double principle, double downPayment, int mths) {
        this.principleAfterDownPayment = new BigDecimal(principle).subtract(new BigDecimal(downPayment));
        this.termInMonths = mths;
    }

    /**
     * Calculates the optimum repayment amount with interest and the total interest payable
     * for the principle amount, interest rates and loan period. <br>
     * It returns an array of size 2:<br>
     * 1. optimum repayment amount <br>
     * 2. total interest payable
     *
     * @return An array of BigDecimal
     */
    public BigDecimal[] optimumRepaymentWithInterest() {
        BigDecimal[] results = new BigDecimal[2];

        // Convert to some weird Monthly interest rate (divide by 9)
        BigDecimal mthInterestRate = this.annualRates.divide(this.annualRateDivsior,
                6, this.interestCalcRounding);
        // exponent calculation
        BigDecimal temp = new BigDecimal(1);
        for (int i=0; i<this.termInMonths; i++) {
            temp = temp.multiply((new BigDecimal(1)).add(mthInterestRate))
                    .setScale(6, this.interestCalcRounding);
        }
        BigDecimal numerator = mthInterestRate.multiply(temp);
        BigDecimal denominator = temp.subtract(new BigDecimal(1));

        // optimum repayment amount
        results[0] = this.principleAfterDownPayment.multiply(numerator)
                .divide(denominator, 6, this.interestCalcRounding)
                .setScale(2, this.interestCalcRounding);

        // total interest
        results[1] = results[0].multiply(BigDecimal.valueOf(this.termInMonths))
                .subtract(this.principleAfterDownPayment);

        return results;

    }

    /**
     * Overridden toString method from Object class.
     */
    @Override
    public String toString() {

            return String.format("""
                Loan type: %s
                Principle: $%.2f
                Annual Percentage Rate: %.2f%%
                Term (in months): %d
                """,
                    this.loanType,
                    this.principleAfterDownPayment.doubleValue(),
                    this.annualRates.multiply(new BigDecimal(100)),
                    this.termInMonths);
    }
}
