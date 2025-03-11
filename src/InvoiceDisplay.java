import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoiceDisplay {
    private JFrame frame;
    private JTextField productNameField;
    private JTextField quantityField;
    private JTextField unitPriceField;
    private JTextArea invoiceDisplayArea;
    private Invoice invoice;

    public InvoiceDisplay() {
        invoice = new Invoice();

        frame = new JFrame("Invoice Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));

        // Product name input
        inputPanel.add(new JLabel("Product Name:"));
        productNameField = new JTextField();
        inputPanel.add(productNameField);

        // Quantity input
        inputPanel.add(new JLabel("Quantity:"));
        quantityField = new JTextField();
        inputPanel.add(quantityField);

        // Unit price input
        inputPanel.add(new JLabel("Unit Price:"));
        unitPriceField = new JTextField();
        inputPanel.add(unitPriceField);

        // Add button
        JButton addButton = new JButton("Add Line Item");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = productNameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double unitPrice = Double.parseDouble(unitPriceField.getText());

                Product product = new Product(name, unitPrice);
                LineItem lineItem = new LineItem(product, quantity);
                invoice.addLineItem(lineItem);

                // Clear input fields
                productNameField.setText("");
                quantityField.setText("");
                unitPriceField.setText("");

                updateInvoiceDisplay();
            }
        });

        inputPanel.add(addButton);

        // Invoice display area
        invoiceDisplayArea = new JTextArea();
        invoiceDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(invoiceDisplayArea);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void updateInvoiceDisplay() {
        invoiceDisplayArea.setText(invoice.getInvoiceDetails());
    }

    public static void main(String[] args) {
        new InvoiceDisplay();
    }
}
