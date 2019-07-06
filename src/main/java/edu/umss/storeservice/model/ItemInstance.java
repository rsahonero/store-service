/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ItemInstanceDto;
import org.modelmapper.ModelMapper;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ItemInstance extends ModelBase<ItemInstanceDto> {
    @OneToOne
    private Item item;
    private String identifier;

    private Boolean featured = Boolean.FALSE;

    // todo generalmente se usa BigDecimal
    private Double price;
    // todo estados AVAILABLE, SOLD, MAINTENANCE, ON_TRANSPORTATION
    @OneToOne
    private ItemInstanceState itemInstanceState;
    // todo agregar totalCost

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public ItemInstanceState getItemInstanceState() {
        return itemInstanceState;
    }

    public void setItemInstanceState(ItemInstanceState itemInstanceState) {
        this.itemInstanceState = itemInstanceState;
    }

    @Override
    public ModelBase toDomain(ItemInstanceDto element, ModelMapper mapper) {
        super.toDomain(element, mapper);
        setItem((Item) new Item().toDomain(element.getItemDto(), mapper));
        setItemInstanceState((ItemInstanceState) new ItemInstanceState().toDomain(element.getItemInstanceStateDto(), mapper));
        return this;
    }
}
