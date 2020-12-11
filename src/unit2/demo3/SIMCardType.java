package unit2.demo3;

public enum SIMCardType {
    SMALL("S"), MEDIUM("M"), LARGE("L");

    private String cardType;

    SIMCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardType() {
        return cardType;
    }
}
