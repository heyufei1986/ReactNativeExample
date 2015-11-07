//package com.example.hefei.reactnativeexample;
//
//import android.view.View;
//
//import com.facebook.react.bridge.Arguments;
//import com.facebook.react.bridge.ReactContext;
//import com.facebook.react.bridge.WritableMap;
//import com.facebook.react.uimanager.events.RCTEventEmitter;
//
///**
// * Created by hefei on 15/11/2.
// */
//class MyCustomView extends View {
//    public void onReceiveNativeEvent() {
//        WritableMap event = Arguments.createMap();
//        event.putString("message", "MyMessage");
//        ReactContext reactContext = (ReactContext)getContext();
//        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
//                getId(),
//                "topChange",
//                event);
//    }
//}