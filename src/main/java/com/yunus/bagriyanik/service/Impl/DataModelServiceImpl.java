package com.yunus.bagriyanik.service.Impl;

import com.yunus.bagriyanik.dao.ModelRepository;
import com.yunus.bagriyanik.dto.DataModelDto;
import com.yunus.bagriyanik.model.DataModel;
import com.yunus.bagriyanik.service.DataModelService;
import com.yunus.bagriyanik.util.PaginationMod;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DataModelServiceImpl implements DataModelService {

  private final ModelRepository modelRepository;
  private final ModelMapper modelMapper;

  @Autowired
  public DataModelServiceImpl(ModelRepository modelRepository, ModelMapper modelMapper) {
    this.modelRepository = modelRepository;
    this.modelMapper = modelMapper;
  }


  @Override
  public DataModelDto getById(Long id) {
    DataModel dataModel = modelRepository.getOne(id);
    return modelMapper.map(dataModel, DataModelDto.class);
  }

  @Override
  public PaginationMod<DataModelDto> getAllPageable(Pageable pageable) {
    Page<DataModel> pages = modelRepository.findAll(pageable);
    PaginationMod paginationMod =new PaginationMod<DataModelDto>();
    DataModelDto[] dataModelDtos = modelMapper.map(pages.getContent(), DataModelDto[].class);
    paginationMod.setValue(pages, Arrays.asList(dataModelDtos));
    return paginationMod;
  }
}
