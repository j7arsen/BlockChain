package blockchain.j7arsen.com.blockchain.ui.main;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.base.BasePresenter;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.di.app.qualifier.Global;
import blockchain.j7arsen.com.blockchain.utils.Screens;
import ru.terrakok.cicerone.Router;

public class MainActivityPresenter extends BasePresenter<IMainActivityView> {

    @Inject
    @Global
    Router router;

    public MainActivityPresenter() {
        ComponentManager.getInstance().getMainComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        openMainScreen();
    }

    public void openMainScreen() {
        router.newRootScreen(Screens.MAIN_SCREEN);
    }

    @Override
    public void onDestroy() {
        ComponentManager.getInstance().destroyMainComponent();
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {

    }
}
