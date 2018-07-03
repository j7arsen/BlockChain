package blockchain.j7arsen.com.blockchain.di.app.module;

import android.content.Context;

import javax.inject.Singleton;

import blockchain.j7arsen.com.blockchain.utils.AppUtils;
import blockchain.j7arsen.com.blockchain.utils.ResUtils;
import blockchain.j7arsen.com.blockchain.utils.screen.creator.IScreenCreator;
import blockchain.j7arsen.com.blockchain.utils.screen.creator.ScreenCreator;
import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {

    @Provides
    @Singleton
    public ResUtils provideResUtils(Context context) {
        return new ResUtils(context);
    }

    @Provides
    @Singleton
    public AppUtils provideUtils() {
        return new AppUtils();
    }

    @Provides
    @Singleton
    public IScreenCreator provideScreenCreator() {
        return new ScreenCreator();
    }

}
