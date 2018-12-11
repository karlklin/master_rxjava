package chapter_6.flowables_and_backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;

public class Example_49_Backpressure_Strategies {

    public static void main(String[] args) {
        // Backpressure Strategies:
        // - BUFFER - it is using cache for emission that cannot be handled right away (can cause out of memory exception)
        // - DROP - omits not handled emissions
        // - ERROR - throws Exceptions
        // - LATEST - caches only the last emission
        // - MISSING - no buffering or dropping. Downstream has to deal with any overflow.

        Flowable.create(emitter -> {
            emitter.onNext("item_1");
            emitter.onNext("item_2");
        }, BackpressureStrategy.LATEST);
    }

}
