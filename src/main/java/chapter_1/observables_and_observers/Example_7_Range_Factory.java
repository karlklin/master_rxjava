package chapter_1.observables_and_observers;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_7_Range_Factory {

    public static void main(String[] args) {
       Observable.range(100, 2).subscribe(System.out::println);
    }

}
