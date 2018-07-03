package blockchain.j7arsen.com.blockchain.ui.main.fragment.holder;

import android.view.View;
import android.widget.TextView;

import blockchain.j7arsen.com.blockchain.R;
import blockchain.j7arsen.com.blockchain.base.adapter.AbstractHolder;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import butterknife.BindView;

public class TickerHolder extends AbstractHolder<TickerDomainModel> {

    @BindView(R.id.tv_ticker_name)
    TextView tvTickerName;
    @BindView(R.id.tv_ticker_sell)
    TextView tvTickerSell;
    @BindView(R.id.tv_ticker_buy)
    TextView tvTickerBuy;

    public TickerHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bind() {
        tvTickerName.setText(model.getName());
        tvTickerSell.setText(model.getSell() + " " + model.getSymbol());
        tvTickerBuy.setText(model.getBuy() + " " + model.getSymbol());
    }
}
