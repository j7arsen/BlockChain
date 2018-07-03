package blockchain.j7arsen.com.blockchain.di.app.module;

import javax.inject.Singleton;

import blockchain.j7arsen.com.blockchain.utils.executor.ThreadExecutor;
import blockchain.j7arsen.com.domain.executor.IThreadExecutor;
import dagger.Module;
import dagger.Provides;

@Module
public class ThreadingModule {

    @Provides
    @Singleton
    public IThreadExecutor provideBackgroundScheduler() {
        return new ThreadExecutor();
    }

}
