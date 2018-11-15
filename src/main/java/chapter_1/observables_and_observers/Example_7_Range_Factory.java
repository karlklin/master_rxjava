package chapter_1.observables_and_observers;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_7_Range_Factory {

    public static void main(String[] args) {
        // Emits numbers starting from 100 till 111

        // It runs on separate worker thread
        Observable.range(100, 12).subscribe(System.out::println);
    }

}
