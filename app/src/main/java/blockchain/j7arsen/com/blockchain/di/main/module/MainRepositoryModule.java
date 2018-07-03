package blockchain.j7arsen.com.blockchain.di.main.module;

import android.content.Context;

import blockchain.j7arsen.com.blockchain.di.main.MainScope;
import blockchain.j7arsen.com.data.api.ApiService;
import blockchain.j7arsen.com.data.cache.Cache;
import blockchain.j7arsen.com.data.cache.ICache;
import blockchain.j7arsen.com.data.models.cache.TickerCacheModel;
import blockchain.j7arsen.com.data.models.mapper.IModelMapper;
import blockchain.j7arsen.com.data.models.net.TickerEntity;
import blockchain.j7arsen.com.data.repository.TickerRepository;
import blockchain.j7arsen.com.data.repository.mapper.TickerMapper;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import blockchain.j7arsen.com.domain.repository.ITickerRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class MainRepositoryModule {

    @Provides
    @MainScope
    public IModelMapper<TickerCacheModel, TickerEntity, TickerDomainModel> provideMainModelMapper() {
        return new TickerMapper();
    }

    @Provides
    @MainScope
    public ICache provideCache() {
        return new Cache();
    }

    @Provides
    @MainScope
    public ITickerRepository provideTickerRepository(Context context, ApiService apiService, ICache iCache, IModelMapper<TickerCacheModel, TickerEntity, TickerDomainModel> modelMapper) {
        return new TickerRepository(context, apiService, iCache, modelMapper);
    }

}
