package blockchain.j7arsen.com.data.cache;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import blockchain.j7arsen.com.data.cache.dao.TickerDao;
import blockchain.j7arsen.com.data.models.cache.TickerCacheModel;

@Database(entities = {TickerCacheModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase{

    private static volatile AppDatabase INSTANCE;

    public abstract TickerDao tickerDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "test.db")
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
