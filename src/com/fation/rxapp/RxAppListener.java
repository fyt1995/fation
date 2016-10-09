package com.fation.rxapp;

/**
 * Created by arvin on 2016/10/8.
 */

public interface RxAppListener<T> {
    void onNext(T t);

    void completed();

    void error(String arg0);
}
