package repositories;

import java.util.List;

/**
 * Interface to allow the implementation of different types of repositories
 *
 */
public interface Repository {

    /**
     * Method that will check if the list of filenames exist in the resources folder, for the filenames
     * that exist, it will be added to a list that is returned by the method.
     *
     * @param filenames list of filenames to load from the resources folder
     * @return list of filenames that are in the resources folder that match the list of filenames to load
     * from the resources folder
     */
    List<String> fileLoad(List<String> filenames);
}
