public class Order  {
    Customer customer;
    Product product;
    int amount;

    public Order(Customer customer, Product product, int amount) {
        this.customer = customer;
        this.product = product;
        this.amount = amount;
    }
}
