package airline.system.exception;

import java.text.MessageFormat;

public class AirlineNotFound extends RuntimeException {

    public AirlineNotFound(Long id)
    {
        super(MessageFormat.format("Could not find airline" ,id));
    }


}
