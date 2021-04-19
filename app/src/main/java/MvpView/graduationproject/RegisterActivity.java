package MvpView.graduationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Path;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.graduationproject.R;

import java.util.List;

import MvpPresenter.OparateData;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button loginRegister;
    private EditText loginUser;
    private EditText loginPassword;
    private EditText loginPassword1;
    private EditText loginPhone;
    private EditText university;
    private String sex;
    private String city;
    private String[] str = null;
    private TextView textView;
    private Spinner spinner;
    private List<String> dataList;
    private ArrayAdapter<String> adapter;
    private RegisterHandler handler;
    private static final String TAG = "RegisterActivity";
    private static final String URL_REGISTER = "https://121.4.187.26:8080/user/register";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        init();
    }
    private void init(){
        loginRegister = findViewById(R.id.L_register);
        loginUser = findViewById(R.id.L_user);
        loginPassword = findViewById(R.id.L_password);
        loginPassword1 = findViewById(R.id.L_password1);
        loginPhone = findViewById(R.id.L_phone);
        loginRegister.setOnClickListener(this);
        university = findViewById(R.id.university);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.L_register:
                doRegister();
                break;
        }
    }
    private void doRegister(){
        String user = loginUser.getText().toString();
        String password = loginPassword.getText().toString();
        String password1 = loginPassword1.getText().toString();
        String phone = loginPhone.getText().toString();
        String universityName = university.getText().toString();
        if (TextUtils.isEmpty(user)) {
            //用户名为空
            Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password)) {
            Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(password1)) {
            Toast.makeText(RegisterActivity.this, "请确认密码",Toast.LENGTH_SHORT).show();
        } else if (!password.equals(password1)) {
            Toast.makeText(RegisterActivity.this, "两次密码不一样，请验证", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(phone)) {
            Toast.makeText(RegisterActivity.this, "请输入电话", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(universityName)){
            Toast.makeText(RegisterActivity.this, "请输入就读大学", Toast.LENGTH_SHORT).show();
        }else {
            str= new String[]{user, password1,phone,universityName};
            Log.d(TAG, "doRegister: user: " + str[0] + "/pass: " + str[1] + "/phone :" + str[2] +"/university :"+ str[3]);
        }
        RegisterHandler rh = new RegisterHandler(Looper.myLooper());
        OparateData oparateData = new OparateData();
        oparateData.verifyRegister(str,rh,URL_REGISTER);
    }
    private final class RegisterHandler extends Handler{
        RegisterHandler(Looper looper){
            super(looper);
        }
        @Override
        public void handleMessage(@NonNull Message msg) {

            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    Toast.makeText(RegisterActivity.this, "服务器连接失败", Toast.LENGTH_SHORT).show();
                    break;
                case 1: Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                    //注册成功跳转到登录页面
                    startActivity( new Intent(RegisterActivity.this, LoginActivity.class));
                    RegisterActivity.this.finish();
                    break;
                case 2:
                    Toast.makeText(RegisterActivity.this, "用户已存在", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Log.e("input error", "url为空");
                    break;
                case 4:Toast.makeText(RegisterActivity.this, "连接超时", Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
        }
    }
}