package repositories;

import org.springframework.stereotype.Component;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * ReadRepository implements the Repository interface, it is the connection between your resources folder
 * and your service.
 */
@Component
public class ReadRepository implements Repository {
    /**
     * Method that will check if the list of filenames exist in the resources folder, for the filenames
     * that exist, it will be added to a list that is returned by the method.
     *
     * @param filenames list of filenames to load from the resources folder
     * @return list of filenames that are in the resources folder that match the list of filenames to load
     * from the resources folder
     */
    @Override
    public List<String> fileLoad(List<String> filenames){
        List<String> checkedFilenames = new ArrayList<>();

        while(!filenames.isEmpty()){
            String filename = filenames.remove(0);
            Path filepath = Paths.get("./src/main/resources/" + filename);
            Path absolutePath = filepath.toAbsolutePath();

            try{
                filepath.toRealPath();
                checkedFilenames.add(filename);
            }catch(IOException ioe) {
                System.out.println(String.format("java.io.FileNotFoundException: class path resource [%s] cannot " +
                        "be opened because it does not exist", absolutePath.normalize()));
            }
        }
        return checkedFilenames;
    }
}
