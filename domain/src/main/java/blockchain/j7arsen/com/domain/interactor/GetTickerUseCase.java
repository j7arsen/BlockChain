package blockchain.j7arsen.com.domain.interactor;

import java.util.List;

import blockchain.j7arsen.com.domain.executor.IThreadExecutor;
import blockchain.j7arsen.com.domain.interactor.base.single.BaseSingleUseCaseWithParams;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import blockchain.j7arsen.com.domain.repository.ITickerRepository;
import io.reactivex.Single;

public class GetTickerUseCase extends BaseSingleUseCaseWithParams<List<TickerDomainModel>, Boolean> {

    private ITickerRepository tickerRepository;

    public GetTickerUseCase(IThreadExecutor threadExecutor, ITickerRepository tickerRepository) {
        super(threadExecutor);
        this.tickerRepository = tickerRepository;
    }

    @Override
    protected Single<List<TickerDomainModel>> buildUseCase(Boolean isRefresh) {
        return tickerRepository.getTicketList(isRefresh);
    }
}
