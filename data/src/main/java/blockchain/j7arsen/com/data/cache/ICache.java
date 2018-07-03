package blockchain.j7arsen.com.data.cache;

import android.content.Context;

import java.util.List;

import blockchain.j7arsen.com.data.models.cache.TickerCacheModel;
import io.reactivex.Single;

public interface ICache {

    void insertAllTickers(Context context, List<TickerCacheModel> model);

    Single<List<TickerCacheModel>> getTickerList(Context context);

    Single<Boolean> isCached(Context context);

}
