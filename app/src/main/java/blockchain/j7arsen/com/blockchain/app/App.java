package blockchain.j7arsen.com.blockchain.app;

import android.app.Application;

import blockchain.j7arsen.com.blockchain.di.ComponentManager;

public class App extends Application {

    public static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ComponentManager.getInstance().initAppComponent(this);
    }
}
