package blockchain.j7arsen.com.data.repository.mapper;

import java.util.ArrayList;
import java.util.List;

import blockchain.j7arsen.com.data.models.cache.TickerCacheModel;
import blockchain.j7arsen.com.data.models.mapper.IModelMapper;
import blockchain.j7arsen.com.data.models.net.TickerEntity;
import blockchain.j7arsen.com.domain.model.TickerDomainModel;

public class TickerMapper implements IModelMapper<TickerCacheModel, TickerEntity, TickerDomainModel> {

    @Override
    public TickerDomainModel mapEntityToDomain(TickerEntity tickerEntity) {
        TickerDomainModel tickerDomainModel = new TickerDomainModel();
        tickerDomainModel.setName(tickerEntity.getName());
        tickerDomainModel.setTime(tickerEntity.getTime());
        tickerDomainModel.setLast(tickerEntity.getLast());
        tickerDomainModel.setBuy(tickerEntity.getBuy());
        tickerDomainModel.setSell(tickerEntity.getSell());
        tickerDomainModel.setSymbol(tickerEntity.getSymbol());
        return tickerDomainModel;
    }

    @Override
    public List<TickerDomainModel> mapEntityToDomainList(List<TickerEntity> tickerEntityList) {
        List<TickerDomainModel> list = new ArrayList<>();
        if (tickerEntityList != null && !tickerEntityList.isEmpty()) {
            for (TickerEntity tickerEntity : tickerEntityList) {
                list.add(mapEntityToDomain(tickerEntity));
            }
        }
        return list;
    }

    @Override
    public TickerCacheModel mapEntityToCache(TickerEntity tickerEntity) {
        TickerCacheModel tickerCacheModel = new TickerCacheModel();
        tickerCacheModel.setName(tickerEntity.getName());
        tickerCacheModel.setTime(tickerEntity.getTime());
        tickerCacheModel.setLast(tickerEntity.getLast());
        tickerCacheModel.setBuy(tickerEntity.getBuy());
        tickerCacheModel.setSell(tickerEntity.getSell());
        tickerCacheModel.setSymbol(tickerEntity.getSymbol());
        return tickerCacheModel;
    }

    @Override
    public List<TickerCacheModel> mapEntityToCacheList(List<TickerEntity> tickerEntityList) {
        List<TickerCacheModel> list = new ArrayList<>();
        if (tickerEntityList != null && !tickerEntityList.isEmpty()) {
            for (TickerEntity tickerEntity : tickerEntityList) {
                list.add(mapEntityToCache(tickerEntity));
            }
        }
        return list;
    }

    @Override
    public TickerDomainModel mapCacheToDomain(TickerCacheModel tickerCacheModel) {
        TickerDomainModel tickerDomainModel = new TickerDomainModel();
        tickerDomainModel.setName(tickerCacheModel.getName());
        tickerDomainModel.setTime(tickerCacheModel.getTime());
        tickerDomainModel.setLast(tickerCacheModel.getLast());
        tickerDomainModel.setBuy(tickerCacheModel.getBuy());
        tickerDomainModel.setSell(tickerCacheModel.getSell());
        tickerDomainModel.setSymbol(tickerCacheModel.getSymbol());
        return tickerDomainModel;
    }

    @Override
    public List<TickerDomainModel> mapCacheToDomainList(List<TickerCacheModel> tickerCacheModelList) {
        List<TickerDomainModel> list = new ArrayList<>();
        if (tickerCacheModelList != null && !tickerCacheModelList.isEmpty()) {
            for (TickerCacheModel tickerCacheModel : tickerCacheModelList) {
                list.add(mapCacheToDomain(tickerCacheModel));
            }
        }
        return list;
    }

    @Override
    public TickerCacheModel mapDomainToCache(TickerDomainModel tickerDomainModel) {
        TickerCacheModel tickerCacheModel = new TickerCacheModel();
        tickerCacheModel.setName(tickerDomainModel.getName());
        tickerCacheModel.setTime(tickerDomainModel.getTime());
        tickerCacheModel.setLast(tickerDomainModel.getLast());
        tickerCacheModel.setBuy(tickerDomainModel.getBuy());
        tickerCacheModel.setSell(tickerDomainModel.getSell());
        tickerCacheModel.setSymbol(tickerDomainModel.getSymbol());
        return tickerCacheModel;
    }

    @Override
    public List<TickerCacheModel> mapDomainToCacheList(List<TickerDomainModel> tickerDomainModelList) {
        List<TickerCacheModel> list = new ArrayList<>();
        if (tickerDomainModelList != null && !tickerDomainModelList.isEmpty()) {
            for (TickerDomainModel tickerDomainModel : tickerDomainModelList) {
                list.add(mapDomainToCache(tickerDomainModel));
            }
        }
        return list;
    }
}
