package blockchain.j7arsen.com.blockchain.ui.main.fragment;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.List;

import blockchain.j7arsen.com.domain.model.TickerDomainModel;

public interface IMainView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showProgress();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideProgress();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showError(String error);

    @StateStrategyType(SingleStateStrategy.class)
    void showList(List<TickerDomainModel> tickerDomainModelList);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showEmptyListView();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void hideEmptyListView();

}
