package com.imooc.product.dataobject;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {
  @Id
  private Integer categoryId;
  private String categoryName;
  private Integer categoryType;
  private Date createTime;
  private Date updateTime;


}
