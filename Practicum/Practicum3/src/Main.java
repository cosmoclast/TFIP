import java.lang.Math;

public class Main {
    public static void main(String[] args) {

        DigiBankAccount a = new DigiBankAccount("a");
        a.deposit(100.00);
        a.withdraw(100.00);
        a.deposit(100.00);
        a.deposit(100.00);
        a.deposit(100.00);
        a.displayBalance();
        a.displayTransactionHistory();
       /* Balance: 300.00
        Account Name: a
        Account Number: 12340001
        Balance: 300.00
        1. deposit 100.00
        2. withdraw 100.00
        3. deposit 100.00
        4. deposit 100.00
        5. deposit 100.00*/


        DigiBankAccount b = new DigiBankAccount("b");
        b.deposit(200.00);
        b.deposit(200.00);
        b.withdraw(200.01);
        b.deposit(200.00);
        b.withdraw(399.99);
        b.displayBalance();
        b.displayTransactionHistory();
        /*Balance: 0.00
        Account Name: b
        Account Number: 12340002
        Balance: 0.00
        1. deposit 200.00
        2. deposit 200.00
        3. withdraw 200.01
        4. deposit 200.00
        5. withdraw 399.99*/

        //testing null
        DigiBankAccount c = new DigiBankAccount("c");
        c.displayBalance();
        c.displayTransactionHistory();
        /*Balance: 0.00
        Account Name: c
        Account Number: 12340003
        Balance: 0.00
        */

        //testing negative deposit and not enough balance and 5 decimal places
        DigiBankAccount d = new DigiBankAccount("d");
        d.deposit(200.00234);
        d.deposit(200.65562);
        d.withdraw(200.98652);
        d.deposit(-200.64145);
        d.withdraw(399.22951);
        d.displayBalance();
        d.displayTransactionHistory();
        /*Deposit amount cannot be negative or zero
        There is not enough balance in the account
        Balance: 199.67
        Account Name: d
        Account Number: 12340004
        Balance: 199.67
        1. deposit 200.00
        2. deposit 200.65
        3. withdraw 200.98
        */

        //testing negative withdrawal and exceed transactions and 5 decimal places
        DigiBankAccount e = new DigiBankAccount("e");
        e.deposit(200.034599);
        e.displayBalance();
        e.deposit(200.56788);
        e.displayBalance();
        e.withdraw(-200.26678);
        e.displayBalance();
        e.deposit(200.72573);
        e.displayBalance();
        e.withdraw(399.99178);
        e.displayBalance();
        e.withdraw(1.32400);
        e.displayBalance();
        e.withdraw(1.32400); //exceed transactions
        e.displayBalance();
        e.withdraw(1.32400); //exceed transactions
        e.displayBalance();
        e.withdraw(1.32400); //exceed transactions
        e.displayBalance();
        e.withdraw(1.32400); //exceed transactions
        e.displayBalance();
        e.displayTransactionHistory();
     /*   Balance: 200.03
        Balance: 400.59
        Withdraw amount cannot be negative or zero
        Balance: 400.59
        Balance: 601.31
        Balance: 201.32
        Balance: 200.00
        Maximum limit of 5 transactions reached
        Balance: 200.00
        Maximum limit of 5 transactions reached
        Balance: 200.00
        Maximum limit of 5 transactions reached
        Balance: 200.00
        Maximum limit of 5 transactions reached
        Balance: 200.00
        Account Name: e
        Account Number: 12340005
        Balance: 200.00
        1. deposit 200.03
        2. deposit 200.56
        3. deposit 200.72
        4. withdraw 399.99
        5. withdraw 1.32*/

        //testing zero deposit and zero withdrawal and 0 decimal places
        DigiBankAccount f = new DigiBankAccount("f");
        f.deposit(0);
        f.displayBalance();
        f.withdraw(0);
        f.displayBalance();
        f.deposit(200);
        f.displayBalance();
        f.withdraw(200);
        f.displayBalance();
        f.withdraw(0);
        f.displayBalance();
        f.deposit(0);
        f.displayBalance();
        f.deposit(200);
        f.displayBalance();
        f.deposit(399);
        f.displayBalance();
        f.withdraw(200);
        f.displayBalance();
        f.withdraw(-200);
        f.displayBalance();
        f.displayTransactionHistory();

        /*Deposit amount cannot be negative or zero
        Balance: 0.00
        Withdraw amount cannot be negative or zero
        Balance: 0.00
        Balance: 200.00
        Balance: 0.00
        Withdraw amount cannot be negative or zero
        Balance: 0.00
        Deposit amount cannot be negative or zero
        Balance: 0.00
        Balance: 200.00
        Balance: 599.00
        Balance: 399.00
        Withdraw amount cannot be negative or zero
        Balance: 399.00
        Account Name: f
        Account Number: 12340006
        Balance: 399.00
        1. deposit 200.00
        2. withdraw 200.00
        3. deposit 200.00
        4. deposit 399.00
        5. withdraw 200.00*/

        //testing null inputs to withdraw and deposit
        DigiBankAccount g = new DigiBankAccount("g");
        g.deposit();
        g.displayBalance();
        g.withdraw();
        g.displayBalance();
        g.displayTransactionHistory();
        /*Null inputs are not allowed
        Balance: 0.00
        Null inputs are not allowed
        Balance: 0.00
        Account Name: g
        Account Number: 12340007
        Balance: 0.00*/

    }
}