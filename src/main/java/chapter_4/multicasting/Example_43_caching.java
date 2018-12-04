package chapter_4.multicasting;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_43_caching {

    public static void main(String[] args) throws InterruptedException {
        // Caching vs Replying: https://stackoverflow.com/questions/32522017/rxjava-is-cache-the-same-as-replay/32537190#32537190

        // But caching behaves differently. It suspends all emissions as long as all subscriptions are up to speed.

        cacheExample();
    }

    static void cacheExample() throws InterruptedException {
        Observable<Long> autoObservable = Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .cache();

        System.out.println("=== caching example ===");

        autoObservable
                .subscribe(s -> System.out.println("observer 1:" + s));

        Thread.sleep(7000);

        System.out.println("=== 2 is subscribing ===");

        autoObservable
                .subscribe(s -> System.out.println("observer 2:" + s));

        Thread.sleep(5000);
    }

}
