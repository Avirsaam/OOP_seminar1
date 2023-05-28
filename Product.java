package seminar01;

public class Product {

    protected String name; // Наименование
    protected String brand; // Бренд
    protected double price; // Цена

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        checkPrice(price);
    }

    public Product()
    {
        this("product", 100);
    }

    public Product(String inputName, double inputPrice)
    {
        this("noname", inputName, inputPrice);
    }

    public Product(String brand, String name, double price)
    {
        if (brand == null || brand.length() < 4){
            this.brand = "noname";
        }
        else {

            this.brand = brand;
        }
        if (name == null || name.length() < 4){
            this.name = "product";
        }
        else {
            this.name = name;
        }
        checkPrice(price);
    }

    private void checkPrice(double price){
        if (price <= 0){
            this.price = 100;
        }
        else {
            this.price = price;
        }
    }

    @Override
    public boolean equals(Object obj) {
        Product that = (Product)obj;
        if (this.name.equals(that.name) && this.brand.equals(that.brand) && this.getClass().equals(that.getClass())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return displayInfo();
    }

    public String displayInfo(){
        return String.format("%s - %s - %.1f", brand, name, price);
    }


}
