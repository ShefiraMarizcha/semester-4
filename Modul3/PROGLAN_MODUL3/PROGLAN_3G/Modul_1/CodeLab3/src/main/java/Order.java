public class Order {
    private double price;
    private int quantity;

    public double calculateTotal() {
        double discount = 0.0;
        if (price > 100000) {
            discount = 0.1; // 10% discount
        } else if (price > 50000) {
            discount = 0.05; // 5% discount
        }

        double subtotal = price * quantity;
        double total = subtotal - (subtotal * discount);
        return total;
    }

    public static void main(String[] args) {
        Order order = new Order();
        order.price = 120;
        order.quantity = 3;
        System.out.println("Total: Rp" + order.calculateTotal());
    }
}
