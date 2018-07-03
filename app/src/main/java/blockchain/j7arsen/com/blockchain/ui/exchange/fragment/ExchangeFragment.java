package blockchain.j7arsen.com.blockchain.ui.exchange.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.R;
import blockchain.j7arsen.com.blockchain.base.BaseToolbarFragment;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.utils.ResUtils;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import butterknife.BindView;

public class ExchangeFragment extends BaseToolbarFragment implements IExchangeView {

    public static final String TICKER_DETAIL_DATA = "ExchangeFragment.TICKER_DETAIL_DATA";

    @BindView(R.id.navigation_bar)
    Toolbar navigationBar;

    @Inject
    ResUtils resUtils;

    @InjectPresenter
    ExchangePresenter presenter;

    @ProvidePresenter
    ExchangePresenter provideExchangePresenter() {
        return new ExchangePresenter((TickerDomainModel) getArguments().getSerializable(TICKER_DETAIL_DATA));
    }

    public static ExchangeFragment newInstance(TickerDomainModel tickerDomainModel) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(TICKER_DETAIL_DATA, tickerDomainModel);
        ExchangeFragment exchangeFragment = new ExchangeFragment();
        exchangeFragment.setArguments(bundle);
        return exchangeFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getExchangeComponent().inject(this);
    }

    @Override
    protected void initToolbar() {
        initDefaultBackToolbar(navigationBar, () -> presenter.onBackPressed());
        setTitle(resUtils.getString(R.string.ticker_calculator_screen_title));
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_exchnage;
    }
}
