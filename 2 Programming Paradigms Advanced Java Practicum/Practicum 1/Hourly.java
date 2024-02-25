import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * A child class of the employee class that implements the setup of wage components based on the hours and hourly
 * rate of an hourly rate salary employee by overriding the abstract method <code>setupWageComponents</code>
 * from the employee class.
 */

public class Hourly extends Employee{
    /** Variable for employee hours*/
    private BigDecimal hours;
    /** Variable for employee hourly rate*/
    private BigDecimal hourlyRate;
    /**
     * Class Constructor to initialise <code>name</code>, <code>hours</code>, <code>hourlyRate</code>
     *
     * @param name name of employee
     * @param hours employee hours
     * @param hourlyRate employee hourly rate
     */
    public Hourly(String name, BigDecimal hours, BigDecimal hourlyRate){
        super(name);
        this.hours = hours;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Overriding of the abstract method in the employee class to implement a concrete method to calculate the
     * ordinary wage and additional wage and gross pay of an hourly rate salary employee. It checks for maximum of 744
     * hours based on a 31-day month.
     */
    @Override
    protected void setupWageComponents(){

        if(this.hours.compareTo(BigDecimal.ZERO) == -1 ||
                this.hourlyRate.compareTo(BigDecimal.ZERO) == -1 ||
                this.hours.compareTo(new BigDecimal("744")) == 1){


        }else if(this.hours.compareTo(new BigDecimal("176")) == 1){
            BigDecimal hoursRounded = this.hours.setScale(2,RoundingMode.DOWN);
            BigDecimal hourlyRateRounded = this.hourlyRate.setScale(2,RoundingMode.DOWN);

            setOrdinaryWage(hourlyRateRounded.multiply(new BigDecimal("176"))
                    .setScale(2,RoundingMode.DOWN));
            setAdditionalWage(hoursRounded.subtract(new BigDecimal("176")).multiply(new BigDecimal("1.5"))
                    .multiply(hourlyRateRounded).setScale(2,RoundingMode.DOWN));
            setGrossPay(getOrdinaryWage().add(getAdditionalWage()));

        }else {
            BigDecimal hoursRounded = this.hours.setScale(2,RoundingMode.DOWN);
            BigDecimal hourlyRateRounded = this.hourlyRate.setScale(2,RoundingMode.DOWN);

            setOrdinaryWage(hourlyRateRounded.multiply(hoursRounded).setScale(2,RoundingMode.DOWN));
            setAdditionalWage(BigDecimal.ZERO);
            setGrossPay(getOrdinaryWage());

        }
    }
}
