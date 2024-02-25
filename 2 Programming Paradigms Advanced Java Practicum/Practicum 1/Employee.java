import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * An abstract class used to create concrete employee classes.
 * The abstract class provides the general implementation of the CDF 
 * calculations based off a Fixed Salaried employee. It also provides
 * a getter method to return the current number of employees employed 
 * by the company.
 * An abstract method is also provided for the concrete classes to setup its
 * individual wage components before generating the payroll.
 */

public abstract class Employee {

    /** Variable for employee name*/
    protected String name;
    /** Variable for employee gross pay*/
    private BigDecimal grossPay;
    /** Variable for employee CDF contribution*/
    private BigDecimal employeeCDF;
    /** Variable for employer CDF contribution*/
    private BigDecimal employerCDF;
    /** Variable for employee net pay after CDF contribution*/
    private BigDecimal netPay;
    /** Variable for employee plus employer CDF contribution*/
    private BigDecimal totalCDFContribution;
    /** Variable for employee ordinary wage*/
    private BigDecimal ordinaryWage;
    /** Variable for employee additional wage*/
    private BigDecimal additionalWage;
    /** Variable for total number of employees*/
    private static int count = 0; // count the total number of employees

    /**
     * Class Constructor to initialise <code>name</code> and increment <code>count</code>
     *
     * @param name the name of employee
     */
    Employee(String name) {
        this.name = name;
        count++;
    }
    
    /**
     * Abstract method for the concrete classes to implement their own
     * calculation of the different wage components
     */
    protected abstract void setupWageComponents(); 
    
    /**
     * Returns the payroll components as a BigDecimal array depending on 
     * the type of employee, wage, and if applicable, number of hours 
     * worked.
     * Payroll components include:
     * 1. gross pay i.e. OW + AW (before CDF deduction)
     * 2. employee's CDF                               
     * 3. employer's CDF                               
     * 4. net pay (after CPF deduction)
     * 5. total CPF contributions
     *
     * @return	payroll components
     */
    protected BigDecimal[] generatePayroll() {

        setupWageComponents();
        BigDecimal[] payroll = new BigDecimal[5];

        try {
            if(this.grossPay.compareTo(new BigDecimal("50")) != 1){

                this.employeeCDF = new BigDecimal("0.00");
                this.totalCDFContribution = new BigDecimal("0.00");
                this.employerCDF = new BigDecimal("0.00");
                this.netPay = this.grossPay;

                payroll[0] = this.grossPay;
                payroll[1] = this.employeeCDF;
                payroll[2] = this.employerCDF;
                payroll[3] = this.netPay;
                payroll[4] = this.totalCDFContribution;

            }else if(getGrossPay().compareTo(new BigDecimal("500")) != 1){

                this.employeeCDF = new BigDecimal("0.00");
                this.totalCDFContribution = (this.grossPay.multiply(new BigDecimal("0.13"))
                        .setScale(0,RoundingMode.HALF_UP)).setScale(2,RoundingMode.DOWN);
                this.employerCDF = this.totalCDFContribution;
                this.netPay = this.grossPay;

                payroll[0] = this.grossPay;
                payroll[1] = this.employeeCDF;
                payroll[2] = this.employerCDF;
                payroll[3] = this.netPay;
                payroll[4] = this.totalCDFContribution;

            }else if(getGrossPay().compareTo(new BigDecimal("750")) != 1){

                this.employeeCDF = (this.grossPay.subtract(new BigDecimal("500"))
                        .multiply(new BigDecimal("0.6"))).setScale(0,RoundingMode.DOWN)
                        .setScale(2,RoundingMode.DOWN);
                this.totalCDFContribution = (this.grossPay.subtract(new BigDecimal("500"))
                        .multiply(new BigDecimal("0.6"))).add(this.grossPay.multiply(new BigDecimal("0.13")))
                        .setScale(0,RoundingMode.HALF_UP).setScale(2,RoundingMode.DOWN);
                this.employerCDF = this.totalCDFContribution.subtract(this.employeeCDF);
                this.netPay = this.grossPay.subtract(this.employeeCDF);

                payroll[0] = this.grossPay;
                payroll[1] = this.employeeCDF;
                payroll[2] = this.employerCDF;
                payroll[3] = this.netPay;
                payroll[4] = this.totalCDFContribution;

            }else{

                this.employeeCDF = ((this.ordinaryWage.min(new BigDecimal("6000"))
                        .multiply(new BigDecimal("0.17"))).add(this.additionalWage
                        .multiply(new BigDecimal("0.17")))).setScale(0,RoundingMode.DOWN)
                        .setScale(2,RoundingMode.DOWN);
                this.totalCDFContribution = ((this.ordinaryWage.min(new BigDecimal("6000"))
                        .multiply(new BigDecimal("0.33"))).add(this.additionalWage
                        .multiply(new BigDecimal("0.33")))).setScale(0,RoundingMode.HALF_UP)
                        .setScale(2,RoundingMode.DOWN);
                this.employerCDF = this.totalCDFContribution.subtract(this.employeeCDF);
                this.netPay = this.grossPay.subtract(this.employeeCDF);

                //rmb to get min of 6k or OW first
                payroll[0] = this.grossPay;
                payroll[1] = this.employeeCDF;
                payroll[2] = this.employerCDF;
                payroll[3] = this.netPay;
                payroll[4] = this.totalCDFContribution;

            }
        } catch (NullPointerException npe) {
            count--;
            payroll[0] = null;
            payroll[1] = null;
            payroll[2] = null;
            payroll[3] = null;
            payroll[4] = null;
        }
        return payroll;
    }
    
    /**
     * Returns the current number of employees employed by the company
     * 
     * @return int Number of employees 
     */
    protected static int getCount() {
        return count;
    }

    /**
     * Returns the current number of employees employed by the company
     *
     * @param grossPay  Number of employees
     */
    protected void setGrossPay(BigDecimal grossPay){ this.grossPay = grossPay; }

    /**
     * Returns the current number of employees employed by the company
     *
     * @param ordinaryWage  Number of employees
     */
    protected void setOrdinaryWage(BigDecimal ordinaryWage){ this.ordinaryWage = ordinaryWage; }
    /**
     * Returns the current number of employees employed by the company
     *
     * @param additionalWage of employees
     */
    protected void setAdditionalWage(BigDecimal additionalWage){ this.additionalWage = additionalWage; }

    /**
     * Returns the gross pay of the employee
     *
     * @return BigDecimal Gross pay
     */
    protected BigDecimal getGrossPay(){ return this.grossPay; }

    /**
     * Returns the ordinary wage of the employee
     *
     * @return BigDecimal Ordinary wage
     */
    protected BigDecimal getOrdinaryWage(){ return this.ordinaryWage; }
    /**
     * Returns the additional wage of the employee
     *
     * @return BigDecimal Additional wage
     */
    protected BigDecimal getAdditionalWage(){ return this.additionalWage; }
}