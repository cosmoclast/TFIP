package Loan;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Concrete class that only has a constructor to initialise principle,
 * downPayment, mths, annualRates, loanType, interestCalcRounding, annualRateDivisor
 *
 * @author Bernard Yeo
 */
public class CarLoan extends Loan {
    /**
     * Constructor for Car Loan
     *
     * @param principle Initial loan amount
     * @param downPayment Down payment to offset initial loan amount
     * @param mths Length of the loan period in months
     * @param apr interest percent
     * @param branch branch name
     */
    public CarLoan(double principle, double downPayment, int mths, int apr, String branch){
        super(principle, downPayment, mths);

        this.annualRates = new BigDecimal(apr).setScale(0, RoundingMode.UP).divide(
                new BigDecimal(100), 6, RoundingMode.UP);
        this.loanType = "Car " + "(" + branch + " Branch)";
        this.interestCalcRounding = RoundingMode.UP;
        this.annualRateDivsior = new BigDecimal(9);
    }
}
