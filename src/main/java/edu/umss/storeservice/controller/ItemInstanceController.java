/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ItemInstanceDto;
import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.service.GenericService;
import edu.umss.storeservice.service.ItemInstanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/iteminstances")
public class ItemInstanceController extends GenericController<ItemInstance, ItemInstanceDto> {
    private ItemInstanceService service;

    public ItemInstanceController(ItemInstanceService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }

    @GetMapping("/query")
    public List<ItemInstanceDto> findFiltered(
            @RequestParam(value="category", defaultValue = "") String category,
            @RequestParam(value="brand", defaultValue = "") String brand,
            @RequestParam(value="power", defaultValue = "") String power,
            @RequestParam(value="state", defaultValue = "1") String state) {
        List<ItemInstanceDto> items = toDto(this.service.findAll());

        return items.stream().filter(i -> {
            boolean response = true;
            boolean filterByCategory = false;
            boolean filterByBrand = false;
            boolean filterByPower = false;

            if (!category.equals("")) {
                filterByCategory = true;
            }

            if (!brand.equals("")) {
                filterByBrand = true;
            }

            if (!power.equals("")) {
                filterByPower = true;
            }


            if (filterByCategory && !filterByBrand && !filterByPower) {
                response = i.getItemDto().getCategory().equalsIgnoreCase(category);
            } else if (filterByCategory && filterByBrand && !filterByPower) {
                response = i.getItemDto().getCategory().equalsIgnoreCase(category)
                        && i.getName().toLowerCase().contains(brand.toLowerCase());
            } else if (filterByBrand && filterByCategory && filterByPower) {
                response = i.getItemDto().getCategory().equalsIgnoreCase(category)
                        && i.getName().toLowerCase().contains(brand.toLowerCase())
                        && i.getName().toLowerCase().contains(power.toLowerCase());
            } else if (!filterByCategory && filterByBrand && !filterByPower) {
                response = i.getName().toLowerCase().contains(brand.toLowerCase());
            } else if (!filterByCategory && filterByBrand && filterByPower) {
                response = i.getName().toLowerCase().contains(brand.toLowerCase())
                        && i.getName().toLowerCase().contains(power.toLowerCase());
            } else if (filterByCategory && !filterByBrand && filterByPower) {
                response = i.getItemDto().getCategory().toLowerCase().equalsIgnoreCase(category.toLowerCase())
                        && i.getName().toLowerCase().contains(power.toLowerCase());
            } else if (!filterByCategory && !filterByBrand && filterByPower) {
                response = i.getName().toLowerCase().contains(power.toLowerCase());
            }

            boolean stateResponse = i.getItemInstanceStateDto().getId().equals(Long.parseLong(state));
            return response && stateResponse;
        }).collect(Collectors.toList());
    }
}