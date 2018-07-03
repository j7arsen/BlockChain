package blockchain.j7arsen.com.blockchain.di.splash.module;

import blockchain.j7arsen.com.blockchain.di.splash.SplashScope;
import blockchain.j7arsen.com.domain.executor.IThreadExecutor;
import blockchain.j7arsen.com.domain.interactor.TimerUseCase;
import blockchain.j7arsen.com.domain.repository.ITimerRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class SplashUseCaseModule {

    @Provides
    @SplashScope
    public TimerUseCase provideTimerUseCase(ITimerRepository timerRepository, IThreadExecutor threadExecutor) {
        return new TimerUseCase(threadExecutor, timerRepository);
    }

}
