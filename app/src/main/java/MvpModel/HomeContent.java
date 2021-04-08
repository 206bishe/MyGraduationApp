package MvpModel;

public class HomeContent {
    private String mTitle;
    private String mContent;
    private int mImgID;

    public HomeContent(String title, String content, int imgID){
        this.mContent = content;
        this.mTitle = title;
        this.mImgID = imgID;
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
