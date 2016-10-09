package com.fation.activity;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.fation.R;
import com.fation.entity.TAppYh;
import com.fation.presenter.LoginPresenter;
import com.fation.util.AppUtil;
import com.fation.util.SharedPreferencesUtil;
import com.fation.view.LoginView;
import com.gdth.core.widget.BaseActivity;
import com.gdth.core.annotation.view.ViewInject;
import com.gdth.utils.NetUtil;
import com.gdth.utils.TimerInstance;

public class LoginActivity extends BaseActivity implements LoginView {
    @ViewInject(id= R.id.login_btn_login, click="loginClick") Button view_login;
    @ViewInject(id=R.id.login_edit_zh) EditText view_userName;
    @ViewInject(id=R.id.login_edit_mm) EditText view_password;
    @ViewInject(id=R.id.login_checkBox)  CheckBox view_rememberMe;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_login);

        //初始化界面
        initView();
           
        init();
    }


    /**
     * 初始化
     * */
    private void initView() {
        SharedPreferences share = getSharedPreferences(AppUtil.SHARE_LOGIN_TAG, 0);
        String userName = share.getString(AppUtil.SHARE_LOGIN_USERNAME, "");

        if (!"".equals(userName)) {
            view_userName.setText(userName);
            view_rememberMe.setChecked(true);
        } else {
//        	if (AppUtil.isApkDebugable(this)) {
//        		view_userName.setText("430223196805259144");
//        		view_password.setText("111111");
//        	}
        }
        share = null;

        mLoginPresenter = new LoginPresenter(this);
    }

    private void init(){
    }

    @Override
    protected void setStatusBar() {
//        StatusBarUtil.setColor(this, AppUtil.getColor(this, R.color.black), 1);
    }

    @Override  
    protected void onStart() {  
    	TimerInstance.getInstance().stop();
        super.onStart();  
    }  
      
    //Activity从后台重新回到前台时被调用  
    @Override  
    protected void onRestart() {  
    	TimerInstance.getInstance().stop();
        super.onRestart();  
    }
  
    //Activity创建或者从被覆盖、后台重新回到前台时被调用  
    @Override  
    protected void onResume() {  
        super.onResume();  
    } 
      
    //Activity被覆盖到下面或者锁屏时被调用  
    @Override  
    protected void onPause() {
        super.onPause();  
        //有可能在执行完onPause或onStop后,系统资源紧张将Activity杀死,所以有必要在此保存持久数据  
        TimerInstance.getInstance().stop();
    }

    /**
     * 登陆
     * @param v
     */
    public void loginClick(View v){
        String userName = view_userName.getText().toString();
        if (userName.equals("")){
            this.showMessage("请输入账号");
            return;
        }

        String passWork = view_password.getText().toString();
        if (passWork.equals("")){
            this.showMessage("请输入密码");
            return;
        }

        TAppYh user = new TAppYh();
        user.setZh(userName);
        user.setMm(passWork);

        if (NetUtil.isNetworkConnected(this)){
        	mLoginPresenter.login(user);
        } else {
        	loginByLocal(user);
        }
    }

    public void loginByLocal(TAppYh user){
    	this.showProgressDialog("离线登陆...");
    	String userName = view_userName.getText().toString();
    	String passWork = view_password.getText().toString();

    	mLoginPresenter.loginByLocal(user);
    }

    /**
     * 清空账号密码
     * @param v
     */
    public void resetClick(View v) {
        view_userName.setText("");
        view_password.setText("");
    }

    @Override
    public void loginSuccess(TAppYh user){
    	
        Map<String, Object> maps = new HashMap<String, Object>();
        
        if (view_rememberMe.isChecked()) {
        	maps.put(AppUtil.SHARE_LOGIN_USERNAME, view_userName.getText().toString());
        }

//        maps.put(AppUtil.SHARE_DATA_USER, GsonUtil.getGson().toJson(user));
    	
    	SharedPreferencesUtil.saveSharePreferences(this, AppUtil.SHARE_LOGIN_TAG, maps);
    	view_password.setText("");
    	Intent intent=new Intent();
        intent.setClass(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void showProgressDialog(String msg) {
    	mDialogLoader.setMessage(msg);
    	mDialogLoader.show();
    }

    @Override
    public void hideProgressDialog() {
    	mDialogLoader.hide();
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
//        BaseToast.getInstance().ShowSystemToast(LoginActivity.this, msg);
    }
}
