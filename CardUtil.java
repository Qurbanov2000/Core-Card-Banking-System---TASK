package exceptions.core.banking.model.constant;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Random;

public class CardUtil {
    private static final String CARD_PREFIX = "4169";
    private static final Random RANDOMIZER = new Random();
    private static final int INITIAL_EXPIRATION = 5;

    public CardUtil() {
        super();
    }

    public String cardNumberGenerator() {
        StringBuilder builder = new StringBuilder(CARD_PREFIX);
        for (int i = 0; i < 12; i++) {
            builder.append(RANDOMIZER.nextInt(10));
        }
        return builder.toString();
    }
    public String expireDateGenerator() {
        LocalDate date = LocalDate.now().plusYears(INITIAL_EXPIRATION);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/yy");
        return date.format(dateFormatter);
    }
    public String cvvGenerator() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            builder.append(RANDOMIZER.nextInt(10));
        }
        return builder.toString();
    }
}
