package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ItemImageDto;
import edu.umss.storeservice.model.ItemImage;
import edu.umss.storeservice.service.GenericService;
import edu.umss.storeservice.service.ItemImageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "item-image")
public class ItemImageController extends GenericController<ItemImage, ItemImageDto>{

    private final ItemImageService service;

    public ItemImageController(ItemImageService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}
