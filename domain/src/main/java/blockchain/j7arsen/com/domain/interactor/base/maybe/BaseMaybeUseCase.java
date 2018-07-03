package blockchain.j7arsen.com.domain.interactor.base.maybe;

import blockchain.j7arsen.com.domain.executor.IThreadExecutor;
import io.reactivex.Maybe;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableMaybeObserver;

public abstract class BaseMaybeUseCase<DATA> {

    private CompositeDisposable disposables;
    private IThreadExecutor threadExecutor;

    protected abstract Maybe<DATA> buildUseCase();

    public BaseMaybeUseCase(IThreadExecutor threadExecutor) {
        this.threadExecutor = threadExecutor;
        disposables = new CompositeDisposable();
    }

    public void execute(final DisposableMaybeObserver<DATA> disposableSubscriber) {
        final Maybe<DATA> response = getResponse();
        response.doOnSubscribe(this::addDisposable)
                .subscribeWith(disposableSubscriber);
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void addDisposable(Disposable localDisposable) {
        if (localDisposable == null) return;
        disposables.add(localDisposable);
    }

    private Maybe<DATA> getResponse() {
        return buildUseCase()
                .subscribeOn(threadExecutor.getBackgroundThread())
                .observeOn(threadExecutor.getMainThread());
    }
}
