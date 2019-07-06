package edu.umss.storeservice.dto;

import org.modelmapper.ModelMapper;

import edu.umss.storeservice.model.ItemInstanceState;

public class ItemInstanceStateDto extends DtoBase<ItemInstanceState> {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public ItemInstanceStateDto toDto(ItemInstanceState state, ModelMapper mapper) {
        super.toDto(state, mapper);
        return this;
    }
}