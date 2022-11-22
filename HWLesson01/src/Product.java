public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, Cost: %,.2f", this.name, this.cost);
    }
}

class BattleOfWater extends Product {
    private double volume;

    public BattleOfWater(String name, double cost, double volume) {
        super(name, cost);
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, Volume:%,.1f, Cost: %,.2f", this.getName(),
                this.volume, this.getCost());
    }
}

class HotDrink extends BattleOfWater {
    private int temperature;

    public HotDrink(String name, double cost, double volume, int temperature) {
        super(name, cost, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return String.format("Product name: %s, Volume:%,.1f, Temperature: %d, Cost: %,.2f", this.getName(),
                this.getVolume(), this.temperature, this.getCost());
    }
}