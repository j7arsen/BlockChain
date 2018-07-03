package blockchain.j7arsen.com.blockchain.ui.exchange;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.base.BasePresenter;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.di.app.qualifier.Global;
import blockchain.j7arsen.com.blockchain.utils.Screens;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import ru.terrakok.cicerone.Router;

public class ExchangeActivityPresenter extends BasePresenter<IExchangeActivityView> {

    @Inject
    @Global
    Router router;

    private TickerDomainModel tickerDomainModel;

    public ExchangeActivityPresenter(TickerDomainModel tickerDomainModel) {
        ComponentManager.getInstance().getExchangeComponent().inject(this);
        this.tickerDomainModel = tickerDomainModel;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        openMainScreen();
    }

    public void openMainScreen() {
        router.newRootScreen(Screens.EXCHANGE_SCREEN, tickerDomainModel);
    }

    @Override
    public void onDestroy() {
        ComponentManager.getInstance().destroyExchangeComponent();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

    }

}
