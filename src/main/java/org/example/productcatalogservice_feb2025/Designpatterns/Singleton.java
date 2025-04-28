package org.example.productcatalogservice_feb2025.Designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class Singleton {
}
/*
package org.example.productcatalogservice_feb2025;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductCatalogServiceFeb2025Application {

    public static void main(String[] args) {
        SpringApplication.run(org.example.productcatalogservice_feb2025.ProductCatalogServiceFeb2025Application.class, args);


        Runnable task =()->{
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
    }

}
class Singleton{
    private Singleton(){}

    private  static class SingletonHelper{
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonHelper.instance;
    }
}

 */