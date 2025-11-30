package com.it.java.java8.functionalinterface;

import com.it.java.dto.StudentDto;

//Same as Predicate
public interface AgeFilter<T> {

    boolean ageFilter(T t);
}
