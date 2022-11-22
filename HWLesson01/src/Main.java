import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getAnonymousLogger();
        Product product1 = new HotDrink("americano", 10.12, 0.2, 90);
        Product product2 = new HotDrink("cappuccino", 11.90, 0.3, 92);
        Product product3 = new HotDrink("latte", 10.50, 0.3, 90);
        List<Product> hotDrinksList = new ArrayList<>(Arrays.asList(product1, product2, product3));

        HotDrinksMachine myMachine = new HotDrinksMachine();

        myMachine.initProduct(hotDrinksList);

        logger.info(myMachine.getProduct("americano").toString());
        logger.info(myMachine.getProduct("latte", 0.3, 90).toString());
    }
}