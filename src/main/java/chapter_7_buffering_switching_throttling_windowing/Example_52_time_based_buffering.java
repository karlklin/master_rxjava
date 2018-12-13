package chapter_7_buffering_switching_throttling_windowing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_52_time_based_buffering {

    public static void main(String[] args) throws InterruptedException {
        // Basically Buffering, Switching, Throttling and Windowing as
        // alternative for Flowables (Flowables come with some obstacles)

        // We have two types: time and boundary based buffering.
        // Following one is time-based.

        Observable.interval(300, TimeUnit.MILLISECONDS)
                .buffer(1000, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);

        TimeUnit.MILLISECONDS.sleep(10000);
    }

}
