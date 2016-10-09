package com.fation;

import com.fation.activity.SplashScreenActivity;
import com.fation.database.greendao.DaoMaster;
import com.fation.database.greendao.DaoSession;
import com.fation.util.AppUtil;
import com.gdth.core.widget.BaseApplication;

/**
 * Created by arvin on 2016/10/1.
 */

public class FationApplication  extends BaseApplication {

    public static FationApplication mInstance;

    private static DaoMaster daoMaster;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

//        SDKInitializer.initialize(this);
//        initConfig();
        if(mInstance == null) {
            mInstance = this;
            //添加页面快捷方式
            addDesktopMenu(getString(R.string.app_name), SplashScreenActivity.class.getName(), R.drawable.ic_launcher);

        }
        if (this.mFirst) {
//            String deviceId = AppUtil.getDeviceId(this);
            isLogin = true;
//            SharedPreferencesUtil.saveSharePreference(this, AppUtil.SHARE_Application, AppUtil.SHARE_DATA_Device, deviceId);
        }

//        initNotification();

//		CrashException mCrashException = CrashException.getInstance();
//        mCrashException.init(getApplicationContext());
    }

    /**
     * return DaoMaster
     *
     * @param context
     */
    public static DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            DaoMaster.OpenHelper helper = new DaoMaster.DevOpenHelper(FationApplication.mInstance.getBaseContext(), AppUtil.DB_NAME, null);
            daoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return daoMaster;
    }

    /**
     * return DaoSession
     *
     * @param context
     */
    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
