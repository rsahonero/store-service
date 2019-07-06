package edu.umss.storeservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.umss.storeservice.dto.ItemInstanceStateDto;
import edu.umss.storeservice.model.ItemInstanceState;
import edu.umss.storeservice.service.ItemInstanceStateService;

@RestController
@RequestMapping("/iteminstancestates")
public class ItemInstanceStateController extends GenericController<ItemInstanceState, ItemInstanceStateDto> {
    private ItemInstanceStateService service;

    public ItemInstanceStateController(ItemInstanceStateService service) {
        this.service = service;
    }

    @Override
    protected ItemInstanceStateService getService() {
        return service;
    }
}