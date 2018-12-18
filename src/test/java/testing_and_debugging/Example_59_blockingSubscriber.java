package testing_and_debugging;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Example_59_blockingSubscriber {

    @Test(expected = AssertionError.class)
    public void take_without_blockingSubscribers() {
        Observable<Long> source = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(10);

        TakeCheckerConsumer consumer = new TakeCheckerConsumer();

        source.subscribe(consumer);
        Assert.assertTrue(consumer.getCount() == 10);
    }

    @Test
    public void take_with_blockingSubscribers() {
        Observable<Long> source = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(10);

        TakeCheckerConsumer consumer = new TakeCheckerConsumer();

        source.blockingSubscribe(consumer);
        Assert.assertTrue(consumer.getCount() == 10);
    }

    private static class TakeCheckerConsumer implements Consumer<Long> {
        int count;

        public void accept(Long aLong) {
            count++;
        }

        public int getCount() {
            return count;
        }
    }

}
