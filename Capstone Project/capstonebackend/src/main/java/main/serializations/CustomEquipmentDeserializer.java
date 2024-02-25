package main.serializations;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import main.entities.*;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Custom deserialiser to deserialist the JSON String input from the front end. Example of the JSON String is
 * shown below
 *      {
 *      "category": "Tow Tug",
 *      "equipmentName": "TLD 500HP XXL Tow Tug",
 *      "eLength": 3.0,
 *      "eWidth": 1.5,
 *      "eHeight": 1.5,
 *      "aircraft": "B747",
 *      "location": "G21"
 *      }
 */
public class CustomEquipmentDeserializer extends JsonDeserializer<Equipment>{
    
    @Override
    public Equipment deserialize(JsonParser parser, DeserializationContext deCtxt)
                throws IOException, JacksonException {

        Equipment equipment = null;
        JsonNode jsonNode = parser.getCodec().readTree(parser);

        try {
            equipment = new Equipment();
            if (jsonNode.get("category").isValueNode())
                equipment.setCategory(jsonNode.get("category").asText());
            if (jsonNode.get("equipmentName").isValueNode())
                equipment.setEquipmentName(jsonNode.get("equipmentName").asText());
            if (jsonNode.get("eLength").isValueNode())
                equipment.seteLength(jsonNode.get("eLength").asDouble());
            if (jsonNode.get("eWidth").isValueNode())
                equipment.seteWidth(jsonNode.get("eWidth").asDouble());
            if (jsonNode.get("eHeight").isValueNode())
                equipment.seteHeight(jsonNode.get("eHeight").asDouble());
            if (jsonNode.get("aircraft").isValueNode())
                equipment.setAircraft(jsonNode.get("aircraft").asText());

            equipment.setInUse(false);
            equipment.setHasDefects(false);
            equipment.setEmployee(null);
            equipment.setDefectsList(new ArrayList<Defects>());
            equipment.setLocation(new Locations(jsonNode.get("location").asText(), null, null));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return equipment;
    }
}
