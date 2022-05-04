package memory;

import java.io.Serializable;
import java.util.UUID;

public class BusModel implements Serializable {

    public String busID = UUID.randomUUID().toString();


}
