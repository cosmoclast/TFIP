import Loan.*;
import Branch.*;
import java.math.BigDecimal;

/**
 * Driver class
 *
 * @author Bernard Yeo
 */
public class Main {

    /**
     * Main method
     * @param args commandline arguments (not used)
     */
    public static void main(String[] args) {
        DoverBranch dover01 = new DoverBranch();
        Loan s1 = dover01.applyForLoan("student", 20_000, 0, 10);
        System.out.print(s1);
        BigDecimal[] stat = s1.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat[1].doubleValue());


        DoverBranch dover02 = new DoverBranch();
        Loan h1 = dover02.applyForLoan("home", 350_000, 25_000, 300);
        System.out.print(h1);
        BigDecimal[] stat2 = h1.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat2[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat2[1].doubleValue());


        BukitTimahBranch bt02 = new BukitTimahBranch();
        Loan s2 = bt02.applyForLoan("student", 50_000, 0, 48);
        System.out.print(s2);
        BigDecimal[] stat4 = s2.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat4[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat4[1].doubleValue());


        BukitTimahBranch bt01 = new BukitTimahBranch();
        Loan h2 = bt01.applyForLoan("home", 1550_000, 100_000, 360);
        System.out.print(h2);
        BigDecimal[] stat3 = h2.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat3[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat3[1].doubleValue());


        BukitTimahBranch bt03 = new BukitTimahBranch();
        Loan c1 = bt03.applyForLoan("car", 80_000, 5_000, 60);
        System.out.print(c1);
        BigDecimal[] stat5 = c1.optimumRepaymentWithInterest();
        System.out.printf("Optimum Repayment Amount: $%.2f\n", stat5[0].doubleValue());
        System.out.printf("Total Interest: $%.2f\n\n", stat5[1].doubleValue());
    }
}