package blockchain.j7arsen.com.blockchain.utils;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import blockchain.j7arsen.com.blockchain.ui.exchange.fragment.ExchangeFragment;
import blockchain.j7arsen.com.blockchain.ui.main.fragment.MainFragment;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;

public class FragmentFactory {

    private FragmentFactory() {
    }

    public static Fragment getFragmentByKey(@NonNull final String key, final Object data) {
        switch (key) {
            case Screens.MAIN_SCREEN:
                return MainFragment.newInstance();
            case Screens.EXCHANGE_SCREEN:
                TickerDomainModel tickerDomainModel = (TickerDomainModel) data;
                return ExchangeFragment.newInstance(tickerDomainModel);
            default:
                return null;
        }
    }

}
