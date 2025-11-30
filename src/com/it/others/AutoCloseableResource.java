package com.it.others;

public class AutoCloseableResource {
    public static void main(String[] args) throws Exception {

        try(MyResource res = new MyResource()){
            res.readResource();
            res.writeResource();
        }
        System.out.println("Process Completed");
    }
}


class MyResource implements AutoCloseable{

    public void readResource(){
        System.out.println("Reading resource");
    }

    public void writeResource(){
        System.out.println("Write resource");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Automatically closing resource. By using close method");
    }
}



