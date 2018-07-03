package blockchain.j7arsen.com.data.models.cache;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import blockchain.j7arsen.com.data.cache.DatabaseColumnInfo;

@Entity(tableName = DatabaseColumnInfo.TABLE_TICKER)
public class TickerCacheModel {

    @ColumnInfo(name = DatabaseColumnInfo.TICKER_NAME)
    @PrimaryKey
    @NonNull
    private String name;
    @ColumnInfo(name = DatabaseColumnInfo.TICKER_TIME)
    private double time;
    @ColumnInfo(name = DatabaseColumnInfo.TICKER_LAST)
    private double last;
    @ColumnInfo(name = DatabaseColumnInfo.TICKER_BUY)
    private double buy;
    @ColumnInfo(name = DatabaseColumnInfo.TICKER_SELL)
    private double sell;
    @ColumnInfo(name = DatabaseColumnInfo.TICKER_SYMBOL)
    private String symbol;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getLast() {
        return last;
    }

    public void setLast(double last) {
        this.last = last;
    }

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
