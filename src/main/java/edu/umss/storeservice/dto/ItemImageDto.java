package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.ItemImage;

public class ItemImageDto extends DtoBase<ItemImage> {
    private Long id;
    private String image;

    public ItemImageDto() {
    }

    public ItemImageDto(Long id, String image) {
        this.id = id;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
