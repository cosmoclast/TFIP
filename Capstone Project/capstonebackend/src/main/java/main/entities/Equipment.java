package main.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import main.serializations.CustomEquipmentDeserializer;

import java.util.List;

/**
 * Equipment entity for the equipment table in the database.
 *
 * @JsonDeserialize is used to deserialise the JSON String coming in so that a new equipment can be added to the
 * database
 */
@Entity
@Table(name="equipment")
@JsonDeserialize(using = CustomEquipmentDeserializer.class)
public class Equipment {
    /**
     * @GeneratedValue is used to auto-increment the equipmentId
     */
    @Id
    @Column(name = "equipment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipmentId;
    @Column(name = "category")
    private String category;
    @Column(name = "equipment_name")
    private String equipmentName;
    @Column(name = "e_length")
    private Double eLength;
    @Column(name = "e_width")
    private Double eWidth;
    @Column(name = "e_height")
    private Double eHeight;
    @Column(name = "aircraft")
    private String aircraft;
    @Column(name = "in_use")
    private Boolean inUse;
    @Column(name = "has_defects")
    private Boolean hasDefects;
    /**
     * Mapping to Locations table so the location data can be queried from the EquipmentRepo
     */
    @ManyToOne
    @JoinColumn(name = "location")
    private Locations location;
    /**
     * Mapping to Employees table so the employee data can be queried from the EquipmentRepo
     */
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employees employee;
    /**
     * Mapping to Favourites table so the favourite data can be queried from the EquipmentRepo
     */
    @OneToMany
    @JoinColumn(name="equipment_id",
        referencedColumnName="equipment_id")
    private List<Favourites> favouritesList;
    /**
     * Mapping to Defects table so the defects data can be queried from the EquipmentRepo
     */
    @OneToMany
    @JoinColumn(name="equipment_id",
            referencedColumnName="equipment_id")
    private List<Defects> defectsList;

    public Equipment() { };
    public Equipment(String category, String equipmentName, Double eLength, Double eWidth, Double eHeight,
                     String aircraft, Boolean inUse, Boolean hasDefects, Locations location, Employees employee){
        super();
        this.category = category;
        this.equipmentName = equipmentName;
        this.eLength = eLength;
        this.eWidth = eWidth;
        this.eHeight = eHeight;
        this.aircraft = aircraft;
        this.inUse = inUse;
        this.hasDefects = hasDefects;
        this.location = location;
        this.employee = employee;
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
    public Locations getLocation() { return location; }
    public void setLocation(Locations location) { this.location = location; }
    public Employees getEmployee() { return employee; }
    public void setEmployee(Employees employee) { this.employee = employee; }
    public List<Defects> getDefectsList() { return defectsList; }
    public void setDefectsList(List<Defects> defectsList) { this.defectsList = defectsList; }
    public List<Favourites> getFavouritesList() { return favouritesList; }
    public void setFavouritesList(List<Favourites> favouritesList) { this.favouritesList = favouritesList; }
}
