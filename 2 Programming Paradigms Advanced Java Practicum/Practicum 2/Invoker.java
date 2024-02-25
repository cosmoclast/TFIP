import java.util.Stack;

/**
 * A concrete class to store commands to execute and also to
 * execute all the commands stored
 */
public class Invoker {
    /** Variable to store array of commands to execute */
    private Command[] cmdToExecute;

    /**
     * Sets the cmdToExecute to the Command Array
     *
     * @param cmdArray array of commands to execute
     */
    public void setCommandsForExecution(Command[] cmdArray) {
        this.cmdToExecute = cmdArray;
    }

    /**
     * Executes the commands in the Command array, push successfully
     * executed add, delete and update commands to Command history Stack
     * and catch any exceptions.
     *
     * @param history Commands history Stack
     */
    public void executeCommand(Stack<Command> history) {

        for (Command currentCommand : cmdToExecute) {
            try{
                currentCommand.execute();
                history.push(currentCommand);
            }catch(Exception exceptionmsg){
                System.out.println(exceptionmsg);
            }
        }
    }
}