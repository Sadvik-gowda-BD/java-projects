package com.it.comparable;

import com.it.comparator.AgeComparator;
import com.it.comparator.NameComparator;
import com.it.dto.StudentDto;

import java.util.*;

public class MainClass {


    public static void main(String[] args) {

        List<StudentDto> ls = new ArrayList<>();
        ls.add(new StudentDto(5,"abc",25));
        ls.add(new StudentDto(3,"jkl",21));
        ls.add(new StudentDto(9,"def",25));
        ls.add(new StudentDto(5,"mno",30));
        ls.add(new StudentDto(56,"ghi",22));


        //Comparable
        Collections.sort(ls);
        System.out.println("Sort By id:"+ls);

        //comparator ls.sort();
        ls.sort(new NameComparator());
        System.out.println("Sort By Name:"+ls);

        Comparator<StudentDto> cm2=Comparator.comparing(StudentDto::getAge);
        Collections.sort(ls,cm2);

        ls.sort(new AgeComparator());
        System.out.println("Sort By age:"+ls);


    }
}
