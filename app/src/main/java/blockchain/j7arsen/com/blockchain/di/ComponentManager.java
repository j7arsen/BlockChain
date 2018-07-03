package blockchain.j7arsen.com.blockchain.di;

import android.support.annotation.VisibleForTesting;

import blockchain.j7arsen.com.blockchain.app.App;
import blockchain.j7arsen.com.blockchain.di.app.AppComponent;
import blockchain.j7arsen.com.blockchain.di.app.DaggerAppComponent;
import blockchain.j7arsen.com.blockchain.di.app.module.ApplicationModule;
import blockchain.j7arsen.com.blockchain.di.exchange.ExchangeComponent;
import blockchain.j7arsen.com.blockchain.di.main.MainComponent;
import blockchain.j7arsen.com.blockchain.di.splash.SplashComponent;

public class ComponentManager {

    private static ComponentManager componentManager;

    private AppComponent appComponent;
    private SplashComponent splashComponent;
    private MainComponent mainComponent;
    private ExchangeComponent exchangeComponent;

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

    public MainComponent getMainComponent() {
        if (mainComponent == null) {
            mainComponent = getAppComponent().mainComponentBuilder().build();
        }
        return mainComponent;
    }

    public ExchangeComponent getExchangeComponent() {
        if (exchangeComponent == null) {
            exchangeComponent = getAppComponent().exchangeComponentBuilder().build();
        }
        return exchangeComponent;
    }

    public void destroySplashComponent() {
        splashComponent = null;
    }

    public void destroyMainComponent() {
        mainComponent = null;
    }

    public void destroyExchangeComponent() {
        exchangeComponent = null;
    }

}
