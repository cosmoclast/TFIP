package main.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.dto.EquipmentDTO;
import main.entities.Equipment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * MapperHelper is needed to map the data from the Equipment table as an extra field isFavourite is needed
 * in the output. A list of equipment that has been favourited by a particular employee is obtained. Another
 * list of equipment that has not been favourited by a particular employee is also obtained. The MapperHelper
 * adds the isFavourite to both lists of equipment. For the former list, the isFavourite is set to true, for the
 * latter list, the isFavourite is set to false. The two lists are then combined and sorted according to equipmentId
 * in ascending order
 */
public class MapperHelper {
    public MapperHelper(){ }
    public String combineFavAndNonFav(List<Equipment> equipmentListFav, List<Equipment> equipmentListNotFav){
        List<EquipmentDTO> equipmentDTOList = new ArrayList<>();
        String jsonString = new String();
        ObjectMapper obj = new ObjectMapper();

        for(Equipment eachEquipment : equipmentListFav){
            EquipmentDTO tempEquipmentDTO = new EquipmentDTO();
            tempEquipmentDTO.setEquipmentId(eachEquipment.getEquipmentId());
            tempEquipmentDTO.setCategory(eachEquipment.getCategory());
            tempEquipmentDTO.setEquipmentName(eachEquipment.getEquipmentName());
            tempEquipmentDTO.seteLength(eachEquipment.geteLength());
            tempEquipmentDTO.seteWidth(eachEquipment.geteWidth());
            tempEquipmentDTO.seteHeight(eachEquipment.geteHeight());
            tempEquipmentDTO.setAircraft(eachEquipment.getAircraft());
            tempEquipmentDTO.setInUse(eachEquipment.getInUse());
            tempEquipmentDTO.setHasDefects(eachEquipment.getHasDefects());
            tempEquipmentDTO.setIsFavourite(true);
            tempEquipmentDTO.setLocation(eachEquipment.getLocation());
            tempEquipmentDTO.setEmployee(eachEquipment.getEmployee());
            tempEquipmentDTO.setDefectsList(eachEquipment.getDefectsList());
            equipmentDTOList.add(tempEquipmentDTO);
        }

        for(Equipment eachEquipment : equipmentListNotFav){
            EquipmentDTO tempEquipmentDTO = new EquipmentDTO();
            tempEquipmentDTO.setEquipmentId(eachEquipment.getEquipmentId());
            tempEquipmentDTO.setCategory(eachEquipment.getCategory());
            tempEquipmentDTO.setEquipmentName(eachEquipment.getEquipmentName());
            tempEquipmentDTO.seteLength(eachEquipment.geteLength());
            tempEquipmentDTO.seteWidth(eachEquipment.geteWidth());
            tempEquipmentDTO.seteHeight(eachEquipment.geteHeight());
            tempEquipmentDTO.setAircraft(eachEquipment.getAircraft());
            tempEquipmentDTO.setInUse(eachEquipment.getInUse());
            tempEquipmentDTO.setHasDefects(eachEquipment.getHasDefects());
            tempEquipmentDTO.setIsFavourite(false);
            tempEquipmentDTO.setLocation(eachEquipment.getLocation());
            tempEquipmentDTO.setEmployee(eachEquipment.getEmployee());
            tempEquipmentDTO.setDefectsList(eachEquipment.getDefectsList());
            equipmentDTOList.add(tempEquipmentDTO);
        }

        Collections.sort(equipmentDTOList, new EquipmentIDComparator());
        try{
            jsonString = obj.writerWithDefaultPrettyPrinter().writeValueAsString(equipmentDTOList);
        }catch(Exception e){ }

        return jsonString;
    }
}
