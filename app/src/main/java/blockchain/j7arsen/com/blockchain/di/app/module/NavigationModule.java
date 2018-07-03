package blockchain.j7arsen.com.blockchain.di.app.module;

import javax.inject.Singleton;

import blockchain.j7arsen.com.blockchain.di.app.qualifier.Global;
import blockchain.j7arsen.com.blockchain.di.app.qualifier.Local;
import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationModule {

    private Cicerone<Router> localCicerone;
    private Cicerone<Router> globalCicerone;

    public NavigationModule() {
        localCicerone = Cicerone.create();
        globalCicerone = Cicerone.create();
    }

    @Provides
    @Singleton
    @Local
    Router provideLocalRouter() {
        return localCicerone.getRouter();
    }

    @Provides
    @Singleton
    @Local
    NavigatorHolder provideLocalNavigatorHolder() {
        return localCicerone.getNavigatorHolder();
    }

    @Provides
    @Singleton
    @Global
    Router provideGlobalRouter() {
        return globalCicerone.getRouter();
    }

    @Provides
    @Singleton
    @Global
    NavigatorHolder provideGlobalNavigatorHolder() {
        return globalCicerone.getNavigatorHolder();
    }

}
