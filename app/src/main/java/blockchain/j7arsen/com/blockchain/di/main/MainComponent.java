package blockchain.j7arsen.com.blockchain.di.main;

import blockchain.j7arsen.com.blockchain.di.main.module.MainRepositoryModule;
import blockchain.j7arsen.com.blockchain.di.main.module.MainUseCaseModule;
import blockchain.j7arsen.com.blockchain.ui.main.MainActivity;
import blockchain.j7arsen.com.blockchain.ui.main.MainActivityPresenter;
import blockchain.j7arsen.com.blockchain.ui.main.fragment.MainFragment;
import blockchain.j7arsen.com.blockchain.ui.main.fragment.MainPresenter;
import dagger.Subcomponent;

@MainScope
@Subcomponent(modules = {
        MainRepositoryModule.class,
        MainUseCaseModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

    void inject(MainActivityPresenter mainActivityPresenter);

    void inject(MainFragment mainFragment);

    void inject(MainPresenter mainPresenter);

    @Subcomponent.Builder
    interface Builder {
        MainComponent build();
    }

}
