package MvpView.graduationproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.graduationproject.R;

import java.nio.file.ClosedFileSystemException;

import MvpPresenter.MainService;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "HomeActivity";
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;;

    //声明三个布局
    private LinearLayout mLinearHome;
    private LinearLayout mLinearPublish;
    private LinearLayout mLinearMine;
    //声明三个图形按钮
    private ImageButton mImgHome;
    private ImageButton mImgPublish;
    private ImageButton mImgMine;
    //初始化三个fragment
    private Fragment mTabHome = new HomeFragment();
    private Fragment mTabPublish = new PublishFragment();
    private Fragment mTabMine = new MineFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);
        //replaceFragment(fragmentManager.findFragmentById(R.id.id_content));
        Log.d(TAG, "onCreate!");
        init();
        setSelect(0);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "onClick! ");
        switch (view.getId()){
            case R.id.id_tab_Home:
                setSelect(0);
                break;
            case R.id.id_tab_Publish:
                setSelect(1);
                break;
            case R.id.id_tab_Mine:
                setSelect(2);
                break;
        }
    }
    //初始化所有控件实例
    private void initView(){
        mLinearHome = (LinearLayout)findViewById(R.id.id_tab_Home);
        mLinearPublish = (LinearLayout)findViewById(R.id.id_tab_Publish);
        mLinearMine = (LinearLayout)findViewById(R.id.id_tab_Mine);

        mImgHome = (ImageButton)findViewById(R.id.img_Home);
        mImgPublish = (ImageButton)findViewById(R.id.img_Publish);
        mImgMine = (ImageButton)findViewById(R.id.img_Mine);
        Log.d(TAG, "initView successed!");
    }
    private void init(){
        initView();
        fragmentManager= getSupportFragmentManager();
        initFragment(fragmentTransaction);
        regEvent();
        Log.d(TAG, "init sucessed!");
    }
    //注册三个监听事件
    private void regEvent(){
        mLinearHome.setOnClickListener(this);
        mLinearPublish.setOnClickListener(this);
        mLinearMine.setOnClickListener(this);
        Log.d(TAG, "regEvent successed!");
    }

    private void initFragment(FragmentTransaction fragmentTransaction){
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.id_content,mTabHome);
        fragmentTransaction.add(R.id.id_content,mTabPublish);
        fragmentTransaction.add(R.id.id_content,mTabMine);
        fragmentTransaction.commit();
        Log.d(TAG, "initFragment successed!");
    }
    //先把所有fragment隐藏
    private void hideFragment(FragmentTransaction fragmentTransaction){
        fragmentTransaction.hide(mTabHome);
        fragmentTransaction.hide(mTabPublish);
        fragmentTransaction.hide(mTabMine);
        Log.d(TAG, "hideFragment successed!");

    }
    private void setSelect(int i){
        fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        Log.d(TAG, "setSelect: i="+i);
        switch (i){
            case 0:
                fragmentTransaction.show(mTabHome);
                break;
            case 1:
                fragmentTransaction.show(mTabPublish);
                break;
            case 2:
                fragmentTransaction.show(mTabMine);
                break;
            default:
                fragmentTransaction.show(mTabHome);
                break;
        }
        fragmentTransaction.commit();
    }
}