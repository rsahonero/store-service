/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.Category;
import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.model.SubCategory;
import edu.umss.storeservice.repository.ItemRepository2;
import org.springframework.stereotype.Service;

@Service
public class ItemService2 {
    private ItemRepository2 itemRepository2;
    private SubCategoryService subCategoryService;

    public ItemService2(ItemRepository2 itemRepository2, SubCategoryService subCategoryService) {
        this.itemRepository2 = itemRepository2;
        this.subCategoryService = subCategoryService;
    }

    public Item save(Item item, String subCategoryName) {
        SubCategory model = new SubCategory();
        model.setName(subCategoryName);
        model.setCode(subCategoryName);
        Category category = new Category();
        category.setId(1L);
        model.setCategory(category);
        SubCategory subCategory = subCategoryService.save(model);
        item.setSubCategory(subCategory);
        Item persistedItem = itemRepository2.save(item);
        return persistedItem;
    }
}
