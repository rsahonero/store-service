
/**
 * (C) 2017 Agilysys NV, LLC.  All Rights Reserved.  Confidential Information of Agilysys NV, LLC.
 */
package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Item;
import edu.umss.storeservice.model.ItemImage;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class ItemDto extends DtoBase<Item> {

    private String name;
    private String code;
    private String label;
    private List<ItemImageDto> imageList;
    private String category;
    private Long subCategoryId;
    private String price;
    private Object[] comments = new Object[0];
    private Long id;
    private String description;
    private Boolean featured;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemImageDto> getImageList() {
        return imageList;
    }

    public void setImageList(List<ItemImageDto> imageList) {
        this.imageList = imageList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public Long getId() {
        return id;
    }

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public ItemDto toDto(Item item, ModelMapper mapper) {
        super.toDto(item, mapper);
        setCategory(item.getSubCategory().getCategory().getName());
        setLabel(item.getName());
        if (item.getItemImageList() != null) {
            imageList = new ArrayList<>();
            for (ItemImage itemImage : item.getItemImageList()) {
                byte[] bytes = new byte[itemImage.getImage().length];
                for (int i = 0; i < itemImage.getImage().length; i++) {
                    bytes[i] = itemImage.getImage()[i];
                }
                String imageStr = Base64.encodeBase64String(bytes);
                ItemImageDto itemImageDto = new ItemImageDto(itemImage.getId(), imageStr);
                imageList.add(itemImageDto);
            }
        }
        setPrice("5");
        return this;
    }

}
