/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ItemDto;
import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.service.ItemService2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/items")
public class ItemController {
    private ItemService2 itemService2;

    public ItemController(ItemService2 itemService2) {
        this.itemService2 = itemService2;
    }

    @PostMapping
    public ItemDto save(@RequestBody ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setCode(itemDto.getCode());

        String subCategoryName = itemDto.getSubCategoryName();
        Item itemPersisted = itemService2.save(item, subCategoryName);
        ItemDto itemDtoResponse = new ItemDto();
        itemDtoResponse.setName(itemPersisted.getName());
        itemDtoResponse.setCode(itemPersisted.getCode());
        return itemDtoResponse;
    }

}