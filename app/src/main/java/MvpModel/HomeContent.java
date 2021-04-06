package MvpModel;

public class HomeContent {
    private String mTitle;
    private String mContent;
    private int mImgID;

    HomeContent(String title, String content){
        this.mContent = content;
        this.mTitle = title;
    }
    public String getmTitle() {
        return mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public int getmImgID() {
        return mImgID;
    }
}
