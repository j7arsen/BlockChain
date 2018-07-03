package blockchain.j7arsen.com.blockchain.utils.executor;

import blockchain.j7arsen.com.domain.executor.IThreadExecutor;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ThreadExecutor implements IThreadExecutor {

    @Override
    public Scheduler getMainThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler getBackgroundThread() {
        return Schedulers.io();
    }
}
