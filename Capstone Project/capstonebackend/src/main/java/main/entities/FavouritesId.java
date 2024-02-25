package main.entities;
import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 * Composite key for the Favourites entity, need to implement Serializable and override the
 * equals and hashcode methods
 */
@Embeddable
public class FavouritesId implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "equipment_id")
    private int equipmentId;

    public FavouritesId(){}
    public FavouritesId(String employeeId, int equipmentId){
        this.employeeId = employeeId;
        this.equipmentId = equipmentId;
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public int getEquipmentId() { return equipmentId; }
    public void setEquipmentId(int equipmentId) { this.equipmentId = equipmentId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavouritesId that = (FavouritesId) o;
        return equipmentId == that.equipmentId && employeeId.equals(that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, equipmentId);
    }
}
