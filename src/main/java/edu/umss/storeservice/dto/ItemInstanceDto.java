/**
 * @author: Edson A. Terceros T.
 * 18
 */

package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.ItemInstance;
import org.modelmapper.ModelMapper;

public class ItemInstanceDto extends DtoBase<ItemInstance> {

    private String name;
    private String code;
    private String label;
    private String image;
    private String category;
    private Long subCategoryId;
    private String price;
    private Object[] comments = new Object[0];
    private Long id;
    private String description;
    private Boolean featured;
    private String identifier;
    private ItemDto itemDto;
    private ItemInstanceStateDto itemInstanceStateDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Object[] getComments() {
        return comments;
    }

    public void setComments(Object[] comments) {
        this.comments = comments;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ItemDto getItemDto() {
        return itemDto;
    }

    public void setItemDto(ItemDto itemDto) {
        this.itemDto = itemDto;
    }

    public ItemInstanceStateDto getItemInstanceStateDto() {
        return itemInstanceStateDto;
    }

    public void setItemInstanceStateDto(ItemInstanceStateDto itemInstanceStateDto) {
        this.itemInstanceStateDto = itemInstanceStateDto;
    }

    @Override
    public DtoBase toDto(ItemInstance itemInstance, ModelMapper mapper) {
        super.toDto(itemInstance, mapper);
        mapper.map(itemInstance.getItem(), this);
        // copy item to itemdto
        setItemDto(new ItemDto().toDto(itemInstance.getItem(), mapper));
        setImage(getItemDto().getImage());

        // copy item instance state to item instance state dto
        setItemInstanceStateDto(new ItemInstanceStateDto().toDto(itemInstance.getItemInstanceState(), mapper));
        return this;
    }
}
