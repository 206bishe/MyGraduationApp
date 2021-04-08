package MvpModel;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectSample {
    private JSONObject mJsonObject;

    public JSONObject createObject(String username, String password){
        try{
            mJsonObject.put("Username", username);
            mJsonObject.put("password", password);
        }catch (JSONException e){
            e.printStackTrace();
        }
        return mJsonObject;
    }
}
