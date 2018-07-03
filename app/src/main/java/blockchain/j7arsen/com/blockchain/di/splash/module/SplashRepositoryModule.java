package blockchain.j7arsen.com.blockchain.di.splash.module;

import blockchain.j7arsen.com.blockchain.di.splash.SplashScope;
import blockchain.j7arsen.com.data.repository.TimerRepository;
import blockchain.j7arsen.com.domain.repository.ITimerRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class SplashRepositoryModule {

    @Provides
    @SplashScope
    public ITimerRepository provideTimerRepository() {
        return new TimerRepository();
    }

}
