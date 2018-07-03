package blockchain.j7arsen.com.blockchain.di.splash;

import blockchain.j7arsen.com.blockchain.di.splash.module.SplashRepositoryModule;
import blockchain.j7arsen.com.blockchain.di.splash.module.SplashUseCaseModule;
import blockchain.j7arsen.com.blockchain.ui.splash.SplashActivity;
import blockchain.j7arsen.com.blockchain.ui.splash.SplashPresenter;
import dagger.Subcomponent;

@SplashScope
@Subcomponent(modules = {
        SplashRepositoryModule.class,
        SplashUseCaseModule.class})
public interface SplashComponent {

    void inject(SplashActivity splashActivity);

    void inject(SplashPresenter splashPresenter);

    @Subcomponent.Builder
    interface Builder {
        SplashComponent build();
    }

}
