package blockchain.j7arsen.com.blockchain.ui.main.fragment.adapter;

import android.view.ViewGroup;

import blockchain.j7arsen.com.blockchain.R;
import blockchain.j7arsen.com.blockchain.base.adapter.AbstractRecyclerViewAdapter;
import blockchain.j7arsen.com.blockchain.ui.main.fragment.holder.TickerHolder;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;

public class TickerAdapter extends AbstractRecyclerViewAdapter<TickerDomainModel, TickerHolder> {

    public TickerAdapter() {
        super(R.layout.item_ticker);
    }

    @Override
    public TickerHolder onInitViewHolder(ViewGroup parent) {
        return new TickerHolder(inflater.inflate(resource, parent, false));
    }
}
