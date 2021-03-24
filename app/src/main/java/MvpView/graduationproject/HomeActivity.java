package MvpView.graduationproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.graduationproject.R;

import MvpPresenter.MainService;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HomeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Log.d(TAG, "onClick: first BUTTON ");
                Intent intent = new Intent(this, MainService.class);
                startService(intent);
                break;
            case R.id.btn2:
                Log.d(TAG, "onClick: second BUTTON ");
                break;
            case R.id.btn3:
                Log.d(TAG, "onClick: third BUTTON ");
                break;
        }
    }
}