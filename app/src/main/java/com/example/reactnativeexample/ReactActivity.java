package com.example.reactnativeexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

import com.facebook.react.LifecycleState;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactRootView;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.shell.MainReactPackage;

/**
 * Created by hefei on 15/11/1.
 */
public class ReactActivity extends Activity implements DefaultHardwareBackBtnHandler{
    private ReactRootView mReactRootView;
    private ReactInstanceManager mReactInstanceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        mReactRootView = new ReactRootView(this);

        mReactInstanceManager = ReactInstanceManager.builder()
                .setApplication(getApplication())
                .setBundleAssetName("index.android.bundle")
                .setJSMainModuleName("index.android")
                .addPackage(new MyReactPackage())
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .build();

        mReactRootView.startReactApplication(mReactInstanceManager, "ReactNativeExample", null);

        setContentView(mReactRootView);
    }

    @Override
    public void invokeDefaultOnBackPressed()
    {
        super.onBackPressed();
    }


    //将Activity生命周期的回调通知给 ReactInstanceManager
    @Override
    protected void onPause(){
        super.onPause();
        if(mReactInstanceManager != null){
            mReactInstanceManager.onPause();
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(mReactInstanceManager != null){
            mReactInstanceManager.onResume(this);
        }
    }

    //将Back事件传给React Native，这样JavaScript就能处理用户点击硬件back的事件。当Javascript不处理时
    //invokeDefaultOnBackPressed方法将会调用
    @Override
    public void onBackPressed(){
        if(mReactInstanceManager != null){
            mReactInstanceManager.onBackPressed();
        }
        else {
            super.onBackPressed();
        }
    }


    //处理菜单事件，来弹出开发相关的菜单项
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent keyEvent){
        if(keyCode == KeyEvent.KEYCODE_MENU && mReactInstanceManager != null){
            mReactInstanceManager.showDevOptionsDialog();
            return false;
        }

        return super.onKeyUp(keyCode, keyEvent);
    }
}
