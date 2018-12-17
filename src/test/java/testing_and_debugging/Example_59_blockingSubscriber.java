package testing_and_debugging;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Example_59_blockingSubscriber {

    @Test
    public void test_without_blockingSubscribers() {
        Single<Long> count = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(10)
                .count();

        Long actualValue = count.blockingGet();
        System.out.println(actualValue);
        Assert.assertTrue(actualValue.longValue() == 10);
    }

}
