package com.it.java.java8.streams;

import java.util.List;

public class ParallelStreams {

    /*The normal stream takes data in sequence form, in
    sequential stream is executed in a single thread running on one CPU core.
     The elements in the stream are processed sequentially in a single pass by the stream operations that are executed in the same thread.
     A parallel stream is executed by different threads, running on multiple CPU cores in a computer.
    The order of the element may vary in parallel streams. These threads are executed asynchronously
    */
    public static void main(String[] args) {

        //Collections.unmodifiableList();
        List<Integer> integers = List.of(1,2,3,4,5,6,7,8,9);

        System.out.println("\nNormal steams");

        integers.stream().forEach(num -> System.out.print(num + " "));

        System.out.println("\nParallel steams");
        integers.parallelStream().forEach(num -> System.out.print(num + " "));


    }
}
