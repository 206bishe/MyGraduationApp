package MvpView.graduationproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graduationproject.R;

import java.util.ArrayList;
import java.util.List;

import MvpModel.HomeContent;
import MvpPresenter.MenuAdapter;

public class HomeFragment extends Fragment {
    private List<HomeContent> mHomeContentList = new ArrayList<>();
    private View view;
    public RecyclerView mContentRecycleView;
    MenuAdapter mMenuAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab_home,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mContentRecycleView = view.findViewById(R.id.content_recycle);
        initContent();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mContentRecycleView.setLayoutManager(linearLayoutManager);
        MenuAdapter menuAdapter = new MenuAdapter(mHomeContentList);
        mContentRecycleView.setAdapter(menuAdapter);
    }

    public void initContent(){
        HomeContent homeContent = new HomeContent("Title","Content",R.drawable.smile);
        HomeContent homeContent1 = new HomeContent("Title","Content",R.drawable.smile);
        HomeContent homeContent2 = new HomeContent("Title","Content",R.drawable.smile);
        HomeContent homeContent3 = new HomeContent("Title","Content",R.drawable.smile);
        HomeContent homeContent4 = new HomeContent("Title","Content",R.drawable.smile);
        HomeContent homeContent5 = new HomeContent("Title","Content",R.drawable.smile);
        HomeContent homeContent6 = new HomeContent("Title","Content",R.drawable.smile);
        HomeContent homeContent7 = new HomeContent("Title","Content",R.drawable.smile);
        HomeContent homeContent8 = new HomeContent("Title","Content",R.drawable.smile);
        mHomeContentList.add(homeContent);
        mHomeContentList.add(homeContent1);
        mHomeContentList.add(homeContent2);
        mHomeContentList.add(homeContent3);
        mHomeContentList.add(homeContent4);
        mHomeContentList.add(homeContent5);
        mHomeContentList.add(homeContent6);
        mHomeContentList.add(homeContent7);
        mHomeContentList.add(homeContent8);
    }
}
