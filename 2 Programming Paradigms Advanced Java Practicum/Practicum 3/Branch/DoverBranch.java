package Branch;
import Loan.*;

/**
 * Concrete class to create the loan object using the createLoan method
 *
 * @author Bernard Yeo
 */
public class DoverBranch extends Branch {

    /**
     * String for the branch name
     */
    public static final String BRANCH = "Dover";

    /**
     * Method to return the correct Loan object based on the type of the Loan that was specified.
     * If loan is not available at the branch or the input checking fails, it will return a null
     * object. If it returns a null object, unable to call the optimumRepaymentWithInterest method.
     *
     * @param type type of loan
     * @param principle Initial loan amount
     * @param downPayment Down payment to offset initial loan amount
     * @param mths Length of the loan period in months
     * @return Loan object that has been created
     */
    @Override
    public Loan createLoan(String type, double principle, double downPayment, int mths) {

        String typeFormatted = type.toLowerCase().strip();

        if(inputChecker(principle, downPayment, mths)){
            if (typeFormatted.equals("student")) {
                return new StudentLoan(principle, downPayment, mths, 2, BRANCH);
            } else if (typeFormatted.equals("home")) {
                return new HomeLoan(principle, downPayment, mths, 5, BRANCH);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }
}

