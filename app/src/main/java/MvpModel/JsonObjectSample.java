package MvpModel;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JsonObjectSample {
    private static final String TAG = "JsonObjectSample";
    public static JSONObject createJson(String username, String password){
        JSONObject mJsonObject = new JSONObject();
        try{
            mJsonObject.put("Username", username);
            mJsonObject.put("password", password);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return mJsonObject;
    }

    /**
     *
     * @param stringArray  将string数组转成json格式字符串
     * @return
     */
    public static String stringTojson(String[] stringArray){
        JSONObject jsonObject = null;
        if(stringArray == null) {
            return null;
        }
        jsonObject = new JSONObject();
        try {
            jsonObject.put("username",stringArray[0]);
            jsonObject.put("password",stringArray[1]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "after convert:  " + String.valueOf(jsonObject));
        return String.valueOf(jsonObject);
    }

    public static String regStringToJson(String[] stringArray){
        JSONObject jsonObject = null;
        if(stringArray == null) {
            return null;
        }
        jsonObject = new JSONObject();
        try {
            jsonObject.put("username",stringArray[0]);
            jsonObject.put("password",stringArray[1]);
            jsonObject.put("phone",stringArray[2]);
            jsonObject.put("university",stringArray[3]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return String.valueOf(jsonObject);
    }






}
