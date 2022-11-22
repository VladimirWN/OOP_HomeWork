import java.util.List;

public interface VendingMachineInterface {
    public void initProduct(List<Product> products);
    public Product getProduct(String name);
}

interface HotDrinksMachineInterface extends VendingMachineInterface {
    public Product getProduct(String name, double volume, int temperature);

}