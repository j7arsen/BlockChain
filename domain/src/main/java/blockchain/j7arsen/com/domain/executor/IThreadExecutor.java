package blockchain.j7arsen.com.domain.executor;

import io.reactivex.Scheduler;

public interface IThreadExecutor {

    Scheduler getMainThread();

    Scheduler getBackgroundThread();

}
