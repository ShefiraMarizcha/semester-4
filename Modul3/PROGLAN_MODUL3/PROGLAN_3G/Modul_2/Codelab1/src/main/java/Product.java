public class Product {
    public String name;
    public double price;
    public int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
this.name = name;
        this.price = price;
        this.stock = stock;
    public void displayProduct() {
        double discountedPrice = price * 0.9; // 10% discount
        System.out.println("Product Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discounted Price: $" + discountedPrice);
        System.out.println("Stock: " + stock);
    }

    public void applyStockAdjustment(int adjustment) {
        stock += adjustment;
        System.out.println("Stock adjusted. New stock: " + stock);
    }
}

