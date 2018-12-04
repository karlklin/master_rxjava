package chapter_3.combining_observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_38_zipping {

    public static void main(String[] args) throws InterruptedException {
        // Zips sources but as long as they have pairs!

        Observable<String> source1 = Observable.just("Alpha", "Beta", "Omega");
        Observable<String> source2 = Observable.just("1", "2");

        Observable.zip(source1, source2, (s, s2) -> s + "-" + s2)
                .subscribe(System.out::println);

        System.out.println("The same with zipWith");

        source1.zipWith(source2, (s, s2) -> s + "+" + s2)
                .subscribe(System.out::println);

        Observable<Long> slowSource = Observable.intervalRange(1, 5, 0, 1500, TimeUnit.MILLISECONDS);
        Observable<Long> fastSource = Observable.intervalRange(100, 3, 0, 300, TimeUnit.MILLISECONDS);

        Observable.zip(slowSource, fastSource, (aLong, aLong2) -> aLong + "-" + aLong2)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }

}