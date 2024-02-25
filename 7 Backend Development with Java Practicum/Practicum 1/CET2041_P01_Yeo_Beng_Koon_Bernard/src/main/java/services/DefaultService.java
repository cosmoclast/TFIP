package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import repositories.Repository;

/**
 * DefaultService contains the logic for checking of each individual record in the csv files to ensure
 * that it is a valid record by checking for validity of the account number, validity of the balance and validity
 * of the last payment date. After determining that it is a valid record, each valid record is checked for
 * defaulted payments. The DefaultService is able to talk to the ReadRepository for reading of csv files from
 * the resources folder based on the list of filenames the user has given.
 */
@Component
public class DefaultService {
    /**
     * checkedFilenames is list of filename strings to check for.
     */
    private List<String> checkedFilenames;
    /**
     * validAccounts is a list of valid Account objects
     */
    private List<Account> validAccounts = new ArrayList<>();
    /**
     * acctRepo is a ReadRepository object
     */
    private final Repository acctRepo;

    /**
     * Constructor to initialise the ReadRepository through Autowiring
     *
     * @param acctRepo contains the ReadRepository
     */
    @Autowired
    public DefaultService(Repository acctRepo){
        this.acctRepo = acctRepo;
    }

    /**
     * Method to read the csv file and check each individual line to make sure it is a valid record
     * and create Account objects to store each valid account in a list of Account objects.
     *
     * @param filename filename of the csv file to read
     */
    private void fileRead(String filename){
        Path filepath = Paths.get("./src/main/resources/" + filename);
        Path absolutePath = filepath.toAbsolutePath();

        try(BufferedReader reader = Files.newBufferedReader(absolutePath, StandardCharsets.UTF_8)){
            String line;
            while((line = reader.readLine()) != null){
                if(validateRecords(line)) {
                    this.validAccounts.add(new Account(line.split(",")[0],
                            line.split(",")[1], line.split(",")[2]));
                }
            }
        }catch(IOException ioe){ }
    }

    /**
     * Method to check for the validity of the account number field.
     *
     * @param checkString the account number string from the csv file
     * @return boolean to indicate whether it is a valid account number
     */
    private boolean isAcctNum(String checkString){
        String[] checkStringSplit = checkString.split("-");

        if(checkStringSplit.length != 2){
            return false;
        }else if(!isInt(checkStringSplit[0]) || !isInt(checkStringSplit[1])){
            return false;
        }else if(checkStringSplit[0].length() < 3 || checkStringSplit[1].length() < 3 ){
            return false;
        }

        int acctNumFront = Integer.parseInt(checkStringSplit[0]);
        int acctNumBack = Integer.parseInt(checkStringSplit[1]);

        if(acctNumFront >= 0 && acctNumFront <= 999 && acctNumBack >= 1 && acctNumBack <= 999){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method to check for the validity of the account balance field.
     *
     * @param checkString the account balance string from the csv file
     * @return boolean to indicate whether it is a valid account balance
     */
    private boolean isDouble(String checkString){
        try{
            Double.parseDouble(checkString);
        }catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

    /**
     * Method to help isDate to check for integers in the last payment date field.
     *
     * @param checkString the year, month or day string from the last payment date field
     * @return boolean to indicate whether it is an integer
     */
    private boolean isInt(String checkString){
        try{
            Integer.parseInt(checkString);
        }catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

    /**
     * Method to check for the validity of the last payment date field.
     *
     * @param checkString the last payment date string from the csv file
     * @return boolean to indicate whether it is a valid last payment date
     */
    private boolean isDate(String checkString){
        String[] yearMonthDay = checkString.split("-");
        LocalDate checkDate;
        
        if(yearMonthDay.length != 3) {
            return false;
        }else if(!isInt(yearMonthDay[0]) || !isInt(yearMonthDay[1]) || !isInt(yearMonthDay[2])) {
            return false;
        }else{
            int year = Integer.parseInt(yearMonthDay[0]);
            int month = Integer.parseInt(yearMonthDay[1]);
            int date = Integer.parseInt(yearMonthDay[2]);

            try{
                checkDate = LocalDate.of(year, month, date);
            }catch(DateTimeException dte){
                return false;
            }
        }

        if(checkDate.isBefore(LocalDate.now()) || checkDate.isEqual(LocalDate.now())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Method to check if an Account object has defaulted payments
     *
     * @param checkAccount Account object to check
     * @return boolean to indicate whether the Account has defaulted payments
     */
    private boolean isDefault(Account checkAccount) {
        LocalDate todayDate = LocalDate.now();
        String currAcctDate = checkAccount.getAcctLastPaidDate();

        int year = Integer.parseInt(currAcctDate.split("-")[0]);
        int month = Integer.parseInt(currAcctDate.split("-")[1]);
        int day = Integer.parseInt(currAcctDate.split("-")[2]);
        LocalDate csvDate = LocalDate.of(year, month, day);

        if (ChronoUnit.DAYS.between(csvDate, todayDate) >= 30 && Double.parseDouble(checkAccount.getAcctBal()) < 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to consolidate the checks for the account number field, account balance field,
     * last payment date field and print the corresponding error messages.
     *
     * @param record an individual record string from the csv file
     * @return boolean to indicate whether it is a valid record
     */
    private boolean validateRecords(String record){
        String[] recordFields = record.split(",");

        if(recordFields.length != 3){
            System.out.println("Error: Invalid record");
            return false;
        }else if(!isAcctNum(recordFields[0])){
            System.out.println("Error: Invalid account number");
            return false;
        }else if(!isDouble(recordFields[1])){
            System.out.println("Error: Invalid balance");
            return false;
        }else if(!isDate(recordFields[2])){
            System.out.println("Error: Invalid date");
            return false;
        }else{
            return true;
        }
    }

    /**
     * Method that the user has access through the App to input a list of filenames to check for
     * accounts that have defaulted payments. For accounts that have defaulted payments, it will be
     * printed to terminal.
     *
     * @param filenames list of filenames that is input by the user
     */
    public void checkDefault(List<String> filenames){
        this.checkedFilenames = this.acctRepo.fileLoad(filenames);

        while(!this.checkedFilenames.isEmpty()){
            System.out.println(String.format("Defaulted for %s------------------------", this.checkedFilenames.get(0)));
            fileRead(this.checkedFilenames.remove(0));
            while(!this.validAccounts.isEmpty()){
                Account checkAccount = this.validAccounts.remove(0);
                if(isDefault(checkAccount)){
                    System.out.println(checkAccount);
                }
            }
            System.out.println();
        }
    }
}