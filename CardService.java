package exceptions.core.banking.model.constant;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class CardService {
    private static final List<CardUser> CARD_USERS = new ArrayList<>();
    private static final Logger LOGGER = Logger.getLogger(CardService.class.getName());


    void registerCard(CardRequestDto requestDto) throws CardAlreadyExists {
        if (!requestDto.isValidEmail(requestDto.getEmail())) {
            LOGGER.warning("Invalid email address!");
        } else if (!requestDto.isValidPhoneNumber(requestDto.getPhoneNumber())) {
            LOGGER.warning("Invalid phone number!");
        } else {
            boolean check=false;
            for (CardUser user : CARD_USERS) {
                if (user.getEmail().equals(requestDto.getEmail())) {
                    check=true;
                    throw new CardAlreadyExists("Card already exists!");
                }
            }
            if (!check) {
                CARD_USERS.add(CardMapper.toCardUser(requestDto));
                //LOGGER.info(requestDto.getEmail() + " has been registered!");
            }
        }
    }
    void listAllCards() {
        if (CARD_USERS.size() > 0) {
            CARD_USERS.forEach(cardUser -> System.out.println("User " + (CARD_USERS.indexOf(cardUser)+1) + " is:" + cardUser.toString()));
        }
        else LOGGER.warning("No cards registered");
    }
    void deleteCard(String email) {
        boolean found = false;
        for (CardUser cardUser : CARD_USERS) {
            if (cardUser.getEmail().equals(email)) {
                CARD_USERS.remove(cardUser);
                //LOGGER.info(email + " Card is deleted");
                found = true;
            }
        }
        if (!found) throw new noCardFound("There is no card with this email");
    }
}
