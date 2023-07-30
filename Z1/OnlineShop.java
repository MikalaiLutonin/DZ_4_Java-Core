// Класс «Эмуляция интернет-магазина».
// 1. Написать классы покупатель (ФИО, возраст, телефон), товар (название, цена) и заказ (объект покупатель, объект товар, целочисленное количество).
// 2. Создать массив покупателей (инициализировать 2 элемента), массив товаров (инициализировать 5 элементов) и массив заказов (пустой на 5 элементов).
// 3. Создать статический метод «совершить покупку» со строковыми параметрами, соответствующими полям объекта заказа. Метод должен вернуть объект заказа.
// 4. Если в метод передан несуществующий покупатель – метод должен выбросить исключение CustomerException, 
// если передан несуществующий товар, метод должен выбросить исключение ProductException, 
// если было передано отрицательное или слишком больше значение количества (например, 100), метод должен выбросить исключение AmountException.
// 5. Вызвать метод совершения покупки несколько раз таким образом, чтобы заполнить массив покупок возвращаемыми значениями. Обработать исключения следующим образом (в заданном порядке):
// –если был передан неверный товар – вывести в консоль сообщение об ошибке, не совершать данную покупку;
// – если было передано неверное количество – купить товар в количестве 1;
// –если был передан неверный пользователь – завершить работу приложения с исключением.
// 6. Вывести в консоль итоговое количество совершённых покупок после выполнения основного кода приложения.



public class OnlineShop {
    static Customer[] customers = {new Customer("John Smith", 25, "123-456-7890"), new Customer("Jane Doe", 30, "987-654-3210")};
    static Product[] products = {new Product("Product 1", 10), new Product("Product 2", 20), new Product("Product 3", 30), new Product("Product 4", 40), new Product("Product 5", 50)};
    static Order[] orders = new Order[5];
    static int numOfOrders = 0;

    public static Order makePurchase(String customerName, String productName, int amount) throws CustomerException, ProductException, AmountException {
        Customer customer = null;
        Product product = null;

        for (Customer c : customers) {
            if (c.name.equals(customerName)) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            throw new CustomerException("Invalid customer name!");
        }

        for (Product p : products) {
            if (p.name.equals(productName)) {
                product = p;
                break;
            }
        }

        if (product == null) {
            throw new ProductException("Invalid product name!");
        }

        if (amount < 0 || amount > 99) {
            throw new AmountException("Invalid amount!");
        }

        if (amount == 0) {
            amount = 1;
        }

        Order order = new Order(customer, product, amount);
        orders[numOfOrders++] = order;
        return order;
    }

    
    public static void main(String[] args) {
        try {
            makePurchase("John Smith", "Product 1", 5);
            makePurchase("Jane Doe", "Product 2", 10);
            makePurchase("John Smith", "Product 3", -5);
            makePurchase("Jane Doe", "Product 6", 2);
            makePurchase("John Doe", "Product 4", 3);
        } catch (CustomerException e) {
            System.out.println(e.getMessage());
            return;
        } catch (ProductException e) {
            System.out.println(e.getMessage());
        } catch (AmountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Total number of purchases: " + numOfOrders);
    }
}

class CustomerException extends Exception {
    public CustomerException(String message) {
        super(message);
    }
}

class ProductException extends Exception {
    public ProductException(String message) {
        super(message);
    }
}

class AmountException extends Exception {
    public AmountException(String message) {
        super(message);
    }
}