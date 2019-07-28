package com.yunus.bagriyanik.dao;

import com.yunus.bagriyanik.model.DataModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<DataModel, Long> {

  DataModel getByModelCode(String modelCode);
  DataModel getByModelName(String modelName);
  Page<DataModel> findAll(Pageable pageable);

}
