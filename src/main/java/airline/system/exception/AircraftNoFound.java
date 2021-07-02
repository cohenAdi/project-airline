package airline.system.exception;

import java.text.MessageFormat;

public class AircraftNoFound extends RuntimeException {

    public AircraftNoFound(Long id)
    {
        super(MessageFormat.format("Could not find aircraft" ,id));
    }


}
