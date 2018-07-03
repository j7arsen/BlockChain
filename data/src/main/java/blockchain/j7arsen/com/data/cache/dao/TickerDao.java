package blockchain.j7arsen.com.data.cache.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import blockchain.j7arsen.com.data.cache.DatabaseColumnInfo;
import blockchain.j7arsen.com.data.models.cache.TickerCacheModel;
import io.reactivex.Single;

@Dao
public interface TickerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllTickers(List<TickerCacheModel> tickerCacheModels);

    @Query("SELECT * FROM " + DatabaseColumnInfo.TABLE_TICKER)
    Single<List<TickerCacheModel>> getAllTickers();

    @Query("SELECT COUNT(*) FROM " + DatabaseColumnInfo.TABLE_TICKER + "")
    int getTickersCount();

}
