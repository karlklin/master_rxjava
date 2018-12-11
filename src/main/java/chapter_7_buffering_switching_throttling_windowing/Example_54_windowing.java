package chapter_7_buffering_switching_throttling_windowing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_54_windowing {

    public static void main(String[] args) throws InterruptedException {
        // Windowing works the same as buffering
        // but it produces Observable of Observables for buffered emissions

        Observable.interval(250, TimeUnit.MILLISECONDS)
                .window(3)
                .flatMapSingle(longObservable -> longObservable.count())
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }

}
