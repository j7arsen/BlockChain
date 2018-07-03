package blockchain.j7arsen.com.domain.interactor;

import blockchain.j7arsen.com.domain.executor.IThreadExecutor;
import blockchain.j7arsen.com.domain.interactor.base.observable.BaseObservableUseCaseWithParams;
import blockchain.j7arsen.com.domain.repository.ITimerRepository;
import io.reactivex.Observable;

public class TimerUseCase extends BaseObservableUseCaseWithParams<Long, Integer> {

  private ITimerRepository timerRepository;

    public TimerUseCase(IThreadExecutor threadExecutor, ITimerRepository timerRepository) {
        super(threadExecutor);
        this.timerRepository = timerRepository;
    }

    @Override
    protected Observable<Long> buildUseCase(Integer secondCount) {
        return timerRepository.getTimer(secondCount);
    }

}
