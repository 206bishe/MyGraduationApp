package MvpModel;



import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Webutils  {
    public final static int CONNECT_TIMEOUT = 60;
    public final static int READ_TIMEOUT = 100;
    public final static int WRITE_TIMEOUT = 60;
    public static OkHttpClient client = new OkHttpClient();
    static MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    Webutils(){

    }

    public static String postRequest(String json, String url) throws IOException {
        String respondate = null;
        RequestBody requestBody = RequestBody.create(JSON,json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        respondate = response.body().string();
        return respondate;
    }

    public static String getRequest(String json, String url) throws IOException{
        String respondate = null;
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        respondate = response.body().string();
        return respondate;
    }
}
