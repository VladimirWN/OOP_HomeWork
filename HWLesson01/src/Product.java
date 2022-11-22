public class Product {
    protected String name;
    protected double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, Cost: %,.2f", this.name, this.cost);
    }
}

class BattleOfWater extends Product {
    protected double volume;

    public BattleOfWater(String name, double cost, double volume) {
        super(name, cost);
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, Volume:%,.1f, Cost: %,.2f", super.name, this.volume, super.cost);
    }
}

class HotDrink extends BattleOfWater {
    protected int temperature;

    public HotDrink(String name, double cost, double volume, int temperature) {
        super(name, cost, volume);
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, Volume:%,.1f, Temperature: %d, Cost: %,.2f", super.name, super.volume, this.temperature, super.cost);
    }
}