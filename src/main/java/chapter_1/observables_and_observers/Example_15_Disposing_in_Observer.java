package chapter_1.observables_and_observers;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class Example_15_Disposing_in_Observer {

    public static void main(String[] args) throws InterruptedException {
        Observer<Long> observer = new Observer<Long>() {
            Disposable disposable;

            @Override
            public void onSubscribe(Disposable d) {
                this.disposable = d;
            }

            @Override
            public void onNext(Long interval) {
                System.out.println("Observer1 = " + interval);
                if (interval == 3) {
                    this.disposable.dispose();
                    System.out.println("Observer1 disposed");
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("Observer1 complete");
            }
        };

        Observable<Long> interval = Observable.interval(1000, TimeUnit.MILLISECONDS);
        interval
                .subscribe(observer);

        interval.subscribe(count -> System.out.println("Observer2 " + count));

        // subscribing for 5000 ms
        Thread.sleep(5000);

        Thread.sleep(5000);
        System.out.println("DONE");
    }
}
