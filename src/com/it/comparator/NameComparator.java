package com.it.comparator;

import com.it.dto.StudentDto;

import java.util.Comparator;

public class NameComparator implements Comparator<StudentDto> {
    @Override
    public int compare(StudentDto o1, StudentDto o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
