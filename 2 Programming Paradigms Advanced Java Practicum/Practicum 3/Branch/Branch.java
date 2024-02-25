package Branch;
import Loan.*;

/**
 * Abstract class to create the loan object and has a concrete input checker to check
 * for valid inputs
 *
 * @author Bernard Yeo
 */
 public abstract class Branch {

    /**
     * Abstract method to create the loan object if the loan exists in that branch
     *
     * @param type type of loan
     * @param principle Initial loan amount
     * @param downPayment Down payment to offset initial loan amount
     * @param mths Length of the loan period in months
     * @return Loan object that has been created
     */
    public abstract Loan createLoan(String type, double principle, double downPayment, int mths);

    /**
     * Method to return the loan object to the client
     *
     * @param type type of loan
     * @param principle Initial loan amount
     * @param downPayment Down payment to offset initial loan amount
     * @param mths Length of the loan period in months
     * @return Loan object that has been created
     */
    public Loan applyForLoan(String type, double principle, double downPayment, int mths){

        Loan loan = createLoan(type, principle, downPayment, mths);
        return loan;
    }

    /**
     * Method to do input checking for the principle, down payment and months
     *
     * @param principle Initial loan amount
     * @param downPayment Down payment to offset initial loan amount
     * @param mths Length of the loan period in months
     * @return true if input checking all pass
     */
    public boolean inputChecker(double principle, double downPayment, int mths){
        if (mths <= 0){
            System.out.println("Number of months cannot be negative or zero");
            return false;
        }else if(principle <= 0){
            System.out.println("Principle cannot be negative or zero");
            return false;
        }else if(downPayment < 0){
            System.out.println("Down payment cannot be negative");
            return false;
        }else if(downPayment >= principle){
            System.out.println("Down payment cannot be more than or equal to principle");
            return false;
        }else{
            return true;
        }
    }
}
