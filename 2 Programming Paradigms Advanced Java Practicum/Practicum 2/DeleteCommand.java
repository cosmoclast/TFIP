import java.util.ArrayList;

/**
 * A concrete class to implement the concrete methods for deleting and un-deleting
 * the specified data in the Receiver ArrayList.
 */
public class DeleteCommand extends Command{
    /** Variable to store the input to the DeleteCommand */
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
     * @param dataInput the input to DeleteCommand
     */
    public DeleteCommand(Receiver cmdReceiver, String dataInput){
        this.cmdReceiver = cmdReceiver;
        this.dataInput = dataInput;
    }

    /**
     * Concrete execute method for checking validity of the input data and
     * calling the delete method in the Receiver if the input data is valid.
     * Throw CustomException if input data is invalid.
     */
    @Override
    public void execute(){

        //need to add a logic to check if there are things to remove or not and handle the exception.

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
        }else if(this.dataInputArray.length > 1) {
            throw new CustomException("ILUVJAVA bot says: Incorrect number of data fields");
        }else{
            try{
                Integer.parseInt(this.dataInputArray[0]);
            }catch (NumberFormatException nfe){
                throw new CustomException("ILUVJAVA bot says: Index number cannot be a float");
            }
            if(Integer.parseInt(this.dataInputArray[0]) <= 0){
                throw new CustomException("ILUVJAVA bot says: Index number cannot be 0 or negative");
            }else{
                //Call delete method in Receiver
                this.cmdReceiver.delete(Integer.parseInt(this.dataInputArray[0]));
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
