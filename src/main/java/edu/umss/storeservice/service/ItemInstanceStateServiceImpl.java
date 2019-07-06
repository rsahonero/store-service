package edu.umss.storeservice.service;

import edu.umss.storeservice.model.ItemInstanceState;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.ItemInstanceStateRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemInstanceStateServiceImpl extends GenericServiceImpl<ItemInstanceState> implements ItemInstanceStateService {
    private final ItemInstanceStateRepository repository;

    public ItemInstanceStateServiceImpl(ItemInstanceStateRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<ItemInstanceState> getRepository() {
        return repository;
    }
    
}
