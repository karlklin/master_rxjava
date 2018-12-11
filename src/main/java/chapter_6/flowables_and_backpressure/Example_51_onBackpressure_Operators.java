package chapter_6.flowables_and_backpressure;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableOnSubscribe;

import java.util.concurrent.TimeUnit;

public class Example_51_onBackpressure_Operators {

    public static void main(String[] args) throws InterruptedException {
        FlowableOnSubscribe<Object> source = emitter -> {
            int counter = 0;
            while (true) {
                System.out.println("item_" + (counter++));
                TimeUnit.MILLISECONDS.sleep(1000);
            }
        };
        Flowable<Object> flowable = Flowable.create(source, BackpressureStrategy.MISSING);

        flowable.onBackpressureBuffer(10, () -> System.out.println("onOnOverflow"), BackpressureOverflowStrategy.DROP_OLDEST);
        // source.onBackpressureLatest();
        // source.onBackpressureDrop();

        flowable.subscribe(System.out::println);

        TimeUnit.MILLISECONDS.sleep(10000);
    }

}
