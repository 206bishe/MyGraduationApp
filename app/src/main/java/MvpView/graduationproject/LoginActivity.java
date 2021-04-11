package MvpView.graduationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.graduationproject.R;

import MvpModel.HomeContent;
import MvpModel.Webutils;
import MvpPresenter.OparateData;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText username;
    private EditText password;
    private Button login;
    private Button register;
    private SharedPreferences pref;
    private CheckBox rememberPass;
    private static final String TAG = "LoginActivity";
    private static final String URL_LOGIN = "login/json";
    private LoginHandler loginHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        //绑定控件
        init();
        //记住密码
        boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            String user1 = pref.getString("user", "");
            String password1 = pref.getString("password", "");
            username.setText(user1);
            password.setText(password1);
            rememberPass.setChecked(true);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                break;
            case R.id.login:
                doLogin();
                break;
        }
    }

    private void init() {
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        username = findViewById(R.id.user);
        password = findViewById(R.id.password);
        rememberPass = findViewById(R.id.remember);
    }

    private void doLogin() {
        String[] data = null;
        String inputUser = username.getText().toString();
        String inputPswd = password.getText().toString();
        if (TextUtils.isEmpty(inputUser)) {
            Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(inputPswd)) {
            Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
        } else {
            data = new String[]{inputUser, inputPswd};
            loginHandler = new LoginHandler(Looper.myLooper());
            OparateData oparateData = new OparateData();
            oparateData.verifyLogin(data,loginHandler,URL_LOGIN);
        }
    }
    private final class LoginHandler extends Handler{

        LoginHandler(Looper looper){
            super(looper);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Toast.makeText(LoginActivity.this, "服务器连接失败", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    LoginActivity.this.finish();
                    break;
                case 2:
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Log.e("input error", "url为空");
                    break;
                case 4:
                    Toast.makeText(LoginActivity.this, "连接超时", Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
        }
    }
}