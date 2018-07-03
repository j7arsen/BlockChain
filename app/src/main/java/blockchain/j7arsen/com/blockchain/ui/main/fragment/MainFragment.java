package blockchain.j7arsen.com.blockchain.ui.main.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.R;
import blockchain.j7arsen.com.blockchain.base.BaseToolbarFragment;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.ui.exchange.ExchangeActivity;
import blockchain.j7arsen.com.blockchain.ui.main.fragment.adapter.TickerAdapter;
import blockchain.j7arsen.com.blockchain.ui.view.EmptyView;
import blockchain.j7arsen.com.blockchain.ui.view.progress.ProgressView;
import blockchain.j7arsen.com.blockchain.utils.IBackButtonListener;
import blockchain.j7arsen.com.blockchain.utils.ResUtils;
import blockchain.j7arsen.com.blockchain.utils.Screens;
import blockchain.j7arsen.com.blockchain.utils.screen.creator.IScreenCreator;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import butterknife.BindView;

public class MainFragment extends BaseToolbarFragment implements IMainView, IBackButtonListener, ProgressView.OnRetryListener, SwipeRefreshLayout.OnRefreshListener   {

    @BindView(R.id.navigation_bar)
    Toolbar navigationBar;
    @BindView(R.id.rv_ticker)
    RecyclerView rvTicker;
    @BindView(R.id.ev_ticker)
    EmptyView evTicker;
    @BindView(R.id.srl_ticker_container)
    SwipeRefreshLayout srlTickerContainer;
    @BindView(R.id.pv_load)
    ProgressView pvLoad;

    @Inject
    ResUtils resUtils;

    @Inject
    IScreenCreator screenCreator;

    @InjectPresenter
    MainPresenter presenter;

    private TickerAdapter tickerAdapter;

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ComponentManager.getInstance().getMainComponent().inject(this);
    }

    private void initAdapters(){
        tickerAdapter = new TickerAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false);
        rvTicker.setLayoutManager(layoutManager);
        rvTicker.setAdapter(tickerAdapter);
        tickerAdapter.setClickListener(ticker -> openExchangeScreen(ticker));
    }

    private void openExchangeScreen(TickerDomainModel tickerDomainModel){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ExchangeActivity.TICKER_DETAIL_DATA, tickerDomainModel);
        screenCreator.startActivity(this, mActivity, ExchangeActivity.class, bundle, Screens.START_EXCHANGE_SCREEN);
    }

    private void setListeners() {
        pvLoad.setOnRetryListener(this);
        srlTickerContainer.setOnRefreshListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapters();
        setListeners();
    }

    @Override
    public void showProgress() {
        if (isAdded()) {
            srlTickerContainer.setVisibility(View.GONE);
            pvLoad.startLoading();
        }
    }

    @Override
    public void hideProgress() {
        if (isAdded()) {
            srlTickerContainer.setVisibility(View.VISIBLE);
            pvLoad.completeLoading();
            goneSrl();
        }
    }

    @Override
    public void showError(String error) {
        if (isAdded()) {
            srlTickerContainer.setVisibility(View.GONE);
            pvLoad.errorLoading(error);
            goneSrl();
        }
    }

    @Override
    public void showList(List<TickerDomainModel> tickerDomainModelList) {
        tickerAdapter.swap(tickerDomainModelList);
        if (!presenter.isInRestoreState(this)) {
            rvTicker.scheduleLayoutAnimation();
        } else {
            rvTicker.setLayoutAnimation(null);
        }
    }

    @Override
    public void showEmptyListView() {
        evTicker.show();
    }

    @Override
    public void hideEmptyListView() {
        evTicker.hide();
    }

    private void goneSrl() {
        srlTickerContainer.post(new Runnable() {
            @Override
            public void run() {
                if (isAdded()) {
                    srlTickerContainer.setRefreshing(false);
                }
            }
        });
    }

    @Override
    public void onRefresh() {
        presenter.loadTickerList(true);
    }

    @Override
    public void onRetry() {
        presenter.loadTickerList(false);
    }

    @Override
    protected void initToolbar() {
        initDefaultToolbar(navigationBar);
        setTitle(resUtils.getString(R.string.ticker_screen_title));
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public boolean onBackPressed() {
        presenter.onBackPressed();
        return true;
    }

}
