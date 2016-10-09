package com.fation.model;

import com.fation.FationApplication;
import com.fation.database.greendao.DaoSession;
import com.fation.database.greendao.TAppMvp;
import com.fation.database.greendao.TAppMvpDao;

import java.util.List;

import de.greenrobot.dao.query.QueryBuilder;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by arvin on 2016/10/3.
 */

public class MvpModel {
    public Observable<Long> addEntity(final TAppMvp tAppMvp) {

        final TAppMvp mTAppMvp = tAppMvp;

        return  Observable.create(new Observable.OnSubscribe<Long>() {

            @Override
            public void call(final Subscriber<? super Long> subscriber) {
                final DaoSession session = FationApplication.getDaoSession();
                session.runInTx(new Runnable() {

                    @Override
                    public void run() {
                        boolean re = true;
                        Exception ex = null;
                        TAppMvpDao dao = session.getTAppMvpDao();

                        try {
                            dao.insertInTx(mTAppMvp);
                        } catch(Exception e) {
                            ex = e;
                            re = false;
                        }
                        if (re){
                            subscriber.onNext(mTAppMvp.getId());
                            subscriber.onCompleted();
                        } else{
                            subscriber.onError(ex);
                        }
                    }
                });
            }
        });
    }

    public Observable<TAppMvp> editEntity(TAppMvp tAppMvp) {

        final TAppMvp mTAppMvp = tAppMvp;

        return  Observable.create(new Observable.OnSubscribe<TAppMvp>() {

            @Override
            public void call(final Subscriber<? super TAppMvp> subscriber) {
                final DaoSession session = FationApplication.getDaoSession();
                session.runInTx(new Runnable() {

                    @Override
                    public void run() {
                        boolean re = true;
                        Exception ex = null;
                        TAppMvpDao dao = session.getTAppMvpDao();

                        try {
                            dao.insertInTx(mTAppMvp);
                        } catch(Exception e) {
                            ex = e;
                            re = false;
                        }
                        if (re){
                            subscriber.onNext(mTAppMvp);
                            subscriber.onCompleted();
                        } else{
                            subscriber.onError(ex);
                        }
                    }
                });
            }
        });
    }

    public Observable<List<TAppMvp>> getEntitys(TAppMvp tAppMvp) {
        return  Observable.create(new Observable.OnSubscribe<List<TAppMvp>>() {

            @Override
            public void call(Subscriber<? super List<TAppMvp>> subscriber) {
                TAppMvpDao dao = FationApplication.getDaoSession().getTAppMvpDao();
                QueryBuilder<TAppMvp> qb = dao.queryBuilder();

                qb.where(TAppMvpDao.Properties.Title.like("")).orderDesc(TAppMvpDao.Properties.Id);

                List<TAppMvp> mList = qb.list();
                if (mList == null){
                    subscriber.onError(null);
                } else {
                    subscriber.onNext(mList);
                    subscriber.onCompleted();
                }
            }
        });
    }

    public Observable<Long> deleteEntity(final Long key) {
        return  Observable.create(new Observable.OnSubscribe<Long>() {

            @Override
            public void call(final Subscriber<? super Long> subscriber) {
                final DaoSession session = FationApplication.getDaoSession();
                session.runInTx(new Runnable() {

                    @Override
                    public void run() {
                        boolean re = true;
                        Exception ex = null;
                        TAppMvpDao dao = session.getTAppMvpDao();

                        try {
                            dao.deleteByKey(key);
                        } catch(Exception e) {
                            ex = e;
                            re = false;
                        }
                        if (re){
                            subscriber.onNext(key);
                            subscriber.onCompleted();
                        } else{
                            subscriber.onError(ex);
                        }
                    }
                });
            }
        });
    }
}
