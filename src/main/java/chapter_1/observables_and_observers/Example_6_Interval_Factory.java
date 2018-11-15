package chapter_1.observables_and_observers;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_6_Interval_Factory {

    public static void main(String[] args) throws InterruptedException {
       // Interval Observable emits on separate thread
       Observable.interval(1000, TimeUnit.MILLISECONDS).subscribe(System.out::println);

       // It runs on the main thread so without this sleep it will terminate immediately.
       Thread.sleep(5000);
    }

}
