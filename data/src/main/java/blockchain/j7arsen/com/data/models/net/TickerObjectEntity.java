package blockchain.j7arsen.com.data.models.net;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TickerObjectEntity implements Parcelable {

    private ArrayList<TickerEntity> mTickerEntityList;

    public ArrayList<TickerEntity> getTickerEntityList() {
        return mTickerEntityList;
    }

    public void setTickerEntityList(ArrayList<TickerEntity> mTickerEntityList) {
        this.mTickerEntityList = mTickerEntityList;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.mTickerEntityList);
    }

    public TickerObjectEntity() {
    }

    protected TickerObjectEntity(Parcel in) {
        this.mTickerEntityList = in.createTypedArrayList(TickerEntity.CREATOR);
    }

    public static final Parcelable.Creator<TickerObjectEntity> CREATOR = new Parcelable.Creator<TickerObjectEntity>() {
        @Override
        public TickerObjectEntity createFromParcel(Parcel source) {
            return new TickerObjectEntity(source);
        }

        @Override
        public TickerObjectEntity[] newArray(int size) {
            return new TickerObjectEntity[size];
        }
    };
}
