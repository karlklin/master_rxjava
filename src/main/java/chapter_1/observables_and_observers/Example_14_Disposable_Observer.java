package chapter_1.observables_and_observers;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Example_14_Disposable_Observer {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> interval = Observable.interval(1000, TimeUnit.MILLISECONDS);

        Disposable disposable = interval
                .subscribe(c -> System.out.println("Observer1 " + c));

        interval.subscribe(c -> System.out.println("Observer2 " + c));

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
