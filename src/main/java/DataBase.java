import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private HashMap<Character, Prices> storage = new HashMap<>();

    public DataBase(){
        storage.put('A', new Prices(1.25f, 3, 3.0f));
        storage.put('B', new Prices(4.25f, 0 ,0f));
        storage.put('C', new Prices(1.0f, 6, 5.0f));
        storage.put('D', new Prices(0.75f, 0, 0f));
    }

    public Float calculateCartCost(String cart){
        Float result = 0f;
        for (Map.Entry<Character, Prices> entry : storage.entrySet()) {
            long count = cart.chars().filter(ch -> ch == entry.getKey()).count();
            result += calculateProductCost(entry.getKey(), count);
        }
        return result;
    }

    private Float calculateProductCost(Character productName, long amount){
        Float result;
        if (amount >= 0 && storage.containsKey(productName)){
            Prices prices = storage.get(productName);
            long promoAmount;
            if (prices.getPromoAmount() != 0) {
                promoAmount = amount / prices.getPromoAmount();
                result = promoAmount * prices.getPromoPrice() +
                        (amount - promoAmount * prices.getPromoAmount()) * prices.getBasePrice();
            } else {
                result = amount * prices.getBasePrice();
            }
        } else {
            result = null;
        }
        return result;
    }

    public HashMap<Character, Prices> getStorage() {
        return storage;
    }

    public void setStorage(HashMap<Character, Prices> storage) {
        this.storage = storage;
    }
}
