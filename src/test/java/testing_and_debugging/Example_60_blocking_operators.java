package testing_and_debugging;

import io.reactivex.Observable;
import io.reactivex.Single;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Example_60_blocking_operators {

    @Test
    public void take_with_blockingGet() {
        Single<Long> count = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(10)
                .count();

        Long actualValue = count.blockingGet();
        Assert.assertTrue(actualValue.longValue() == 10);
    }

    @Test
    public void first_with_blocking() {
        Observable<Long> source = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(10)
                .filter(i -> i > 4);

        Long first = source.blockingFirst();
        Assert.assertTrue(first.longValue() == 5);
    }

}
