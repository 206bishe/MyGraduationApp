package MvpPresenter;


import android.os.Handler;

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
                        
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
