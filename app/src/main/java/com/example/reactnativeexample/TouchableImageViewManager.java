package com.example.reactnativeexample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewProps;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hefei on 15/11/1.
 */
public class TouchableImageViewManager extends SimpleViewManager<TouchableImageView> {
    public static final String REACT_CLASS = "RCTTouchableImageView";

    //返回的名字用于从JavaScript中引用此View type
    @Override
    public String getName(){
        return REACT_CLASS;
    }

    //实现createViewInstance，在createViewInstance里创建view，需要初始为初始状态，任何属性将会通过
    //updateView设置
    @Override
    public TouchableImageView createViewInstance(ThemedReactContext context){
        return new TouchableImageView(context);
    }

    //使用@ReactProp或@ReactPropGroup声明一些在Javascript里可以使用的setter方法
    @ReactProp(name = "src")
    public void setSrc(final TouchableImageView view, @Nullable final String src){
        new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = getBitmap(src);
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        view.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }

    @ReactProp(name = ViewProps.RESIZE_MODE)
    public void setResizeMode(TouchableImageView view, @Nullable String resizeMode){
        ImageView.ScaleType scaleType = ImageView.ScaleType.CENTER;

        if ("contain".equals(resizeMode)) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        }
        if ("cover".equals(resizeMode)) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        if ("stretch".equals(resizeMode)) {
            scaleType = ImageView.ScaleType.FIT_XY;
        }

        view.setScaleType(scaleType);
    }


    public Bitmap getBitmap(String url) {
        Bitmap bitmap = null;

        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        }catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
