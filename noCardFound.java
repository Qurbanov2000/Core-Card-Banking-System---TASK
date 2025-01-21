package exceptions.core.banking.model.constant;

import javax.jms.Message;
import java.text.MessageFormat;

public class noCardFound extends RuntimeException {
    public noCardFound(String message) {
      super(message);
    }

}
