package com.yunus.bagriyanik.restapi;

import com.yunus.bagriyanik.dto.DataModelDto;
import com.yunus.bagriyanik.service.Impl.DataModelServiceImpl;
import com.yunus.bagriyanik.util.ApiPaths;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPaths.DataModel.BPA)
public class DataModelController {

 private final DataModelServiceImpl dataModelServiceImpl;

  @Autowired
  public DataModelController(DataModelServiceImpl dataModelServiceImpl) {
    this.dataModelServiceImpl = dataModelServiceImpl;
  }

  @GetMapping("/{id}")
  public ResponseEntity<DataModelDto> getById(@PathVariable(value = "id",required = true) Long id){
    DataModelDto dataModelDto = dataModelServiceImpl.getById(id);
    return ResponseEntity.ok(dataModelDto);
  }

}
