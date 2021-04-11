package MvpPresenter;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;


public class WebUtilTest {
    private HttpURLConnection connection;
    URL url;

    public WebUtilTest() {
    }

    public HttpURLConnection getConnection() {
        try{
            url = new URL("121.4.187.26");
            connection = (HttpURLConnection) url.openConnection();
            initConnection(connection);
        }catch (IOException e){
            e.printStackTrace();
        }
        return connection;
    }

    public void initConnection(HttpURLConnection connection) throws ProtocolException {
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(8000);
        connection.setReadTimeout(8000);
    }


}
