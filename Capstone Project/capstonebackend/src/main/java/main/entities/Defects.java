package main.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Defects entity for the defects table in the database.
 */
@Entity
@Table(name="defects")
public class Defects {
    /**
     * @GeneratedValue is used to auto-increment the defectId
     */
    @Id
    @Column(name = "defect_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int defectId;
    @Column(name = "description")
    private String description;
    @Column(name = "equipment_id")
    private int equipmentId;

    public Defects() { };
    public Defects(String description, int equipmentId) {
        super();
        this.description = description;
        this.equipmentId = equipmentId;
    }

    public int getDefectId() { return defectId; }
    public void setDefectId(int defectId) { this.defectId = defectId; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    /**
     * @JsonIgnore is used so that the equipmentId field is not duplicated when the information is queried
     * from the EquipmentRepo
     *
     * @return ID number of equipment, consists of digits that are auto-incremented
     */
    @JsonIgnore
    public int getEquipmentId() { return equipmentId; }
    public void setEquipmentId(int equipmentId) { this.equipmentId = equipmentId; }
}
