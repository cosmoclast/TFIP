//Yeo Beng Koon Bernard

/**
 * Allows creation of a bank account with unique <code>accountNumber</code>. Can store <code>accountName</code>,
 * <code>balance</code> and <code>transactionHistory</code>. Has methods to <code>deposit</code> and
 * <code>withdraw</code> funds from the account. Has methods to <code>displayBalance</code> and
 * <code>displayTransactionHistory/</code>
 */
public class DigiBankAccount {

    /** Stores account name of account holder*/
    private String accountName;
    /** Stores account number of account holder*/
    private String accountNumber;
    /** Keeps track of number of instances of <code>DigiBankAccount</code> created */
    private static int numberOfAccounts = 0;
    /** Stores balance in account */
    private long balance;
    /** Stores transaction type (withdraw/deposit) in [][0] and transaction amount in [][1] */
    private String[][] transactionHistory;
    /** Keeps track of number of valid transactions */
    private int transactionCount;

    /**
     * Class Constructor to initialise <code>accountName</code>, <code>accountNumber</code>, <code>balance</code>,
     * <code>transactionHistory</code> and <code>transactionCount</code>
     *
     * @param accountHolder the name of the account
     */
    public DigiBankAccount(String accountHolder){
        this.accountName = accountHolder;
        this.numberOfAccounts++;
        this.accountNumber = "1234" + String.format("%04d", getNumberOfAccounts());
        this.balance = 0;
        this.transactionHistory = new String[5][2];
        this.transactionCount = 0;
    }

    /**
     * Handles edge case where user keys in no arguments to <code>deposit</code> method.
     */
    public void deposit(){
        System.out.println("Null inputs are not allowed");
    }

    /**
     * Checks <code>depositAmount</code> for negative or zero values and checks if reached maximum limit of 5 valid
     * transactions, before recording as valid transaction in <code>transactionHistory</code>,
     * incrementing <code>balance</code> and incrementing <code>transactionCount</code>.
     *
     * @param depositAmount the deposit amount to the account
     */
    public void deposit(double depositAmount) {
        long depositAmountTruncate = (long) (depositAmount * 100);

        if (depositAmountTruncate <= 0) {
            //Check whether depositAmount is less than or equal to zero
            System.out.println("Deposit amount cannot be negative or zero");
        } else if (this.transactionCount == 5) {
            //Check whether number of transactions has exceeded 5
            System.out.println("Maximum limit of 5 transactions reached");
        } else {
            //Update transaction history with valid deposit
            this.balance += depositAmountTruncate;
            this.transactionHistory[this.transactionCount][0] = "deposit";
            this.transactionHistory[this.transactionCount][1] = String.format("%.2f", ((double) depositAmountTruncate) / 100);
            this.transactionCount++;
        }
    }

    /**
     * Handles edge case where user keys in no arguments to <code>withdraw</code> method.
     */
    public void withdraw(){
        System.out.println("Null inputs are not allowed");
    }

    /**
     * Checks <code>withdrawAmount</code> for negative or zero values, checks if reached maximum limit of 5 valid
     * transactions, checks enough <code>balance</code> for withdrawal before recording as valid transaction
     * in <code>transactionHistory</code>, incrementing <code>balance</code>
     * and incrementing <code>transactionCount</code>.
     *
     * @param withdrawAmount the withdraw amount from the account
     */
    public void withdraw(double withdrawAmount){
        long withdrawAmountTruncate = (long)(withdrawAmount * 100);

        if(withdrawAmountTruncate <= 0){
            //Check whether withdrawAmount is less than or equal to zero
            System.out.println("Withdraw amount cannot be negative or zero");
        }else if(this.transactionCount == 5){
            //Check whether number of transactions has exceeded 5
            System.out.println("Maximum limit of 5 transactions reached");
        }else if((this.balance - withdrawAmountTruncate) < 0){
            //Check whether there is enough balance to withdraw
            System.out.println("There is not enough balance in the account");
        }else{
            //Update transaction history with valid withdrawal
            this.balance -= withdrawAmountTruncate;
            this.transactionHistory[this.transactionCount][0] = "withdraw";
            this.transactionHistory[this.transactionCount][1] = String.format("%.2f", ((double)withdrawAmountTruncate)/100 );
            this.transactionCount++;
        }
    }

    /**
     * Returns <code>numberOfAccounts</code> value.
     *
     * @return  this.numberOfAccounts the counter to keep track of number of instances of object that has been created.
     */
    public int getNumberOfAccounts() {
        return this.numberOfAccounts;
    }

    /**
     * Displays <code>balance</code> of the account
     */
    public void displayBalance(){
        System.out.printf("Balance: %.2f\n", ((double)this.balance/100) );
    }

    /**
     * Displays <code>accountName</code>, <code>accountNumber</code>, <code>balance</code> and
     * <code>transactionHistory</code> of the account.
     */
    public void displayTransactionHistory(){
        System.out.printf("Account Name: %s\n", this.accountName);
        System.out.printf("Account Number: %s\n", this.accountNumber);
        displayBalance();

        //To iterate through the transactionHistory array and display transaction history.
        for(int row = 0 ; row < this.transactionCount ; row++){
            System.out.printf("%d. %s %s\n", (row+1), this.transactionHistory[row][0], this.transactionHistory[row][1]);
        }

        System.out.println();
    }
}
