package main.repository;

import main.entities.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * EquipmentRepo extends the JpaRepository and has access to the default CRUD methods and also
 * custom queries defined by the various methods
 */
@Repository
public interface EquipmentRepo extends JpaRepository<Equipment, Integer>{
    /**
     * Updates status of hasDefects to true for a particular equipment ID
     *
     * @param equipmentId ID number of equipment
     */
    @Modifying
    @Query("UPDATE Equipment e SET e.hasDefects = true WHERE e.equipmentId = :equipmentId")
    void updateEquipmentDefectStatus(@Param("equipmentId") int equipmentId);

    /**
     * Updates status of inUse for a particular equipment ID
     *
     * @param equipmentId ID number of equipment
     * @param inUse true or false depending on whether equipment is in use or not
     */
    @Modifying
    @Query("UPDATE Equipment e SET e.inUse = :inUse WHERE e.equipmentId = :equipmentId")
    void updateEquipmentInUseStatus(@Param("equipmentId") int equipmentId, @Param("inUse") Boolean inUse);

    /**
     * Updates location of a particular equipment ID
     *
     * @param equipmentId ID number of equipment
     * @param bay departure bay location
     */
    @Modifying
    @Query("UPDATE Equipment e SET e.location.bay = :bay WHERE e.equipmentId = :equipmentId")
    void updateEquipmentBay(@Param("equipmentId") int equipmentId, @Param("bay") String bay);

    /**
     * Updates employeeId for a particular equipment ID
     *
     * @param equipmentId ID number of equipment
     * @param employeeId ID number of employee
     */
    @Modifying
    @Query("UPDATE Equipment e SET e.employee.employeeId = :employeeId WHERE e.equipmentId = :equipmentId")
    void updateEquipmentEmployeeId(@Param("equipmentId") int equipmentId, @Param("employeeId") String employeeId);

    /**
     * Finds the favourited equipment for a particular employee out of all the equipment in the database
     *
     * @param employeeId ID number of employee
     * @return list of equipment that is favourited
     */
    @Query("SELECT e FROM Equipment e WHERE e.equipmentId IN " +
            "(SELECT f.favouritesId.equipmentId FROM Favourites f WHERE f.favouritesId.employeeId = :employeeId)")
    List<Equipment> findAllFavEquipmentByEmployeeId(@Param("employeeId") String employeeId);

    /**
     * Finds the non-favourited equipment for a particular employee out of all the equipment in the database
     *
     * @param employeeId ID number of employee
     * @return list of equipment that is not favourited
     */
    @Query("SELECT e FROM Equipment e WHERE e.equipmentId NOT IN " +
            "(SELECT f.favouritesId.equipmentId FROM Favourites f WHERE f.favouritesId.employeeId = :employeeId)")
    List<Equipment> findAllNotFavEquipmentByEmployeeId(@Param("employeeId") String employeeId);

    /**
     * Finds the favourited equipment for a particular employee out of all the equipment the employee is using
     *
     * @param employeeId ID number of employee
     * @return list of equipment that is favourited
     */
    @Query("SELECT e FROM Equipment e WHERE e.employee.employeeId = :employeeId AND e.equipmentId IN " +
            "(SELECT f.favouritesId.equipmentId FROM Favourites f WHERE f.favouritesId.employeeId = :employeeId)")
    List<Equipment> findAllFavUsingEquipmentByEmployeeId(@Param("employeeId") String employeeId);

    /**
     * Finds the non-favourited equipment for a particular employee out of all the equipment the employee is using
     *
     * @param employeeId ID number of employee
     * @return list of equipment that is not favourited
     */
    @Query("SELECT e FROM Equipment e WHERE e.employee.employeeId = :employeeId AND e.equipmentId NOT IN " +
            "(SELECT f.favouritesId.equipmentId FROM Favourites f WHERE f.favouritesId.employeeId = :employeeId)")
    List<Equipment> findAllNotFavUsingEquipmentByEmployeeId(@Param("employeeId") String employeeId);

    /**
     * Finds the favourited equipment for a particular employee out of all the equipment at a particular bay
     *
     * @param employeeId ID number of employee
     * @param bay departure bay location
     * @return list of equipment that is favourited
     */
    @Query("SELECT e FROM Equipment e WHERE e.location.bay = :bay AND e.equipmentId IN " +
            "(SELECT f.favouritesId.equipmentId FROM Favourites f WHERE f.favouritesId.employeeId = :employeeId)")
    List<Equipment> findAllFavLocationEquipmentByBay(@Param("employeeId") String employeeId,
                                                     @Param("bay") String bay);

    /**
     * Finds the non-favourited equipment for a particular employee out of all the equipment at a particular bay
     *
     * @param employeeId ID number of employee
     * @param bay departure bay location
     * @return list of equipment that is not favourited
     */
    @Query("SELECT e FROM Equipment e WHERE e.location.bay = :bay AND e.equipmentId NOT IN " +
            "(SELECT f.favouritesId.equipmentId FROM Favourites f WHERE f.favouritesId.employeeId = :employeeId)")
    List<Equipment> findAllNotFavLocationEquipmentByBay(@Param("employeeId") String employeeId,
                                                        @Param("bay") String bay);
}
