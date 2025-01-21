package exceptions.core.banking.model.constant;

public class CardMapper {
    public static CardUser toCardUser(CardRequestDto requestDto) {
        return new CardUser(
                new CardUtil().cardNumberGenerator(),
                new CardUtil().cvvGenerator(),
                requestDto.getFullName(),
                requestDto.getEmail(),
                requestDto.getPhoneNumber(),
                new CardUtil().expireDateGenerator(),
                requestDto.getCardType()
        );
    }
}
