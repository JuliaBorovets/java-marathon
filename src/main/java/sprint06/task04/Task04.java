package sprint06.task04;

import java.util.ArrayList;
import java.util.List;

public class Task04 {
}

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    DecisionMethod goShopping = (String product, int discount) -> product.equals("product1") && discount > 10;
}

@FunctionalInterface
interface DecisionMethod {
    boolean decide(String product, int discount);
}

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {

        return (int) clients.stream()
                .filter(p -> p.decide(product, percent))
                .count();

    }
}
