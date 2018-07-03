package blockchain.j7arsen.com.blockchain.ui.main.fragment;

import com.arellomobile.mvp.InjectViewState;

import java.util.List;

import javax.inject.Inject;

import blockchain.j7arsen.com.blockchain.base.BasePresenter;
import blockchain.j7arsen.com.blockchain.di.ComponentManager;
import blockchain.j7arsen.com.blockchain.di.app.qualifier.Global;
import blockchain.j7arsen.com.blockchain.utils.error.ErrorHandler;
import blockchain.j7arsen.com.domain.interactor.GetTickerUseCase;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import io.reactivex.observers.DisposableSingleObserver;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainPresenter extends BasePresenter<IMainView>{

    @Inject
    @Global
    Router router;

    @Inject
    ErrorHandler errorHandler;

    @Inject
    GetTickerUseCase getTickerUseCase;

    public MainPresenter() {
        ComponentManager.getInstance().getMainComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        loadTickerList(false);
    }

    public void loadTickerList(boolean isRefresh) {
        getTickerUseCase.execute(isRefresh, new DisposableSingleObserver<List<TickerDomainModel>>() {
            @Override
            protected void onStart() {
                if (!isRefresh) {
                    getViewState().hideEmptyListView();
                    getViewState().showProgress();
                }
            }

            @Override
            public void onSuccess(List<TickerDomainModel> tickerDomainModelList) {
                getViewState().showList(tickerDomainModelList);
                if (tickerDomainModelList == null || tickerDomainModelList.isEmpty()) {
                    getViewState().showEmptyListView();
                }
                getViewState().hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                getViewState().showError(errorHandler.getError(e));
            }
        });
    }

    @Override
    public void onBackPressed() {
        router.exit();
    }

}
