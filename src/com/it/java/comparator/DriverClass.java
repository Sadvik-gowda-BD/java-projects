package com.it.java.comparator;

import com.it.java.dto.StudentDto;

import java.util.Set;
import java.util.TreeSet;

public class DriverClass {

    public static void main(String[] args) {

        Set<StudentDto> t = new TreeSet<>(new NameComparator());
    }
}
