package blockchain.j7arsen.com.blockchain.ui.exchange.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.R;
import blockchain.j7arsen.com.blockchain.base.BaseToolbarFragment;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.utils.ResUtils;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import butterknife.BindView;
import butterknife.OnClick;

public class ExchangeFragment extends BaseToolbarFragment implements IExchangeView {

    public static final String TICKER_DETAIL_DATA = "ExchangeFragment.TICKER_DETAIL_DATA";

    @BindView(R.id.navigation_bar)
    Toolbar navigationBar;
    @BindView(R.id.tv_source_ticker_name)
    TextView tvSourceTickerName;
    @BindView(R.id.tv_target_ticker_name)
    TextView tvTargetTickerName;
    @BindView(R.id.et_enter_value)
    EditText etEnterValue;
    @BindView(R.id.et_convert_result)
    EditText etConvertResult;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListeners();
    }

    private void setListeners(){
        etEnterValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.calculate(etEnterValue.getText().toString());
            }
        });
    }

    @Override
    public void initTickersTitle(String sourceTickerTitle, String targetTickerTitle) {
        tvSourceTickerName.setText(sourceTickerTitle);
        tvTargetTickerName.setText(targetTickerTitle);
    }

    @Override
    public void showConvertResult(String amount) {
        etConvertResult.setText(amount);
    }

    @Override
    public void updateEnterValue(double value) {
        etEnterValue.setText(String.valueOf(value));
    }

    @Override
    public void showConvertDataError() {
        Toast.makeText(getActivity(), resUtils.getString(R.string.error_convert_data), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_ticker_swap)
    public void onViewClicked() {
        presenter.swapTickers();
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
