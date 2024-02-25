package main.helper;
import main.dto.EquipmentDTO;
import java.util.Comparator;

/**
 * Custom comparator to compare the equipmentId in the MapperHelper so that the equipment data is still sorted
 * by equipmentId in ascending order
 */
public class EquipmentIDComparator implements Comparator<EquipmentDTO> {
    @Override
    public int compare(EquipmentDTO eDTO1, EquipmentDTO eDTO2){
        if (eDTO1.getEquipmentId() == eDTO2.getEquipmentId())
            return 0;
        else if (eDTO1.getEquipmentId() > eDTO2.getEquipmentId())
            return 1;
        else
            return -1;
    }
}
