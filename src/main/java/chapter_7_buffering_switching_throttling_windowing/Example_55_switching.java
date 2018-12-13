package chapter_7_buffering_switching_throttling_windowing;

import io.reactivex.Observable;

public class Example_55_switching {

    public static void main(String[] args) {
        // ToDo difference between switchMap and map?

        Observable<String> actions = Observable.just("action_1", "action_2", "action_3");

//         Observable.just("request_1", "request_2", "request_3", "request_4", "request_5")
//             .flatMap(request -> actions.map(action -> "doing " + action + " on " + request))
//             .subscribe(System.out::println);

        Observable.just("request_1", "request_2", "request_3", "request_4", "request_5")
                .switchMap(request -> actions.map(action -> "doing " + action + " on " + request))
                .subscribe(System.out::println);
    }

}
