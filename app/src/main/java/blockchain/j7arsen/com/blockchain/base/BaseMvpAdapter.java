package blockchain.j7arsen.com.blockchain.base;

import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpDelegate;

public abstract class BaseMvpAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private MvpDelegate<? extends BaseMvpAdapter> mMvpDelegate;
    private MvpDelegate<?> mParentDelegate;
    private String mChildId;

    public BaseMvpAdapter(MvpDelegate<?> parentDelegate, String childId) {
        mParentDelegate = parentDelegate;
        mChildId = childId;

        getMvpDelegate().onCreate();
    }

    public MvpDelegate getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate<>(this);
            mMvpDelegate.setParentDelegate(mParentDelegate, mChildId);

        }
        return mMvpDelegate;
    }
}
