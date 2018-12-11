package chapter_6.flowables_and_backpressure;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;

public class Example_50_from_Observable_to_Flowable_and_vice_versa {

    public static void main(String[] args) {
        Observable.just("item_1")
                .toFlowable(BackpressureStrategy.BUFFER);

        Flowable.range(1, 1)
                .toObservable();
    }

}
