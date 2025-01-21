package exceptions.core.banking.model.constant;

public class main {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
            System.err.println("Unhandled exception caught in thread: " + thread.getName());
            throwable.printStackTrace();
        });

        CardService cardService = new CardService();
        cardService.registerCard(new CardRequestDto("Ali Qurbanov", "+994556740406", "ali.qurbanov0087@gmail.com", CardType.PHYSICAL));
        cardService.registerCard(new CardRequestDto("Nurlan Mammadov", "+994517556255", "nurlanmammadov@mail.ru", CardType.VIRTUAL));
        cardService.listAllCards();
        cardService.deleteCard("ali.qurbanov0087@gmail.com");
        cardService.listAllCards();

    }
}
