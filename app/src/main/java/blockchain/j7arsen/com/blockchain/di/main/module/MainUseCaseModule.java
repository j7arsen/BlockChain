package blockchain.j7arsen.com.blockchain.di.main.module;

import blockchain.j7arsen.com.blockchain.di.main.MainScope;
import blockchain.j7arsen.com.domain.executor.IThreadExecutor;
import blockchain.j7arsen.com.domain.interactor.GetTickerUseCase;
import blockchain.j7arsen.com.domain.repository.ITickerRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class MainUseCaseModule {

    @Provides
    @MainScope
    public GetTickerUseCase provideTickerUseCase(ITickerRepository tickerRepository, IThreadExecutor threadExecutor) {
        return new GetTickerUseCase(threadExecutor, tickerRepository);
    }

}
