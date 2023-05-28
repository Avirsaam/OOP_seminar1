package seminar01;

public class BottleOfWater extends Product {

    private double volume;

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public BottleOfWater(String brand, String name, double price, double volume) {
        super(brand, name, price);
        this.volume = volume;
    }

    @Override
    public String displayInfo() {
        return String.format("[Бутылка] %s - %s - %f [объем: %.1f]", brand, name, price, volume);
    }
}
