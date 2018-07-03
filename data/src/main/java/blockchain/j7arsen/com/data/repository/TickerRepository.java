package blockchain.j7arsen.com.data.repository;

import android.content.Context;

import java.util.List;

import blockchain.j7arsen.com.data.api.ApiService;
import blockchain.j7arsen.com.data.cache.ICache;
import blockchain.j7arsen.com.data.models.cache.TickerCacheModel;
import blockchain.j7arsen.com.data.models.mapper.IModelMapper;
import blockchain.j7arsen.com.data.models.net.TickerEntity;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import blockchain.j7arsen.com.domain.repository.ITickerRepository;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;

public class TickerRepository implements ITickerRepository {

    private Context context;
    private ApiService apiService;
    private ICache cache;
    private IModelMapper<TickerCacheModel, TickerEntity, TickerDomainModel> mapper;

    public TickerRepository(Context context, ApiService apiService, ICache cache, IModelMapper<TickerCacheModel, TickerEntity, TickerDomainModel> mapper) {
        this.context = context;
        this.apiService = apiService;
        this.cache = cache;
        this.mapper = mapper;
    }

    @Override
    public Single<List<TickerDomainModel>> getTicketList(boolean isRefresh) {
        if (isRefresh) {
            return getTickerListRequest();
        } else {
            return cache.isCached(context).flatMap(isCached -> {
                if (!isCached) {
                    return getTickerListRequest();
                } else {
                    return cache.getTickerList(context).map(model1 -> mapper.mapCacheToDomainList(model1));
                }
            });
        }
    }

    private Single<List<TickerDomainModel>> getTickerListRequest() {
        return apiService.getTickerList().map(domainModel -> mapper.mapEntityToCacheList(domainModel.getTickerEntityList())).flatMap(new Function<List<TickerCacheModel>, SingleSource<?>>() {
            @Override
            public SingleSource<?> apply(List<TickerCacheModel> tickerCacheModels) throws Exception {
                return new SingleSource<Object>() {
                    @Override
                    public void subscribe(SingleObserver<? super Object> observer) {
                        cache.insertAllTickers(context, tickerCacheModels);
                        observer.onSuccess(tickerCacheModels);
                    }
                };
            }
        }).map(domainModel -> mapper.mapCacheToDomainList((List<TickerCacheModel>) domainModel));
    }

}
