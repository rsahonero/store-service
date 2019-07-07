  
package edu.umss.storeservice.model;

import javax.persistence.*;

@Entity
public class ItemImage extends ModelBase {

    private String name;
    @Lob
    private Byte[] image;
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "image_item_id")
    private Item item;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}