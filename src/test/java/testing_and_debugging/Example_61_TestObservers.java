package testing_and_debugging;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.concurrent.TimeUnit;

public class Example_61_TestObservers {

    @Test
    public void count_and_values_using_TestObservers() {
        Observable<Long> source = Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(5);

        TestObserver<Long> testObserver = new TestObserver<>();

        testObserver.assertNotSubscribed();
        source.subscribe(testObserver);
        testObserver.assertSubscribed();

        // Await until completes
        testObserver.awaitTerminalEvent();

        testObserver.assertNoErrors();
        testObserver.assertComplete();

        testObserver.assertValueCount(5);
        testObserver.assertValues(0l, 1l, 2l, 3l, 4l);
    }

}
