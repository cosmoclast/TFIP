import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A child class of the employee class that implements the setup of wage components based on the fixed salary
 * and business expenses of a fixed salary employee by overriding the abstract method
 * <code>setupWageComponents</code> from the employee class.
 */

public class Fixed extends Employee{

    /** Variable for employee fixed salary*/
    private BigDecimal fixedSalary;
    /** Variable for employee business expenses*/
    private BigDecimal bizExpenses;

    /**
     * Class Constructor to initialise <code>name</code>, <code>fixedSalary</code>, <code>bizExpenses</code>
     *
     * @param name name of employee
     * @param fixedSalary employee fixed salary
     * @param bizExpenses employee business expenses
     *
     */
    public Fixed(String name, BigDecimal fixedSalary, BigDecimal bizExpenses){
        super(name);
        this.fixedSalary = fixedSalary;
        this.bizExpenses = bizExpenses;
    }

    /**
     * Overriding of the abstract method in the employee class to implement a concrete method to calculate the
     * ordinary wage and additional wage and gross pay of a fixed salary employee
     */
    @Override
    public void setupWageComponents(){

        if(this.fixedSalary.compareTo(BigDecimal.ZERO) == -1 || this.bizExpenses.compareTo(BigDecimal.ZERO) == -1) {

        }else{
            BigDecimal fixedSalaryRounded = this.fixedSalary.setScale(2,RoundingMode.DOWN);
            BigDecimal bizExpensesRounded = this.bizExpenses.setScale(2,RoundingMode.DOWN);

            setOrdinaryWage(fixedSalaryRounded);
            setAdditionalWage(bizExpensesRounded);
            setGrossPay(getOrdinaryWage().add(getAdditionalWage()).setScale(2,RoundingMode.DOWN));

        }
    }
}

