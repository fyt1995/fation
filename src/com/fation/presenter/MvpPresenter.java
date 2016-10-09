package com.fation.presenter;

import com.fation.database.greendao.TAppMvp;
import com.fation.model.MvpModel;
import com.fation.view.MvpView;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by arvin on 2016/10/3.
 */

public class MvpPresenter {
    private MvpView mvpView;
    private MvpModel mvpModel;
    public MvpPresenter(MvpView mvpView) {
        this.mvpView = mvpView;
        this.mvpModel = new MvpModel();
    }

    public void addEntity(TAppMvp tAppMvp) {
        mvpView.showProgressDialog("保存中...");
        mvpModel.addEntity(tAppMvp)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>(){
                    @Override
                    public void onCompleted() {
                        mvpView.hideProgressDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mvpView.hideProgressDialog();
                        mvpView.showMessage(e.getMessage());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        mvpView.addSuccess();
                    }
                });
    }
}
