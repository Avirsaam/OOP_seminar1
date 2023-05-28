package seminar01;

public class Chocolate extends Product{

    protected float cocoaContent;

    protected int calories;

    protected String type;


    public Chocolate(String brand, String name, double price, float cocoaContent, int calories, String type) {
        super(brand, name, price);
        this.cocoaContent = cocoaContent;
        this.calories = calories;
        this.type = type;
    }

    public Chocolate(String brand, String name, double price) {
        this(brand, name, price, 70, 550, "молочный");
    }


    @Override
    public String toString() {
        return String.format("[Шоколадка]: %s, %.1f, %s, калорийность %d", super.toString(), this.cocoaContent, this.type, this.calories);
    }
}
