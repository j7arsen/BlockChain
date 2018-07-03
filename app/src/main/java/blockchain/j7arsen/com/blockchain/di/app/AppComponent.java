package blockchain.j7arsen.com.blockchain.di.app;

import javax.inject.Singleton;

import blockchain.j7arsen.com.blockchain.di.app.module.ApplicationModule;
import blockchain.j7arsen.com.blockchain.di.app.module.NavigationModule;
import blockchain.j7arsen.com.blockchain.di.app.module.NetModule;
import blockchain.j7arsen.com.blockchain.di.app.module.ThreadingModule;
import blockchain.j7arsen.com.blockchain.di.app.module.UtilsModule;
import blockchain.j7arsen.com.blockchain.di.splash.SplashComponent;
import dagger.Component;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ThreadingModule.class,
        UtilsModule.class,
        NetModule.class,
        NavigationModule.class})
public interface AppComponent {

    SplashComponent.Builder splashComponentBuilder();

}
