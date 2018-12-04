package chapter_3.combining_observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_42_sharing {

    public static void main(String[] args) throws InterruptedException {
        sharingExample();
        /// connectableExample();
    }

    static void connectableExample() throws InterruptedException {
        Observable<Long> autoObservable = Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .publish()
                .autoConnect(2);

        System.out.println("=== connectable example ===");

        System.out.println("=== 1 and 2 observers are subscribing ===");
        autoObservable
                .take(2)
                .subscribe(s -> System.out.println("observer 1:" + s));

        autoObservable
                .take(5)
                .subscribe(s -> System.out.println("observer 2:" + s));


        Thread.sleep(7000);

        System.out.println("=== 3 and 4 observers are subscribing ===");
        autoObservable
                .subscribe(s -> System.out.println("observer 3:" + s));
        autoObservable
                .subscribe(s -> System.out.println("observer 4:" + s));

        Thread.sleep(5000);
    }

    static void sharingExample() throws InterruptedException {
        Observable<Long> autoObservable = Observable
                .interval(1000, TimeUnit.MILLISECONDS)
                .share();

        System.out.println("=== sharing example ===");

        autoObservable
                .take(2)
                .subscribe(s -> System.out.println("sharing observer 1:" + s));

        autoObservable
                .take(5)
                .subscribe(s -> System.out.println("sharing observer 2:" + s));

        Thread.sleep(7000);

        System.out.println("=== 3 and 4 observers are subscribing ===");

        autoObservable
                .subscribe(s -> System.out.println("sharing observer 3:" + s));
        autoObservable
                .subscribe(s -> System.out.println("sharing observer 4:" + s));

        Thread.sleep(5000);
    }

}
