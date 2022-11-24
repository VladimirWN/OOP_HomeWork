import java.util.List;

public interface VendingMachineInterface {
    public void initProduct(List<Product> products);
    public Product getProduct(String name);
}
