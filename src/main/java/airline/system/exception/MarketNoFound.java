package airline.system.exception;

import java.text.MessageFormat;

public class MarketNoFound extends RuntimeException {

    public MarketNoFound(Long id)
    {
        super(MessageFormat.format("Could not find market" ,id));
    }


}
