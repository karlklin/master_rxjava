package chapter_1.observables_and_observers;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Example_16_Composing_Disposable {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> intervalObservable = Observable.interval(1000, TimeUnit.MILLISECONDS);

        Disposable disposable1 = intervalObservable
                .subscribe(counter -> System.out.println("Observer1: " + counter));

        Disposable disposable2 = intervalObservable
                .subscribe(counter -> System.out.println("Observer2: " + counter));

        CompositeDisposable disposables = new CompositeDisposable(disposable1, disposable2);

        // subscribing for 5000 ms
        Thread.sleep(5000);

        // after 5000 we're disposing the subscriber
        disposables.dispose();
        System.out.println("Disposed");

        // continuing main thread and checking whether the subscriber is really disposed
        Thread.sleep(5000);
        System.out.println("DONE");
    }
}
