package MvpPresenter;


import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import MvpModel.JsonObjectSample;
import MvpModel.Webutils;

public class OparateData {

    public void verifyLogin(final String[] stringArray,final Handler mh, final String url){
        if (url == null){
            mh.sendEmptyMessage(3);
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String responseData = Webutils.postRequest(JsonObjectSample.stringTojson(stringArray),url);
                        JSONObject jsonObject = new JSONObject(responseData);
                        if (jsonObject.get("success").equals("true")){
                            mh.sendEmptyMessage(1);
                        }else if (jsonObject.get("success").equals("false")){
                            mh.sendEmptyMessage(2);
                        };
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    public void verifyRegister(final String[] stringArray,final Handler mh,final String url){
        if (url == null){
            mh.sendEmptyMessage(3);
        } else {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String responseData = Webutils.postReqForRegister(JsonObjectSample.stringTojson(stringArray),url);
                        JSONObject jsonObject = new JSONObject(responseData);
                        if (jsonObject.get("success").equals("true")){
                            mh.sendEmptyMessage(1);
                        }else if (jsonObject.get("success").equals("false")){
                            mh.sendEmptyMessage(2);
                        };
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
