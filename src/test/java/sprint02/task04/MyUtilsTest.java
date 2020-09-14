package sprint02.task04;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyUtilsTest {

    @Test
    void largestEmployees() {
        List<Employee> workers = new ArrayList<>();
        // workers.add(null);
        workers.add(new Employee("Ivan", 10, BigDecimal.valueOf(3000)));
        workers.add(new Manager("Petro", 9, BigDecimal.valueOf(3000), 1.5));
        workers.add(new Employee("Stepan", 8, BigDecimal.valueOf(4000)));
        workers.add(new Employee("Andriy", 7, BigDecimal.valueOf(3500)));
        workers.add(new Employee("Ihor", 5, BigDecimal.valueOf(4500)));
        workers.add(new Manager("Vasyl", 8, BigDecimal.valueOf(2000), 2));

        MyUtils myUtils = new MyUtils();
        List<Employee> result = myUtils.largestEmployees(workers);
        assertEquals(3, result.size());
        System.out.println(result);

        // should be
        //[Employee [name=Ivan, experience=10, basePayment=3000.00],
        // Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5], --> base 4500
        // Employee [name=Ihor, experience=5, basePayment=4500.00]].
    }
}
