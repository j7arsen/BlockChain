package blockchain.j7arsen.com.blockchain.ui.exchange.fragment;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.base.BasePresenter;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.di.app.qualifier.Global;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class ExchangePresenter extends BasePresenter<IExchangeView>{

    @Inject
    @Global
    Router router;

    private TickerDomainModel tickerDomainModel;

    public ExchangePresenter(TickerDomainModel tickerDomainModel) {
        ComponentManager.getInstance().getExchangeComponent().inject(this);
        this.tickerDomainModel = tickerDomainModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        //TODO fill view
    }

    @Override
    public void onBackPressed() {
        router.exit();
    }

}
