package blockchain.j7arsen.com.data.repository;

import java.util.concurrent.TimeUnit;

import blockchain.j7arsen.com.domain.repository.ITimerRepository;
import io.reactivex.Observable;

public class TimerRepository implements ITimerRepository {

    @Override
    public Observable<Long> getTimer(int secondCount) {
        return Observable.timer(secondCount, TimeUnit.SECONDS);
    }
}
