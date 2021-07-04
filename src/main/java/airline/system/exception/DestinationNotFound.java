package airline.system.exception;

import java.text.MessageFormat;

public class DestinationNotFound extends RuntimeException {


    public DestinationNotFound(Long id)
    {
        super(MessageFormat.format("Could not find destination" ,id));
    }


}
