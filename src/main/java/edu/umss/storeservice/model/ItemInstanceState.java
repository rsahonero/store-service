package edu.umss.storeservice.model;

import javax.persistence.Entity;

import edu.umss.storeservice.dto.ItemInstanceStateDto;

@Entity
public class ItemInstanceState extends ModelBase<ItemInstanceStateDto> {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}