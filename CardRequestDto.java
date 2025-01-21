package exceptions.core.banking.model.constant;

import java.util.regex.Pattern;

public class CardRequestDto {
    private String fullName;
    private String phoneNumber;
    private String email;
    private CardType cardType;

    public CardRequestDto(String fullName, String phoneNumber, String email, CardType cardType) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.cardType = cardType;
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pattern.matcher(email).matches();
    }

    public boolean isValidPhoneNumber(String phoneNumber) {
        String phoneRegex = "^(\\+994|0)(50|51|55|70|77)\\d{7}$";
        Pattern pattern = Pattern.compile(phoneRegex);
        if (phoneNumber == null) {
            return false;
        }
        return pattern.matcher(phoneNumber).matches();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Override
    public String toString() {
        return "CardRequestDto{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", cardType=" + cardType +
                '}';
    }
}
