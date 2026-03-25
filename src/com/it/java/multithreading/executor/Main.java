package com.it.java.multithreading.executor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws Exception {

        completableFuture();
    }

    //Where / on which threads should this task run?
    private void ExecutorService() throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<?> usesRun = executor.submit(() -> System.out.println("abc"));
        System.out.println(usesRun.get());
        Future<Integer> future = executor.submit(() -> 100);

        System.out.println(future.get());

        executor.shutdown();
        /*
     The program does not stop because future.get() only waits for the submitted task to complete and return its result.
     It does not shut down the thread pool. newFixedThreadPool() creates non-daemon worker threads, so even after main()
     finishes, those threads remain alive waiting for more tasks, preventing JVM termination. We must call executor.shutdown()
     or use try-with-resources in Java 21.
      */

    }

    //It simplifies asynchronous task execution by managing a pool of worker threads
    //What should happen after this async result arrives? It supports chaining like then apply etc
    private static void completableFuture() throws Exception {
        CompletableFuture<Integer> future1 =
                CompletableFuture.supplyAsync(() -> 10)
                        .thenApply(x -> x * 2);

        System.out.println(future1.get()); // 20


        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            // runs in separate thread
            return 42;
        });

        // non-blocking — chain operations
        future2.thenAccept(result -> System.out.println("Result: " + result));
        future2.whenComplete((result, ex) -> { }); //non-block execution used in kafka after publish to kafka topic

        // or block and get
        Integer result = future2.get();
        System.out.println("Get result:" + result);
    }


}
