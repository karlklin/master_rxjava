package chapter_6.flowables_and_backpressure;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class Example_48_Flowables {

    public static void main(String[] args) throws InterruptedException {
        // Back-pressure - needed in case of asynchronous operations and high pace

        hugeDataSetUsingFlowables();
    }

    private static void hugeDataSetUsingFlowables() throws InterruptedException {
        Flowable<Integer> source = Flowable.range(1, 50000000)
                .doOnNext(integer -> System.out.println("next value is coming: " + integer))
                .subscribeOn(Schedulers.computation());

        source.subscribe(integer -> {
            TimeUnit.MILLISECONDS.sleep(250);
            System.out.println("I'm consuming next value: " + integer);
        });

        source.subscribe(integer -> {
            TimeUnit.MILLISECONDS.sleep(70);
        });

        TimeUnit.MILLISECONDS.sleep(10000);
    }

}
