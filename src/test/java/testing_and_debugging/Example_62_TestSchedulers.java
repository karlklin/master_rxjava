package testing_and_debugging;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import io.reactivex.schedulers.TestScheduler;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Example_62_TestSchedulers {

    @Test
    public void manipulating_time_using_TestSchedulers() {
        TestScheduler testScheduler = new TestScheduler();
        Observable<Long> source = Observable.interval(1, TimeUnit.MINUTES, testScheduler);
        TestObserver<Long> testObserver = new TestObserver<>();

        source.subscribe(testObserver);
        testScheduler.advanceTimeTo(90, TimeUnit.MINUTES);

        testObserver.assertValueCount(90);
    }

}
