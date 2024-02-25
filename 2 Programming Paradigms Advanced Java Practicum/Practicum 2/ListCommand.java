/**
 * A concrete class to implement the concrete methods for listing the
 * current data in the Receiver ArrayList.
 */
public class ListCommand extends Command{
    /** Variable to store the Receiver object */
    private Receiver cmdReceiver;

    /**
     * Class Constructor to initialise cmdReceiver
     *
     * @param cmdReceiver the Receiver object
     */
    public ListCommand(Receiver cmdReceiver){
        this.cmdReceiver = cmdReceiver;
    }

    /**
     * Concrete execute method for calling the list method in the Receiver class.
     * Throw CustomException to prevent pushing into history stack
     */
    @Override
    public void execute(){
        //Call list method in Receiver
        this.cmdReceiver.list();

        //Throws error to indicate cannot push into the history stack
        throw new CustomException("ILUVJAVA bot says: This command cannot be pushed into the history stack");
    }

    /**
     * Concrete unexecute method not required because no un-listing functionality
     * needed.
     */
    @Override
    public void unexecute(){

    }
}
