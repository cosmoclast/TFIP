package main.controller;

import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.entities.*;
import main.repository.*;
import main.exceptions.ResourceNotFoundException;
import main.helper.MapperHelper;

import java.util.List;

/**
 * Controller containing the methods called by the various endpoints
 */
@CrossOrigin(origins="*")
@RestController
public class Controller {
    private final DefectsRepo defectsRepo;
    private final EmployeesRepo employeesRepo;
    private final EquipmentRepo equipmentRepo;
    private final FavouritesRepo favouritesRepo;
    private final LocationsRepo locationsRepo;

    public Controller(DefectsRepo defectsRepo, EmployeesRepo employeesRepo,
                      EquipmentRepo equipmentRepo, FavouritesRepo favouritesRepo, LocationsRepo locationsRepo) {
        this.defectsRepo = defectsRepo;
        this.employeesRepo = employeesRepo;
        this.equipmentRepo = equipmentRepo;
        this.favouritesRepo = favouritesRepo;
        this.locationsRepo = locationsRepo;
    }

    /**
     * Endpoint for pinging
     *
     * @return String to indicate service is online
     */
    @GetMapping("/ping")
    public ResponseEntity ping(){
        return ResponseEntity.ok().body("Service is online");
    }

    /**
     * Endpoint for getting information of a particular employee using the employee ID
     * Used by front end for logging in of an employee
     *
     * @param employeeId ID number of employee, consists of 8 digits as a String eg, "11111111"
     * @return Employee ID, first name, last name, title
     */
    @GetMapping("/employees")
    public ResponseEntity getEmployeesById(@RequestParam(name = "employeeId") String employeeId){
        Employees employee = this.employeesRepo.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee does not exist " + employeeId));

        return ResponseEntity.ok().body(employee);
    }

    /**
     * Endpoint for getting list of all equipment. mapperHelper is used to add the isFavourite field
     * into the jsonString. isFavourite is a boolean to indicate if a particular equipment is favourited
     * by a particular employee . It is possible for the list to be empty because it is a possibility
     * that there are no equipment at all
     *
     * @param employeeId ID number of employee, consists of 8 digits as a String eg, "11111111"
     * @return {
     *             "equipmentId" : 2,
     *             "category" : "Tow Tug",
     *             "equipmentName" : "TLD 400HP XL Tow Tug",
     *             "eLength" : 2.0,
     *             "eWidth" : 1.5,
     *             "eHeight" : 1.5,
     *             "aircraft" : "B737",
     *             "inUse" : true,
     *             "hasDefects" : true,
     *             "isFavourite" : false,
     *             "location" : {
     *               "bay" : "A1",
     *               "lat" : 1.35597,
     *               "lng" : 103.98506
     *             },
     *             "employee" : {
     *               "employeeId" : "11111112",
     *               "firstName" : "Lorena",
     *               "lastName" : "Cohen",
     *               "title" : "Technician"
     *             },
     *             "defectsList" : [ {
     *               "defectId" : 11,
     *               "description" : "Gear knob missing"
     *               }, {
     *               "defectId" : 12,
     *               "description" : "Brakes spongy"
     *               }, {
     *               "defectId" : 13,
     *               "description" : "Handbrake stiff"
     *               }, {
     *               "defectId" : 14,
     *               "description" : "Horn too loud"
     *               }, {
     *               "defectId" : 15,
     *               "description" : "Signal light too dim"
     *               }
     *             ]
     *          }
     */
    @GetMapping("/allEquipment")
    public ResponseEntity getAllEquipment(@RequestParam(name = "employeeId") String employeeId){
        List<Equipment> equipmentFav = this.equipmentRepo.findAllFavEquipmentByEmployeeId(employeeId);
        List<Equipment> equipmentNotFav = this.equipmentRepo.findAllNotFavEquipmentByEmployeeId(employeeId);

        MapperHelper mapperHelper = new MapperHelper();
        String jsonString = mapperHelper.combineFavAndNonFav(equipmentFav, equipmentNotFav);
        if (jsonString.isBlank())
            throw new ResourceNotFoundException("No equipment found");

        return ResponseEntity.ok().body(jsonString);
    }

    /**
     * Endpoint for getting list of all equipment at a particular location. mapperHelper is used to
     * add the isFavourite field into the jsonString. isFavourite is a boolean to indicate if a particular
     * equipment is favourited by a particular employee . It is possible for the list to be empty because
     * it is a possibility that there are no equipment at all
     *
     * @param employeeId ID number of employee, consists of 8 digits as a String eg, "11111111"
     * @param bay departure bay location that is being queried eg. "D34"
     * @return jsonString and the format is the same as the endpoint /allEquipment
     */
    @GetMapping("/locationEquipment")
    public ResponseEntity getLocationEquipmentByBay(@RequestParam(name = "employeeId") String employeeId,
                                                    @RequestParam(name = "bay") String bay){
        List<Equipment> equipmentFav = this.equipmentRepo.findAllFavLocationEquipmentByBay(employeeId, bay);
        List<Equipment> equipmentNotFav = this.equipmentRepo.findAllNotFavLocationEquipmentByBay(employeeId, bay);

        MapperHelper mapperHelper = new MapperHelper();
        String jsonString = mapperHelper.combineFavAndNonFav(equipmentFav, equipmentNotFav);
        if (jsonString.isBlank())
            throw new ResourceNotFoundException("No equipment found");

        return ResponseEntity.ok().body(jsonString);
    }

    /**
     * Endpoint for getting list of all equipment that is being used by a particular employee.
     * mapperHelper is used to add the isFavourite field into the jsonString. isFavourite is a boolean
     * to indicate if a particular equipment is favourited by a particular employee . It is possible for
     * the list to be empty because it is a possibility that there are no equipment at all
     *
     * @param employeeId ID number of employee, consists of 8 digits as a String eg, "11111111"
     * @return jsonString and the format is the same as the endpoint /allEquipment
     */
    @GetMapping("/usingEquipment")
    public ResponseEntity getUsingEquipment(@RequestParam(name = "employeeId") String employeeId){
        List<Equipment> equipmentFav = this.equipmentRepo.findAllFavUsingEquipmentByEmployeeId(employeeId);
        List<Equipment> equipmentNotFav = this.equipmentRepo.findAllNotFavUsingEquipmentByEmployeeId(employeeId);

        MapperHelper mapperHelper = new MapperHelper();
        String jsonString = mapperHelper.combineFavAndNonFav(equipmentFav, equipmentNotFav);
        if (jsonString.isBlank())
            throw new ResourceNotFoundException("No equipment found");

        return ResponseEntity.ok().body(jsonString);
    }

    /**
     * Endpoint for changing the equipment status inUse to true and record which employee is using
     * the equipment. The frontend restricts the inputs to only valid inputs hence no exception is
     * thrown in the backend.
     *
     * @param equipmentId ID number of equipment, consists of digits that are auto-incremented
     * @param bay departure bay location eg, "D34"
     * @param employeeId ID number of employee, consists of 8 digits as a String eg, "11111111"
     * @return Status 200 to indicate OK
     */
    //Endpoint for changing the equipment to in use.
    //    exceptions are caught in the front end
    @Transactional
    @PutMapping("/inUseEquipment")
    public ResponseEntity putEquipmentInUse(@RequestParam(name = "equipmentId") int equipmentId,
                                            @RequestParam(name = "bay") String bay,
                                            @RequestParam(name = "employeeId") String employeeId){
        this.equipmentRepo.updateEquipmentInUseStatus(equipmentId, true);
        this.equipmentRepo.updateEquipmentBay(equipmentId, bay);
        this.equipmentRepo.updateEquipmentEmployeeId(equipmentId, employeeId);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for changing the equipment status inUse to false and change the employee to null to
     * indicate no employee is using the equipment. The frontend restricts the inputs to only valid
     * inputs hence no exception is thrown in the backend.
     *
     * @param equipmentId ID number of equipment, consists of digits that are auto-incremented
     * @return Status 200 to indicate OK
     */
    @Transactional
    @PutMapping("/notInUseEquipment")
    public ResponseEntity putEquipmentNotInUse(@RequestParam(name = "equipmentId") int equipmentId){
        this.equipmentRepo.updateEquipmentInUseStatus(equipmentId, false);
        this.equipmentRepo.updateEquipmentEmployeeId(equipmentId, null);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for adding a new equipment to the Equipment table. The frontend restricts the inputs to only valid
     * inputs hence no exception is thrown in the backend.
     *
     * @param equipment   {
     *             "category": "Tow Tug",
     *             "equipmentName": "TLD 500HP XXL Tow Tug",
     *             "eLength": 3.0,
     *             "eWidth": 1.5,
     *             "eHeight": 1.5,
     *             "aircraft": "B747",
     *             "location": "G21"
     *             }
     * @return Status 200 to indicate OK
     */
    @PostMapping("/newEquipment")
    public ResponseEntity postNewEquipment(@RequestBody Equipment equipment){
        this.equipmentRepo.save(equipment);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for adding a new defect to the Defects table. Also updates the equipment status hasDefects
     * to true. The frontend restricts the inputs to only valid inputs hence no exception is thrown in the backend.
     *
     * @param equipmentId ID number of equipment, consists of digits that are auto-incremented
     * @param description
     * @return Status 200 to indicate OK
     */
    @Transactional
    @PostMapping("/newDefect")
    public ResponseEntity postNewDefect(@RequestParam(name = "equipmentId") int equipmentId,
                                        @RequestParam(name = "description") String description){
        this.defectsRepo.save(new Defects(description, equipmentId));
        this.equipmentRepo.updateEquipmentDefectStatus(equipmentId);
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for adding an entry in the Favourites table if employee has decided to favourite
     * an equipment. The frontend restricts the inputs to only valid inputs hence no exception
     * is thrown in the backend.
     *
     * @param employeeId ID number of employee, consists of 8 digits as a String eg, "11111111"
     * @param equipmentId ID number of equipment, consists of digits that are auto-incremented
     * @return Status 200 to indicate OK
     */
    @PostMapping("/addFavourites")
    public ResponseEntity postFavouriteByEmployeeId(@RequestParam(name = "employeeId") String employeeId,
                                                    @RequestParam(name = "equipmentId") int equipmentId){
        this.favouritesRepo.save(new Favourites(new FavouritesId(employeeId, equipmentId)));
        return ResponseEntity.ok().build();
    }

    /**
     * Endpoint for deleting an entry from the Favourites table if employee has decided to unfavourite
     * an equipment. The frontend restricts the inputs to only valid inputs hence no exception
     * is thrown in the backend.
     *
     * @param employeeId ID number of employee, consists of 8 digits as a String eg, "11111111"
     * @param equipmentId ID number of equipment, consists of digits that are auto-incremented
     * @return Status 200 to indicate OK
     */
    @DeleteMapping("/deleteFavourites")
    public ResponseEntity deleteFavouriteByEmployeeId(@RequestParam(name = "employeeId") String employeeId,
                                                      @RequestParam(name = "equipmentId") int equipmentId){
        this.favouritesRepo.deleteById(new FavouritesId(employeeId, equipmentId));
        return ResponseEntity.ok().build();
    }
}
