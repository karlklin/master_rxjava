package chapter_1.observables_and_observers;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Example_14_DIsposable_Observer {

    public static void main(String[] args) throws InterruptedException {
        Disposable disposable = Observable.interval(1000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        // subscribing for 5000 ms
        Thread.sleep(5000);

        // after 5000 we're disposing the subscriber
        disposable.dispose();
        System.out.println("Disposed");

        // continuing main thread and checking whether the subscriber is really disposed
        Thread.sleep(5000);
        System.out.println("DONE");
    }
}
