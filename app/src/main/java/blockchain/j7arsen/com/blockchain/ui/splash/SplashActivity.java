package blockchain.j7arsen.com.blockchain.ui.splash;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.ui.main.MainActivity;
import blockchain.j7arsen.com.blockchain.R;
import blockchain.j7arsen.com.blockchain.base.BaseActivity;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.utils.screen.creator.IScreenCreator;

public class SplashActivity extends BaseActivity implements ISplashView {

    @Inject
    IScreenCreator screenCreator;

    @InjectPresenter
    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getSplashComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void openMainScreen() {
        screenCreator.startActivity(this, MainActivity.class);
        finish();
    }
}
