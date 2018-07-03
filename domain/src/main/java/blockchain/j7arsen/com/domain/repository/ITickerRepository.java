package blockchain.j7arsen.com.domain.repository;

import java.util.List;

import blockchain.j7arsen.com.domain.model.TickerDomainModel;
import io.reactivex.Single;

public interface ITickerRepository {

    Single<List<TickerDomainModel>> getTicketList(boolean isRefresh);

}
