package seminar01;

import java.util.*;

public class VendingMachine {
    private String name;


    private double cashMoneyCollected;

    private Map<Product, Integer> currentContent;

    public VendingMachine(String name) {
        currentContent = new HashMap<>();
        this.name = name;
        this.cashMoneyCollected = 0;
    }

    /**
     * возвращает текущее количество товара данного типа в аппарате
     * @param product - тип товара
     * @return - количество
     */
    public Integer getRemainingQuantity(Product product){
        return currentContent.get(product);
    }


    /**
     * производит загрузку продукта в машину
     * @param product - загружаемый продукт
     * @param quantity  - загружаемое количество
     * @return - возвращает текущее количество в аппарате
     */
    public Integer loadProducts(Product product, Integer quantity){
        if (quantity != null || quantity != 0){
            if (currentContent.containsKey(product)){
                currentContent.put(product, currentContent.get(product) + quantity);
            }else {
                currentContent.put(product, quantity);
            }
        }
        return getRemainingQuantity(product);
    }

    public Product sellNextRandomProduct(){
        Random r = new Random();
        int randomIndex = r.nextInt(currentContent.keySet().size());
        List <Product> allProductsLoaded = new ArrayList<>(currentContent.keySet());
        Product randomProduct = allProductsLoaded.get(randomIndex);

        return releaseProduct(randomProduct);
    }

    /**
     * производит выдачу товара из аппарата запрошенного типа
     * @param requestedProduct - запрашиваемый товар
     * @return - оставшееся количество в аппарате
     */
    public Product releaseProduct(Product requestedProduct){
        if (getRemainingQuantity(requestedProduct) > 0){
            currentContent.put(requestedProduct,currentContent.get(requestedProduct) - 1);
            cashMoneyCollected = cashMoneyCollected + requestedProduct.price;
        } else {
            return null;
        }
        return requestedProduct;
    }

    public Double getCashMoneyCollected() {
        return cashMoneyCollected;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\nТекущее содержимое машины:\n");
        int count = 0;
        for (Product thisItem: currentContent.keySet()) {
            sb.append(
                    String.format("%03d [ %s ] %s - %s, количество: %d\n",count++, thisItem.getClass().getSimpleName(), thisItem.name, thisItem.brand, currentContent.get(thisItem)));

        }
        sb.append("------\n");
        sb.append("Собрано наличными: " + cashMoneyCollected);
        return sb.toString();
    }

}
