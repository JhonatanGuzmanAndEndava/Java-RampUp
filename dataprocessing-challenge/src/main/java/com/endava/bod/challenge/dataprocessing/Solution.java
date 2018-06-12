package com.endava.bod.challenge.dataprocessing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String projectCode = sc.next();

        List<String> data = Files.readAllLines(Paths.get("ampas_ExportedData_Staff.1-1.csv"))
            .stream().skip(1).collect(Collectors.toList());

        List<Register> registers = new ArrayList<>();
        data.stream().forEach(s -> registers.add(new Register(
                s.split(",")[0].trim(),
                s.split(",")[13].trim(),
                Integer.parseInt(s.split(",")[15].trim().substring(2)),
                Integer.parseInt(s.split(",")[17].trim().substring(6)),
                s.split(",")[18].substring(2,5))
        ));

        List<Employee> staffList = new ArrayList<>();

        Map<String, List<Register>> registersForUsers = registers.stream().filter(s -> s.getProjectCode().equals(projectCode))
                .collect(Collectors.groupingBy(Register::getHrId));

        for (String HrId : registersForUsers.keySet()) {

            List<Register> pointer = registersForUsers.get(HrId);

            pointer.removeIf(r -> r.getPeriod() != pointer.stream()
                    .max(Comparator.comparing(Register::getPeriod))
                    .get()
                    .getPeriod());

            int year = (pointer.get(0).getMonth().getValue() > 6 ? pointer.get(0).getFiscalYear() - 1 : pointer.get(0).getFiscalYear()) + 2000;

            Employee employee = new Employee(pointer.get(0).getHrId(),
                    pointer.get(0).getProjectCode(),
                    LocalDate.of(year,pointer.get(0).getMonth(),1),
                    LocalDate.of(year,pointer.get(0).getMonth(),pointer.get(0).getMonth().length(Year.isLeap(year))));

            staffList.add(employee);

            //pointer.forEach(System.out::println);
            //System.out.println("---------------------------------------");

            for(int i = 1; i < pointer.size(); ++i) {
                if(pointer.get(i).getMonth().getValue() - employee.getEndDate().getMonth().getValue() == 1 ||
                        (pointer.get(i).getMonth() == Month.JANUARY && employee.getEndDate().getMonth() == Month.DECEMBER)) {
                    employee.setEndDate(employee.getEndDate().plusMonths(1));
                    employee.setEndDate(LocalDate.of(employee.getEndDate().getYear(),
                                                     employee.getEndDate().getMonth(),
                                                     employee.getEndDate().getMonth().length(Year.isLeap(employee.getEndDate().getYear()))));
                }else {
                    employee = new Employee(pointer.get(i).getHrId(),
                            pointer.get(i).getProjectCode(),
                            LocalDate.of(year,pointer.get(i).getMonth(),1),
                            LocalDate.of(year,pointer.get(i).getMonth(),pointer.get(i).getMonth().length(Year.isLeap(year))));
                    staffList.add(employee);
                }
            }

        }

        //System.out.println("--------FINAL STAFF-------------");
        //staffList.forEach(System.out::println);

        Export.exportToJson(new Staffs(staffList));
    }
}
