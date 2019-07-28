package com.yunus.bagriyanik.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "data_model")
public class DataModel extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Basic
  @Column(name = "model_name")
  private String modelName;

  @Basic
  @Column(name = "model_code")
  private String modelCode;

  public DataModel () {

  }

  public DataModel(Long id, String modelName, String modelCode) {
    this.id = id;
    this.modelName = modelName;
    this.modelCode = modelCode;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getModelCode() {
    return modelCode;
  }

  public void setModelCode(String modelCode) {
    this.modelCode = modelCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass())
      return false;
    DataModel dataModel = (DataModel) o;
    return Objects.equals(id, dataModel.id) &&
        Objects.equals(modelCode ,dataModel.modelCode) &&
        Objects.equals(modelName, dataModel.modelName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, modelCode,modelName);
  }

}
