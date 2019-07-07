package edu.umss.storeservice.service;

import edu.umss.storeservice.dto.DtoBase;
import edu.umss.storeservice.model.ItemImage;
import edu.umss.storeservice.repository.ItemImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class ItemImageServiceImpl implements ItemImageService {

    @Autowired
    private ItemImageRepository repository;

    @Override
    public List<ItemImage> findAll() {
        return null;
    }

    @Override
    public ItemImage findById(Long id) {
        return null;
    }

    @Override
    public ItemImage save(ItemImage model) {
        return null;
    }

    @Override
    public ItemImage saveAndFlush(ItemImage model) {
        return null;
    }

    @Override
    public ItemImage patch(DtoBase dto, ItemImage model) {
        return null;
    }

    @Override
    public List<ItemImage> saveAll(Iterable<ItemImage> models) {
        return null;
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Byte[] getBytes(MultipartFile file) {
        return new Byte[0];
    }

    @Override
    public Page<ItemImage> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<ItemImage> findAll(String filter) {
        return null;
    }

    @Override
    public void saveImage(Long id, InputStream file, String name) {

    }
}