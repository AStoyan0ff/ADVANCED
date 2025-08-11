package _12DefiningClassesEX.CompanyRoster;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        List<Employee> employeesList = new ArrayList<>();

        for (int pos = 0; pos < N; pos++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            String email = "n/a";
            int age = -1;

            if (data.length == 5) {

                if (data[4].contains("@")) {
                    email = data[4];
                }
                else {
                    age = Integer.parseInt(data[4]);
                }
            }
            else if (data.length == 6) {

                email = data[4];
                age = Integer.parseInt(data[5]);
            }

            employeesList.add(new Employee(name, salary, position, department, email, age));
        }

        Map<String, List<Employee>> departmentsMap = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        String avgDep = departmentsMap
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(d -> d.getValue().stream()
                .mapToDouble(Employee::getSalary).average().orElse(0)))
                .get()
                .getKey();

        System.out.println("Highest Average Salary: " + avgDep);

        departmentsMap.get(avgDep)
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(e -> System.out.printf("%s %.2f %s %s%n",
                        e.getName(), e.getSalary(), e.getEmail(), e.getAge()));
    }
}
