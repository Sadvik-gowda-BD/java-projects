package com.it.java.comparator;

import com.it.java.dto.StudentDto;

import java.util.Comparator;

public class AgeComparator implements Comparator<StudentDto> {
    @Override
    public int compare(StudentDto o1, StudentDto o2) {
        return o1.getAge() - o2.getAge();
    }
}
