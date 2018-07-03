package blockchain.j7arsen.com.blockchain.di.exchange;

import blockchain.j7arsen.com.blockchain.ui.exchange.ExchangeActivity;
import blockchain.j7arsen.com.blockchain.ui.exchange.ExchangeActivityPresenter;
import blockchain.j7arsen.com.blockchain.ui.exchange.fragment.ExchangeFragment;
import blockchain.j7arsen.com.blockchain.ui.exchange.fragment.ExchangePresenter;
import dagger.Subcomponent;

@ExchangeScope
@Subcomponent
public interface ExchangeComponent {

    void inject(ExchangeActivity exchangeActivity);

    void inject(ExchangeActivityPresenter exchangeActivityPresenter);

    void inject(ExchangeFragment exchangeFragment);

    void inject(ExchangePresenter exchangePresenter);

    @Subcomponent.Builder
    interface Builder {
        ExchangeComponent build();
    }

}
