package blockchain.j7arsen.com.blockchain.base;

import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.MvpView;

public abstract class BasePresenter<View extends MvpView> extends MvpPresenter<View> {

    public abstract void onBackPressed();

}
