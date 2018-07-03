package blockchain.j7arsen.com.domain.repository;

import io.reactivex.Observable;

public interface ITimerRepository {

    Observable<Long> getTimer(int secondCount);

}
