import java.util.ArrayList;
import java.util.List;

public class HotDrinksMachine implements HotDrinksMachineInterface {
    List<Product> hotDrinksList;

    public HotDrinksMachine() {
        this.hotDrinksList = new ArrayList<>();
    }

    @Override
    public void initProduct(List<Product> products) {
        this.hotDrinksList.addAll(products);
    }

    @Override
    public Product getProduct(String name) {
        for (int i = 0; i < this.hotDrinksList.size(); i++) {
            Product product = this.hotDrinksList.get(i);
            if (product.name.equals(name)) {
                return this.hotDrinksList.remove(i);
            }
        }
        return null;
    }

    @Override
    public Product getProduct(String name, double volume, int temperature) {
        for (int i = 0; i < this.hotDrinksList.size(); i++) {
            HotDrink product = (HotDrink) this.hotDrinksList.get(i);
            if (product.name.equals(name) && product.volume == volume && product.temperature == temperature) {
                return this.hotDrinksList.remove(i);
            }
        }
        return null;
    }
}
