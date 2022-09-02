public class Prices {
    private float basePrice;
    private int promoAmount;
    private float promoPrice;

    public Prices(float basePrice, int promoAmount, float promoPrice) {
        this.basePrice = basePrice;
        this.promoAmount = promoAmount;
        this.promoPrice = promoPrice;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public int getPromoAmount() {
        return promoAmount;
    }

    public void setPromoAmount(int promoAmount) {
        this.promoAmount = promoAmount;
    }

    public float getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(float promoPrice) {
        this.promoPrice = promoPrice;
    }
}
