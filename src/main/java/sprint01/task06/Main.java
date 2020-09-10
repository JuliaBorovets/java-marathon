package sprint01.task06;

public class Main {
    public static void main(String[] args) {

        Product product = new Product();
        Product product1 = new Product("product", 2);
        Product product2 = new Product();

        int count = Product.count();

        System.out.println(count);
    }
}
