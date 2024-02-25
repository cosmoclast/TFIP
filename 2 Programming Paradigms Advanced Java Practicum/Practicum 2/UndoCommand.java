import java.util.Stack;

/**
 * A concrete class to implement the concrete methods for undoing the
 * commands stored in the Command history Stack.
 */
public class UndoCommand extends Command{
    /** Variable to store the Receiver object */
    private Receiver cmdReceiver;
    /** Variable to store the Command history Stack */
    private Stack<Command> history;
    /**
     * Class Constructor to initialise cmdReceiver and history
     *
     * @param cmdReceiver the Receiver object
     * @param history the Command history Stack
     */
    public UndoCommand(Receiver cmdReceiver, Stack<Command> history){
        this.cmdReceiver = cmdReceiver;
        this.history = history;
    }

    /**
     * Concrete execute method for calling the unexecute method in the respective Commands.
     * Throw CustomException to prevent pushing into history stack
     */
    @Override
    public void execute(){
        if(history.isEmpty() == false) {
            history.pop().unexecute();
            //Throws error to indicate cannot push into the history stack
            throw new CustomException("ILUVJAVA bot says: This command cannot be pushed into the history stack");
        }else{
            throw new CustomException("ILUVJAVA bot says: No commands to undo");
        }
    }

    /**
     * Concrete unexecute method not required because no re-doing functionality
     * needed.
     */
    @Override
    public void unexecute(){
    }
}
