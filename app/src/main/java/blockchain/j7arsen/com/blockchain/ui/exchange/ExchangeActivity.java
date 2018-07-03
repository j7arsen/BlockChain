package blockchain.j7arsen.com.blockchain.ui.exchange;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.R;
import blockchain.j7arsen.com.blockchain.base.BaseContainerActvitiy;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.di.app.qualifier.Global;
import blockchain.j7arsen.com.blockchain.ui.exchange.fragment.ExchangeFragment;
import blockchain.j7arsen.com.blockchain.utils.FragmentFactory;
import blockchain.j7arsen.com.blockchain.utils.IBackButtonListener;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;

public class ExchangeActivity extends BaseContainerActvitiy implements IExchangeActivityView {

    public static final String TICKER_DETAIL_DATA = "ExchangeActivity.TICKER_DETAIL_DATA";

    @Inject
    @Global
    NavigatorHolder navigatorHolder;

    @InjectPresenter
    ExchangeActivityPresenter presenter;

    @ProvidePresenter
    ExchangeActivityPresenter provideExchangePresenter() {
        return new ExchangeActivityPresenter(getIntent().getExtras() != null ? (TickerDomainModel) getIntent().getExtras().getSerializable(TICKER_DETAIL_DATA) : null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getExchangeComponent().inject(this);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.fl_container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            return FragmentFactory.getFragmentByKey(screenKey, data);
        }

        @Override
        protected void showSystemMessage(String message) {

        }

        @Override
        protected void exit() {
            finish();
        }

        @Override
        protected void setupFragmentTransactionAnimation(Command command, Fragment currentFragment, Fragment nextFragment, FragmentTransaction fragmentTransaction) {
            if(!(nextFragment instanceof ExchangeFragment)) {
                fragmentTransaction.setCustomAnimations(R.anim.screen_in, R.anim.screen_out, R.anim.screen_back_in, R.anim.screen_back_out);
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_container);
        if (fragment != null
                && fragment instanceof IBackButtonListener
                && ((IBackButtonListener) fragment).onBackPressed()) {
            return;
        } else {
            super.onBackPressed();
        }
    }

}
