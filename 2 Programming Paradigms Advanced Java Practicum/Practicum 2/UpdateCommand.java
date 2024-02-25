import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A concrete class to implement the concrete methods for updating and un-updating
 * the specified data in the Receiver ArrayList.
 */
public class UpdateCommand extends Command{
    /** Variable to store the input to the UpdateCommand */
    private String dataInput;
    /** Variable to store the input as String array */
    private String[] dataInputArray;
    /** Variable to store the Receiver object */
    private Receiver cmdReceiver;
    /** Variable to store backup of the current ArrayList*/
    private ArrayList<String[]> currentArrayListClone = new ArrayList<String[]>();
    /**
     * Class Constructor to initialise cmdReceiver and dataInput
     *
     * @param cmdReceiver the Receiver object
     * @param dataInput the input to UpdateCommand
     */
    public UpdateCommand(Receiver cmdReceiver, String dataInput){
        this.cmdReceiver = cmdReceiver;
        this.dataInput = dataInput;
    }

    /**
     * Concrete execute method for checking validity of the input data and
     * calling the update method in the Receiver if the input data is valid.
     * Throw CustomException if input data is invalid.
     */
    @Override
    public void execute(){

        //rmb to put in the logic to check whether got thing to update, eg. empty array but want to update or try to update an index number that is not in the thing.

        //Cloning of Receive Array List
        for (String[] arrayListRow : this.cmdReceiver.getReceiverArray()) {
            String tempString0 = new String(arrayListRow[0]);
            String tempString1 = new String(arrayListRow[1]);
            String tempString2 = new String(arrayListRow[2]);
            String[] tempStringArray = new String[]{tempString0, tempString1, tempString2};

            this.currentArrayListClone.add(tempStringArray);
        }

        //Initialising of variables
        this.dataInputArray = this.dataInput.strip().split("\\s+");

        //Checking validity of input
        if (this.dataInput.isEmpty() || this.dataInput.isBlank()) {
            throw new CustomException("ILUVJAVA bot says: Incorrect number of data fields");
        }else if(this.dataInputArray.length < 2 || this.dataInputArray.length > 4) {
            throw new CustomException("ILUVJAVA bot says: Incorrect number of data fields");
        }else{
            switch(dataInputArray.length){
                case 2:
                case 3:
                    try{
                        Integer.parseInt(this.dataInputArray[0]);
                    }catch (NumberFormatException nfe){
                        throw new CustomException("ILUVJAVA bot says: Index number cannot be a float");
                    }
                    if(Integer.parseInt(this.dataInputArray[0]) <= 0){
                        throw new CustomException("ILUVJAVA bot says: Index number cannot be 0 or negative");
                    }else{
                        //Call update method in Receiver
                        this.cmdReceiver.update(this.dataInputArray);
                     }
                    break;
                case 4:
                    try{
                        Integer.parseInt(this.dataInputArray[0]);
                    }catch (NumberFormatException nfe){
                        throw new CustomException("ILUVJAVA bot says: Index number cannot be a float");
                    }
                    if(Integer.parseInt(this.dataInputArray[0]) <= 0){
                        throw new CustomException("ILUVJAVA bot says: Index number cannot be 0 or negative");
                    }else{
                        String regexString = "[\\w]+([\\.\\-][\\w]+)*@[A-Za-z0-9]+([\\.\\-][A-Za-z0-9]+)*\\.[a-z]{2,3}";
                        Pattern regexPattern = Pattern.compile(regexString);
                        Matcher emailMatcher = regexPattern.matcher(this.dataInputArray[3]);

                        if (emailMatcher.matches() == false) {
                            throw new CustomException("ILUVJAVA bot says: Wrong email format");
                        } else {
                            //Call update method in Receiver
                            this.cmdReceiver.update(this.dataInputArray);
                        }
                    }
                    break;
            }
        }
    }

    /**
     * Concrete unexecute method for calling the undo
     * method in the Receiver class.
     */
    @Override
    public void unexecute(){
        //Call undo method in Receiver
        this.cmdReceiver.undo(this.currentArrayListClone);
    }
}