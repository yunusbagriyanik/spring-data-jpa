package com.yunus.bagriyanik.service;

import com.yunus.bagriyanik.dto.DataModelDto;
import com.yunus.bagriyanik.util.PaginationMod;
import org.springframework.data.domain.Pageable;

public interface DataModelService {

  DataModelDto getById(Long id);
  PaginationMod<DataModelDto> getAllPageable(Pageable pageable);
}
