package chapter_4.multicasting;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_43_replying {

    public static void main(String[] args) throws InterruptedException {
        // Reply is kind of queue when we specify how many items will be remained
        // in the queue for observers that start subscribing

        replyingExample();
    }

    static void replyingExample() throws InterruptedException {
        Observable<Long> autoObservable = Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .replay(4)
                .autoConnect();

        System.out.println("=== replying example ===");

        autoObservable
                .subscribe(s -> System.out.println("observer 1:" + s));

        Thread.sleep(7000);

        System.out.println("=== 2 is subscribing ===");

        autoObservable
                .subscribe(s -> System.out.println("observer 2:" + s));

        Thread.sleep(5000);
    }

}
