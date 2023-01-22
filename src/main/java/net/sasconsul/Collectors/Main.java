package net.sasconsul.Collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "A", 100),
                new Employee(2, "B", 200),
                new Employee(3, "C", 300),
                new Employee(4, "D", 400));

        HashMap<String, Object> result = employeeList.stream().collect(
                Collectors.teeing(
                        Collectors.filtering(e -> e.getSalary() > 200, Collectors.toList()),
                        Collectors.filtering(e -> e.getSalary() > 200, Collectors.counting()),
                        (list, count) -> {
                            HashMap<String, Object> map = new HashMap();
                            map.put("list", list);
                            map.put("count", count);
                            return map;
                        }
                ));

        System.out.println(result);

        //===========================================

        HashMap<String, Object> result2 = employeeList.stream().collect(
                Collectors.teeing(
                        Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)),
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                        (min, max) -> {
                            HashMap<String, Object> map = new HashMap();
                            map.put("min", min);
                            map.put("max", max);
                            return map;
                        }
                ));

        System.out.println(result2);
    }
}
