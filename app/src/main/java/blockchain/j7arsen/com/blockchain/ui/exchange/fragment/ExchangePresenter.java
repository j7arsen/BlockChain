package blockchain.j7arsen.com.blockchain.ui.exchange.fragment;

import com.arellomobile.mvp.InjectViewState;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.base.BasePresenter;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.di.app.qualifier.Global;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class ExchangePresenter extends BasePresenter<IExchangeView> {

    private static final String BTC_NAME = "BTC";

    @Inject
    @Global
    Router router;

    private TickerDomainModel tickerDomainModel;

    private String sourceTickerName;
    private String targetTickerName;


    public ExchangePresenter(TickerDomainModel tickerDomainModel) {
        ComponentManager.getInstance().getExchangeComponent().inject(this);
        this.tickerDomainModel = tickerDomainModel;
        this.sourceTickerName = tickerDomainModel.getName();
        this.targetTickerName = BTC_NAME;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().initTickersTitle(sourceTickerName, targetTickerName);
    }

    public void swapTickers() {
        if (sourceTickerName.equalsIgnoreCase(BTC_NAME)) {
            sourceTickerName = tickerDomainModel.getName();
            targetTickerName = BTC_NAME;
        } else {
            sourceTickerName = BTC_NAME;
            targetTickerName = tickerDomainModel.getName();
        }
        getViewState().initTickersTitle(sourceTickerName, targetTickerName);
        getViewState().updateEnterValue(0);
    }

    public void calculate(String value) {
        try {
            if (Double.parseDouble(value) != 0) {
                BigDecimal valueDec = new BigDecimal(value.trim());
                if (targetTickerName.equalsIgnoreCase(tickerDomainModel.getName())) {
                    BigDecimal sellDec = new BigDecimal(tickerDomainModel.getSell());
                    getViewState().showConvertResult(valueDec.multiply(sellDec).setScale(8, RoundingMode.HALF_UP).toString());
                } else {
                    BigDecimal buyDec = new BigDecimal(tickerDomainModel.getSell());
                    getViewState().showConvertResult(valueDec.divide(buyDec, 8, RoundingMode.HALF_UP).toString());
                }
            } else {
                getViewState().showConvertResult(String.valueOf(0));
            }
        } catch (NumberFormatException e) {
            getViewState().showConvertResult(String.valueOf(0));
        }
    }

    @Override
    public void onBackPressed() {
        router.exit();
    }

}
