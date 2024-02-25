package model;

/**
 * Account stores each valid account as an Account object which has the 3 fields, account number,
 * account balance, last payment date.
 */
public class Account {
    /**
     * acctNum is the account number as a String
     */
    private String acctNum;
    /**
     * acctBal is the account balance as a String
     */
    private String acctBal;
    /**
     * acctLastPaidDate is the account last paid date as a String
     */
    private String acctLastPaidDate;

    /**
     * Constructor to initialise the variables with account number, account balance and last payment date
     *
     * @param acctNum refers to the account number
     * @param acctBal refers to the account balance
     * @param acctLastPaidDate refers to the last payment date
     */

    public Account(String acctNum, String acctBal, String acctLastPaidDate){
        this.acctNum = acctNum;
        this.acctBal = acctBal;
        this.acctLastPaidDate = acctLastPaidDate;
    }

    /**
     * Method to get the account balance
     *
     * @return account balance
     */
    public String getAcctBal(){
        return this.acctBal;
    }

    /**
     * Method to get the account last paid date
     *
     * @return account last paid date
     */
    public String getAcctLastPaidDate(){
        return this.acctLastPaidDate;
    }

    /**
     * Method to format a string for printing the account number, account balance and account last paid date
     *
     * @return string format of acctNum, acctBal and acctLastPaidDate
     */
    @Override
    public String toString(){
        return String.format("Acct: %s, Bal: %s, LastPaid: %s", this.acctNum, this.acctBal, this.acctLastPaidDate);
    }
}
