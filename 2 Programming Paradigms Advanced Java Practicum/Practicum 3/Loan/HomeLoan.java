package Loan;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Concrete class that only has a constructor to initialise principle,
 * downPayment, mths, annualRates, loanType, interestCalcRounding, annualRateDivisor
 *
 * @author Bernard Yeo
 */
public class HomeLoan extends Loan {
    /**
     * Constructor for Home Loan
     *
     * @param principle Initial loan amount
     * @param downPayment Down payment to offset initial loan amount
     * @param mths Length of the loan period in months
     * @param apr interest percent
     * @param branch branch name
     */
    public HomeLoan(double principle, double downPayment, int mths, int apr, String branch){
        super(principle, downPayment, mths);

        this.annualRates = new BigDecimal(apr).divide(new BigDecimal(100), 6,RoundingMode.HALF_UP);
        this.loanType = "Home " + "(" + branch + " Branch)";
        this.interestCalcRounding = RoundingMode.UP;
        this.annualRateDivsior = new BigDecimal(6);
    }
}
