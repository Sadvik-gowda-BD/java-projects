package com.it.java.java8.functionalinterface;

import com.it.java.dto.StudentDto;

import java.util.List;

public class MainClass {

    public static void main(String[] args) {

        //Use with anonymous class
        StudentDto student1 = new StudentDto(101, "Virat", 27);
        StudentDto student2 = new StudentDto(102, "Nikki", 20);

        AgeFilter ageFilter = new AgeFilter() {
            @Override
            public boolean ageFilter(StudentDto student) {
                return student.getAge() > 20;
            }
        };
        System.out.println("Anonymous class");
        System.out.println("Student1:" + ageFilter.ageFilter(student1));
        System.out.println("Student2:" + ageFilter.ageFilter(student2));

        //lambda
        AgeFilter ageFilterLambda = (student) -> {
            return student.getAge() > 20;
        };
        System.out.println("Anonymous class");
        System.out.println("Student1:" + ageFilterLambda.ageFilter(student1));
        System.out.println("Student2:" + ageFilterLambda.ageFilter(student2));

        //using normal filer with predicate
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6);
        numList.stream()
                .filter(num -> num % 2 == 0)
                .forEach(System.out::println);


    }
}
