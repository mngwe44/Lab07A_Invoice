public class LineItem {
    private Product product;
    private int quantity;
    private double total;

    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        calculateTotal();
    }

    public void calculateTotal() {
        total = product.getUnitPrice() * quantity;
    }

    public double getTotal() {
        return total;
    }

    public String getLineItemDescription() {
        return product.getName() + " (x" + quantity + ") - $" + total;
    }
}

