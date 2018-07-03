package blockchain.j7arsen.com.blockchain.ui.splash;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.app.Constants;
import blockchain.j7arsen.com.blockchain.base.BasePresenter;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.domain.interactor.TimerUseCase;
import io.reactivex.observers.DisposableObserver;

@InjectViewState
public class SplashPresenter extends BasePresenter<ISplashView>{

    @Inject
    TimerUseCase timerUseCase;

    public SplashPresenter(){
        ComponentManager.getInstance().getSplashComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        startSplashTimer();
    }

    private void startSplashTimer(){
        timerUseCase.execute(Constants.SPLASH_TIMEOUT, new DisposableObserver<Long>() {
            @Override
            public void onNext(Long aLong) {
                getViewState().openMainScreen();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onDestroy() {
        ComponentManager.getInstance().destroySplashComponent();
        super.onDestroy();
    }
}
