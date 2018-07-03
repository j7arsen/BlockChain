package blockchain.j7arsen.com.data.api;

import blockchain.j7arsen.com.data.models.net.TickerObjectEntity;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET(Environment.GET_TICKER)
    Single<TickerObjectEntity> getTickerList();

}
