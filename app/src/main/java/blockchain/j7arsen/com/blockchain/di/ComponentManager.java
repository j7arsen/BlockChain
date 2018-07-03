package blockchain.j7arsen.com.blockchain.di;

import android.support.annotation.VisibleForTesting;

import blockchain.j7arsen.com.blockchain.app.App;
import blockchain.j7arsen.com.blockchain.di.app.AppComponent;
import blockchain.j7arsen.com.blockchain.di.app.DaggerAppComponent;
import blockchain.j7arsen.com.blockchain.di.app.module.ApplicationModule;
import blockchain.j7arsen.com.blockchain.di.splash.SplashComponent;

public class ComponentManager {

    private static ComponentManager componentManager;

    private AppComponent appComponent;
    private SplashComponent splashComponent;

    public static ComponentManager getInstance() {
        if (componentManager == null) {
            componentManager = new ComponentManager();
        }
        return componentManager;
    }

    public void initAppComponent(App app) {
        appComponent = DaggerAppComponent.builder().applicationModule(new ApplicationModule(app)).build();
    }

    @VisibleForTesting
    public void setAppComponent(AppComponent appComponent){
        this.appComponent = appComponent;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public SplashComponent getSplashComponent() {
        if (splashComponent == null) {
            splashComponent = getAppComponent().splashComponentBuilder().build();
        }
        return splashComponent;
    }

    public void destroySplashComponent() {
        splashComponent = null;
    }

}
