package main.dto;

import main.entities.Defects;
import main.entities.Employees;
import main.entities.Locations;
import java.util.List;

/**
 * EquipmentDTO class to store all the fields from the Equipment table plus one extra field isFavourite to
 * indicate for a particular employee whether a particular equipment is the employee's favourited equipment
 */
public class EquipmentDTO {
    private int equipmentId;
    private String category;
    private String equipmentName;
    private Double eLength;
    private Double eWidth;
    private Double eHeight;
    private String aircraft;
    private Boolean inUse;
    private Boolean hasDefects;
    private Boolean isFavourite;
    private Locations location;
    private Employees employee;
    private List<Defects> defectsList;

    public EquipmentDTO() { };
    public EquipmentDTO(int equipmentId, String category, String equipmentName, Double eLength, Double eWidth,
                        Double eHeight, String aircraft, Boolean inUse, Boolean hasDefects, Boolean isFavourite,
                        Locations location, Employees employee, List<Defects> defectsList){
        super();
        this.equipmentId = equipmentId;
        this.category = category;
        this.equipmentName = equipmentName;
        this.eLength = eLength;
        this.eWidth = eWidth;
        this.eHeight = eHeight;
        this.aircraft = aircraft;
        this.inUse = inUse;
        this.hasDefects = hasDefects;
        this.isFavourite = isFavourite;
        this.location = location;
        this.employee = employee;
        this.defectsList = defectsList;
    }

    public int getEquipmentId() { return equipmentId; }
    public void setEquipmentId(int equipmentId) { this.equipmentId = equipmentId; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }
    public Double geteLength() { return eLength; }
    public void seteLength(Double eLength) { this.eLength = eLength; }
    public Double geteWidth() { return eWidth; }
    public void seteWidth(Double eWidth) { this.eWidth = eWidth; }
    public Double geteHeight() { return eHeight; }
    public void seteHeight(Double eHeight) { this.eHeight = eHeight; }
    public String getAircraft() { return aircraft; }
    public void setAircraft(String aircraft) { this.aircraft = aircraft; }
    public Boolean getInUse() { return inUse; }
    public void setInUse(Boolean inUse) { this.inUse = inUse; }
    public Boolean getHasDefects() { return hasDefects; }
    public void setHasDefects(Boolean hasDefects) { this.hasDefects = hasDefects; }
    public Boolean getIsFavourite() { return isFavourite; }
    public void setIsFavourite(Boolean favourite) { isFavourite = favourite; }
    public Locations getLocation() { return location; }
    public void setLocation(Locations location) { this.location = location; }
    public Employees getEmployee() { return employee; }
    public void setEmployee(Employees employee) { this.employee = employee; }
    public List<Defects> getDefectsList() { return defectsList; }
    public void setDefectsList(List<Defects> defectsList) { this.defectsList = defectsList; }
}
