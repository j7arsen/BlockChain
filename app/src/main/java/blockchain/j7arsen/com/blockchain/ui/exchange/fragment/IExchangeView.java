package blockchain.j7arsen.com.blockchain.ui.exchange.fragment;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface IExchangeView extends MvpView{

    void initTickersTitle(String sourceTickerTitle, String targetTickerTitle);

    void updateEnterValue(double value);

    void showConvertResult(String amount);

    @StateStrategyType(SingleStateStrategy.class)
    void showConvertDataError();

}
