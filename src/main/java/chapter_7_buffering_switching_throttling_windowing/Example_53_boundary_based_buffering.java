package chapter_7_buffering_switching_throttling_windowing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_53_boundary_based_buffering {

    public static void main(String[] args) throws InterruptedException {
        /*Observable.interval(300, TimeUnit.MILLISECONDS)
                .buffer(5, 1)
                .subscribe(System.out::println);

        TimeUnit.MILLISECONDS.sleep(10000);*/

        Observable.interval(333,TimeUnit.MILLISECONDS )
                .buffer(Observable.interval(1000,TimeUnit.MILLISECONDS ))
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }

}
