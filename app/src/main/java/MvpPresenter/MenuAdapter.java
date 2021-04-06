package MvpPresenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.graduationproject.R;

import java.util.List;

import MvpModel.HomeContent;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private List<HomeContent> mHomeContentList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mHeadImg;
        TextView mTitle;
        TextView mContent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mHeadImg = (ImageView) itemView.findViewById(R.id.content_head_img);
            mTitle = (TextView) itemView.findViewById(R.id.content_title);
            mContent = (TextView) itemView.findViewById(R.id.content_text);
        }
    }
    public MenuAdapter(List<HomeContent> homeContents){
        mHomeContentList = homeContents;
    }
    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_content,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        HomeContent homeContent = mHomeContentList.get(position);
        holder.mHeadImg.setImageResource(homeContent.getmImgID());
        holder.mTitle.setText(homeContent.getmTitle());
        holder.mTitle.setText(homeContent.getmContent());
    }

    @Override
    public int getItemCount() {
        return mHomeContentList.size();
    }
}
