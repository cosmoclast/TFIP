
/**
 * An abstract class used to create concrete command classes.
 * The abstract class provides the general implementation of the AddCommand,
 * DeleteCommand, UpdateCommand, ListCommand and UndoCommand.
 * Abstract methods for the execute and unexecute is also provided for
 * the concrete classes to setup its input checking.
 */
abstract public class Command {

    /**
     * Abstract execute method for checking validity of inputs before
     * calling the respective methods in the Receiver class.
     */
    abstract public void execute();

    /**
     * Abstract unexecute method for calling the undo
     * method in the Receiver class.
     */
    abstract public void unexecute();
}
