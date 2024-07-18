import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println("Enter client data");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.next();
        System.out.println("Bith date (DD/MM/YYYY): ");
        Date birthDate = dateFormat.parse(sc.next());

        Client client = new Client(name, email, birthDate);
        System.out.println("Enter order data");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        Order order = new Order(new Date(), status, client);

        System.out.println("How many items to this order? ");
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.println("Enter #" + (i + 1) + " item data: ");
            System.out.println("Product name: ");
            String productName = sc.next();
            System.out.println("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productPrice, productName);
            OrderItem it = new OrderItem(quantity, productPrice, product);
            order.addItem(it);
        }

        System.out.println(order);
    }
}