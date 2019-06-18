package saulmm.coordinatorexamples.rxjava;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Copyright (C)
 *
 * @author : gongcb
 * @date : 2019/6/17 3:48 PM
 * @desc :
 */
public class BaseSubscriber<T> implements Subscriber<T> {

    @Override
    public void onSubscribe(Subscription s) {

    }


    @Override
    public void onNext(T t) {

    }


    @Override
    public void onError(Throwable t) {

    }


    @Override
    public void onComplete() {

    }

}
