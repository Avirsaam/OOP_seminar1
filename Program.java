package seminar01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Program {

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine("Аппарат_1");
        Random random = new Random();

        List<Product> productList = new ArrayList<>();

        productList.add(new Product());
        productList.add(new Product("ООО Чистый Источник", "Бутылка с водой #2", -90.15));
        productList.add(new BottleOfWater("ООО Чистый Источник", "Бутылка с водой #3", -90.15, 1.5));
        productList.add(new BottleOfMilk("ООО Чистый Источник", "Бутылка с молоком #1", -90.15, 1.5, 10));
        productList.add(new Chocolate("Красный Октябрь", "Аленка", 86));
        productList.add(new Chocolate("Альфред Риттер", "Риттерспорт", 100, 50, 550, "с изюмом"));
        productList.add(new Chocolate("Фабрика Крупской", "Особый", 90));
        System.out.println(vendingMachine);

        System.out.println("\n\nЗагружаем машину товаром");
        for (Product thisProduct : productList) {
            vendingMachine.loadProducts(thisProduct, 20);
        }
        System.out.println(vendingMachine);

        System.out.println("\n\n\nПродаем товары:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Продажа: " + vendingMachine.sellNextRandomProduct());
        }
        System.out.println(vendingMachine);
    }

}
