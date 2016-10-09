package com.fation.activity;

import com.fation.FationApplication;
import com.fation.R;
import com.gdth.widget.BootActivity;
import com.gdth.widget.SplashActivity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * 启动页面
 * @author arvin
 *
 */
public class SplashScreenActivity extends SplashActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

//		PermissionUtil.checkPermissionFile(this);
		initService();
		initView(FationApplication.isLogin, MainActivity.class.getName(), BootActivity.class.getName(), R.drawable.ic_launcher);
	}
    
    /**
     * 启动双服务
     */
    private void initService(){
//    	boolean isStart = AppUtil.isServiceWorked(this, "com.gdth.service.BankService");
//		if(!isStart) {
//			this.startService(new Intent(this, BankService.class));
//		}
//		isStart = AppUtil.isServiceWorked(this, "com.gdth.service.HeartService");
//		if(!isStart) {
//			this.startService(new Intent(this, HeartService.class));
//		}
//		isStart = AppUtil.isServiceWorked(this, "com.gdth.service.LogService");
//		if(!isStart) {
//			this.startService(new Intent (this, LogService.class));
//		}
    }
	
	@Override
	protected void initView(boolean isLanch, String MainName, String BootName, int imgId){
		mImageView = (ImageView) findViewById(R.id.splash_img);
		mImageView.setImageResource(imgId);
		
		SharedPreferences preferences = getSharedPreferences("count", MODE_PRIVATE);
        int count = preferences.getInt("count", 0);
        count += 1;
        
        Editor editor = preferences.edit();
        editor.putInt("count", ++count);
        editor.commit();

        //判断是否已登录
		if (isLanch)
			MainName = LoginActivity.class.getName();
		
        postDelayed(BootTime, MainName);
	}
}
