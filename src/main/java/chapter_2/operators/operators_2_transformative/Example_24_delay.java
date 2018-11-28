package chapter_2.operators.operators_2_transformative;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_24_delay {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== delay by 5 sec=== ");
        Observable.just("first", "second", "third", "forth")
                .delay(5000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        Thread.sleep(10000);
        System.out.println("DONE");
    }
}
