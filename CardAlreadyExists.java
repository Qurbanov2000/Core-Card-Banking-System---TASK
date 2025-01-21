package exceptions.core.banking.model.constant;

import java.text.MessageFormat;

public class CardAlreadyExists extends RuntimeException {
    public CardAlreadyExists(String message) {
      super(message);
    }

}
