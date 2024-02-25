import java.util.ArrayList;
import java.util.regex.*;

/**
 * A concrete class to implement the concrete methods for adding and un-adding
 * the specified data in the Receiver ArrayList.
 */
public class AddCommand extends Command {
    /** Variable to store the input to the AddCommand */
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
     * @param dataInput the input to AddCommand
     */
    public AddCommand(Receiver cmdReceiver, String dataInput) {
        this.cmdReceiver = cmdReceiver;
        this.dataInput = dataInput;
    }

    /**
     * Concrete execute method for checking validity of the input data and
     * calling the add method in the Receiver if the input data is valid.
     * Throw CustomException if input data is invalid.
     */
    @Override
    public void execute() {
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
        if (this.dataInputArray.length < 3 || this.dataInputArray.length > 3) {
            throw new CustomException("ILUVJAVA bot says: Incorrect number of data fields");
        } else {
            String regexString = "[\\w]+([\\.\\-][\\w]+)*@[A-Za-z0-9]+([\\.\\-][A-Za-z0-9]+)*\\.[a-z]{2,3}";
            Pattern regexPattern = Pattern.compile(regexString);
            Matcher emailMatcher = regexPattern.matcher(this.dataInputArray[2]);

            if (emailMatcher.matches() == false) {
                throw new CustomException("ILUVJAVA bot says: Wrong email format");
            } else {
                //Call add method in Receiver
                this.cmdReceiver.add(this.dataInputArray);
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