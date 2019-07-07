/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.model.ItemImage;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.ItemImageRepository;
import edu.umss.storeservice.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl extends GenericServiceImpl<Item> implements ItemService {
    private final ItemRepository repository;
    private final ItemImageRepository itemImageRepository;

    public ItemServiceImpl(ItemRepository repository, ItemImageRepository itemImageRepository) {
        this.repository = repository;
        this.itemImageRepository = itemImageRepository;
    }

    @Override
    protected GenericRepository<Item> getRepository() {
        return repository;
    }

    @Override
    public void setImage(Item itemPersisted, Byte[] bytes, String name) {
        ItemImage itemImage = new ItemImage();
        itemImage.setImage(bytes);
        itemImage.setName(name);
        itemImage.setType("image");
        itemImageRepository.save(itemImage);
        itemPersisted.getItemImageList().add(itemImage);
        repository.save(itemPersisted);
    }
}
