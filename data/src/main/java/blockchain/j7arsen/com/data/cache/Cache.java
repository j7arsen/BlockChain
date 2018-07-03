package blockchain.j7arsen.com.data.cache;

import android.content.Context;

import java.util.List;

import blockchain.j7arsen.com.data.models.cache.TickerCacheModel;
import io.reactivex.Single;

public class Cache implements ICache{

    private AppDatabase mAppDatabase;

    public AppDatabase getAppDatabase(Context context) {
        if (mAppDatabase == null) {
            mAppDatabase = AppDatabase.getInstance(context);
        }
        return mAppDatabase;
    }

    @Override
    public void insertAllTickers(Context context, List<TickerCacheModel> model) {
        getAppDatabase(context).tickerDao().insertAllTickers(model);
    }

    @Override
    public Single<List<TickerCacheModel>> getTickerList(Context context) {
        return getAppDatabase(context).tickerDao().getAllTickers();
    }

    @Override
    public Single<Boolean> isCached(Context context) {
        return Single.fromCallable(() -> (getAppDatabase(context).tickerDao().getTickersCount() != 0));
    }
}
