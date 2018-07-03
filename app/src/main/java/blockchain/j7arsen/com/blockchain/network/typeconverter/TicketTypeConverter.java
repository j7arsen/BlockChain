package blockchain.j7arsen.com.blockchain.network.typeconverter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;

import blockchain.j7arsen.com.blockchain.app.ValidFields;
import blockchain.j7arsen.com.data.models.net.TickerEntity;
import blockchain.j7arsen.com.data.models.net.TickerObjectEntity;

public class TicketTypeConverter extends TypeAdapter<TickerObjectEntity> {

    public static final String TIME = "15m";
    public static final String LAST = "last";
    public static final String BUY = "buy";
    public static final String SELL = "sell";
    public static final String SYMBOL = "symbol";
    public static final String NAME = "NAME";

    @Override
    public void write(JsonWriter out, TickerObjectEntity value) throws IOException {
        out.beginObject();
        for (TickerEntity tickerEntity : value.getTickerEntityList()) {
            out.name(tickerEntity.getName()).beginObject();
            out.name(TIME).value(tickerEntity.getTime());
            out.name(LAST).value(tickerEntity.getLast());
            out.name(BUY).value(tickerEntity.getBuy());
            out.name(SELL).value(tickerEntity.getSell());
            if (!ValidFields.isNullOrEmpty(tickerEntity.getSymbol())) {
                out.name(SYMBOL).value(tickerEntity.getSymbol());
            }
            out.endObject();
        }
        out.endObject();
    }

    @Override
    public TickerObjectEntity read(JsonReader in) throws IOException {
        TickerObjectEntity tickerObjectEntity = new TickerObjectEntity();
        ArrayList<TickerEntity> tickerEntityList = new ArrayList<>();
        String name = null;
        in.beginObject();
        while (in.hasNext()) {
            TickerEntity tickerEntity = new TickerEntity();
            if(in.peek() == JsonToken.BEGIN_OBJECT){
                tickerEntity.setName(name);
                in.beginObject();
                while (in.hasNext()) {
                    parseTickerEntity(in, tickerEntity);
                }
                in.endObject();
            } else{
                name = in.nextName();
                continue;
            }
            tickerEntityList.add(tickerEntity);
        }
        in.endObject();
        tickerObjectEntity.setTickerEntityList(tickerEntityList);
        return tickerObjectEntity;
    }

    public TickerEntity parseTickerEntity(JsonReader in, TickerEntity tickerEntity) throws IOException{
        switch (in.nextName()) {
            case TIME:
                tickerEntity.setTime(in.nextDouble());
                break;
            case LAST:
                tickerEntity.setLast(in.nextDouble());
                break;
            case BUY:
                tickerEntity.setBuy(in.nextDouble());
                break;
            case SELL:
                tickerEntity.setSell(in.nextDouble());
                break;
            case SYMBOL:
                tickerEntity.setSymbol(in.nextString());
                break;

        }
        return tickerEntity;
    }

}
