package blockchain.j7arsen.com.blockchain.ui.view.progress;

public class ProgressEvent {

    public static final int START_PROGRESS = 0;
    public static final int COMPLETE_PROGRESS = 1;
    public static final int ERROR_PROGRESS = 2;

    private int mStatus;
    private String mErrorMessage;
    private ProgressDialog.OnButtonClickCallbackListener mOnButtonClickCallbackListener;

    public ProgressEvent(int mStatus) {
        this.mStatus = mStatus;
    }

    public ProgressEvent(int mStatus, String mErrorMessage) {
        this.mStatus = mStatus;
        this.mErrorMessage = mErrorMessage;
    }

    public ProgressEvent(int mStatus, String mErrorMessage, ProgressDialog.OnButtonClickCallbackListener onOkButtonClickCallbackListener) {
        this.mStatus = mStatus;
        this.mErrorMessage = mErrorMessage;
        this.mOnButtonClickCallbackListener = onOkButtonClickCallbackListener;
    }

    public int getStatus() {
        return mStatus;
    }

    public void setStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String mErrorMessage) {
        this.mErrorMessage = mErrorMessage;
    }

    public ProgressDialog.OnButtonClickCallbackListener getOnButtonClickCallbackListener() {
        return mOnButtonClickCallbackListener;
    }

    public void setOnButtonClickCallbackListener(ProgressDialog.OnButtonClickCallbackListener mOnOkButtonClickCallbackListener) {
        this.mOnButtonClickCallbackListener = mOnOkButtonClickCallbackListener;
    }

}
