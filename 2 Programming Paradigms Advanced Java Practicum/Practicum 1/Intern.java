import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A child class of the employee class that implements the setup of wage components based on the fixed allowance of
 * a fixed allowance employee by overriding the abstract method <code>setupWageComponents</code>
 * from the employee class. Implementation of the <code>generatePayroll</code> overrides the employee class method by
 * changing the values in the <code>payroll[]</code> array directly.
 */

public class Intern extends Employee{
    /** Variable for employee fixed allowance*/
    private BigDecimal fixedAllowance;

    /**
     * Class Constructor to initialise <code>name</code>, <code>fixedAllowance</code>
     *
     * @param name name of employee
     * @param fixedAllowance employee hours
     */
    public Intern(String name, BigDecimal fixedAllowance){
        super(name);
        this.fixedAllowance = fixedAllowance;
    }

    /**
     * Overriding of the abstract method in the employee class to implement a concrete method to calculate the
     * ordinary wage and additional wage and gross pay of a fixed allowance employee
     */
    @Override
    protected void setupWageComponents(){

        if(this.fixedAllowance.compareTo(BigDecimal.ZERO) == -1) {

        }else{
            BigDecimal fixedAllowanceRounded = this.fixedAllowance.setScale(2,RoundingMode.DOWN);

            setOrdinaryWage(fixedAllowanceRounded);
            setAdditionalWage(BigDecimal.ZERO);
            setGrossPay(getOrdinaryWage());

        }
    }

    /**
     * Overriding of concrete method in the employee class to default the fixed allowance employee CDF calculation to
     * the nil CDF contribution case by changing the values in the <code>payroll[]</code> array directly.
     */
    @Override
    protected BigDecimal[] generatePayroll() {
        BigDecimal[] payroll = super.generatePayroll();
        payroll[1] = new BigDecimal("0.00");
        payroll[2] = new BigDecimal("0.00");
        payroll[3] = payroll[0];
        payroll[4] = new BigDecimal("0.00");

        return payroll;
    }
}

