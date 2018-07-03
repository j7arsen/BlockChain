package blockchain.j7arsen.com.data.models.net;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TickerEntity implements Parcelable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("15m")
    @Expose
    private double time;
    @SerializedName("last")
    @Expose
    private double last;
    @SerializedName("buy")
    @Expose
    private double buy;
    @SerializedName("sell")
    @Expose
    private double sell;
    @SerializedName("symbol")
    @Expose
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeDouble(this.time);
        dest.writeDouble(this.last);
        dest.writeDouble(this.buy);
        dest.writeDouble(this.sell);
        dest.writeString(this.symbol);
    }

    public TickerEntity() {
    }

    protected TickerEntity(Parcel in) {
        this.name = in.readString();
        this.time = in.readDouble();
        this.last = in.readDouble();
        this.buy = in.readDouble();
        this.sell = in.readDouble();
        this.symbol = in.readString();
    }

    public static final Parcelable.Creator<TickerEntity> CREATOR = new Parcelable.Creator<TickerEntity>() {
        @Override
        public TickerEntity createFromParcel(Parcel source) {
            return new TickerEntity(source);
        }

        @Override
        public TickerEntity[] newArray(int size) {
            return new TickerEntity[size];
        }
    };
}
