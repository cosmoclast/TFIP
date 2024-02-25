import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A concrete class to implement the concrete methods for add, delete, update,
 * list and undo. Method for getting ArrayList and storing to .txt file is
 * also implemented.
 */
public class Receiver {
    /** Variable to temporarily store the data to be written to the .txt file */
    private ArrayList<String[]> receiverArray = new ArrayList<String[]>();

    /**
     * Concrete add method to do formatting of the data and adding to ArrayList
     *
     * @param dataInputArray validated String array from AddCommand
     */
    public void add(String[] dataInputArray) {
        //Conversion of first name and last name to title case and stripping email of whitespaces
        for (int count = 0; count < dataInputArray.length; count++) {
            if (count <= 1) {
                String name = dataInputArray[count];

                char nameFirstLetter = name.charAt(0);
                char nameFirstLetterUpper = Character.toUpperCase(nameFirstLetter);
                String nameFirstLetterUpperString = Character.toString(nameFirstLetterUpper);
                String nameTitle = name.toLowerCase().strip()
                        .replaceFirst("[a-zA-Z]", nameFirstLetterUpperString);

                dataInputArray[count] = nameTitle;
            } else {
                dataInputArray[count] = dataInputArray[count].strip();
            }
        }

        //Add to Receiver ArrayList
        this.receiverArray.add(dataInputArray);

        //Printing to console
        System.out.println("add");
    }

    /**
     * Concrete delete method to do formatting of the data and removing it from ArrayList
     *
     * @param dataInput validated String array from DeleteCommand
     */
    public void delete(Integer dataInput) {
        //Remove from Receiver ArrayList
        if (this.receiverArray.size() >= dataInput) {
            this.receiverArray.remove(dataInput - 1);

            //Printing to console
            System.out.println(String.format("Delete  #%2d", dataInput));
        } else {
            throw new CustomException("ILUVJAVA bot says: No deleting from an empty ArrayList");
        }
    }

    /**
     * Concrete update method to do formatting of the data and updating ArrayList
     *
     * @param dataInputArray validated String array from UpdateCommand
     */
    public void update(String[] dataInputArray) {
        //Initialising of variables
        Integer indexNumber = Integer.parseInt(dataInputArray[0]);

        if (this.receiverArray.size() >= indexNumber) {
            String[] arrayListRow = this.receiverArray.get(indexNumber - 1);

            //Conversion of first name and last name to title case and stripping email of whitespaces
            for (int count = 1; count < dataInputArray.length; count++) {
                if (count <= 2) {
                    String name = dataInputArray[count];

                    char nameFirstLetter = name.charAt(0);
                    char nameFirstLetterUpper = Character.toUpperCase(nameFirstLetter);
                    String nameFirstLetterUpperString = Character.toString(nameFirstLetterUpper);
                    String nameTitle = name.toLowerCase().strip()
                            .replaceFirst("[a-zA-Z]", nameFirstLetterUpperString);

                    arrayListRow[count - 1] = nameTitle;
                } else {
                    arrayListRow[count - 1] = dataInputArray[count].strip();
                }
            }

            //Set to Receiver ArrayList
            this.receiverArray.set(indexNumber - 1, arrayListRow);

            //Printing to console
            System.out.print(String.format("update  #%2d", indexNumber));
            for (int count = 1; count < dataInputArray.length; count++) {
                System.out.print(String.format(" %s", dataInputArray[count]));
            }
            System.out.println();

        } else {
            throw new CustomException("ILUVJAVA bot says: Index specified larger than ArrayList size");
        }
    }

    /**
     * Concrete list method to do formatting of the data and list on console
     */
    public void list() {
        //Initialising of variables
        int count = 1;

        //Printing to console
        System.out.println("List");
        for (String[] eachArrayListRow : this.receiverArray) {
            System.out.print(String.format("%02d. ", count));
            System.out.println(eachArrayListRow[0] + " " + eachArrayListRow[1] + " " + eachArrayListRow[2]);
            count++;
        }
    }

    /**
     * Concrete undo method to do formatting of the data and clear the array list and
     * update it with the backup array list
     *
     * @param currentArrayListClone backup of ArrayList before command executed
     */
    public void undo(ArrayList<String[]> currentArrayListClone) {
        this.receiverArray.clear();
        for (String[] arrayListRow : currentArrayListClone) {
            this.receiverArray.add(arrayListRow);
        }

        //Printing to console
        System.out.println("Undo");
    }

    /**
     * Concrete storeToFile method to read and write data from ArrayList to dataStore.txt
     */
    public void storeToFile() {
        try {
            //Set file path
            Path filepath = Paths.get("./src/dataStore.txt");

            //Read all lines in file
            try {
                Files.createFile(filepath);
            } catch (FileAlreadyExistsException faee) {
                System.out.println(faee);
            }
            List<String> lines = Files.readAllLines(filepath);

            //Add new data to List
            for (String[] eachArrayListRow : this.receiverArray) {
                lines.add(eachArrayListRow[0] + " " + eachArrayListRow[1] + " " + eachArrayListRow[2] );
            }

            //Clearing file of old data
            Files.writeString(filepath, "",StandardOpenOption.TRUNCATE_EXISTING);

            //Writing new data
            for (String line : lines) {
                Files.writeString(filepath, line + "\n", StandardOpenOption.APPEND);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /**
     * Returns the ArrayList in the Receiver class
     *
     * @return receiverArray ArrayList that stores temporary data
     */
    public ArrayList<String[]> getReceiverArray(){
        return this.receiverArray;
    }
}