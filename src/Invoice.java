import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private List<LineItem> lineItems;

    public Invoice() {
        lineItems = new ArrayList<>();
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    public double calculateTotalAmount() {
        double totalAmount = 0;
        for (LineItem item : lineItems) {
            totalAmount += item.getTotal();
        }
        return totalAmount;
    }

    public String getInvoiceDetails() {
        StringBuilder details = new StringBuilder("Invoice Details:\n");
        for (LineItem item : lineItems) {
            details.append(item.getLineItemDescription()).append("\n");
        }
        details.append("Total Amount Due: $" + calculateTotalAmount());
        return details.toString();
    }
}

