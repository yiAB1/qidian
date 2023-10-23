package com.productservice.mqpper;

import com.productservice.poji.Product;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductMapper {
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into yuan_01.product (product_name) " +
            "VALUES (#{productName})")
    void saveInsert(Product product);

    @Select("select * from yuan_01.product where id = #{id}")
    Product getById(Long id);

    @Update("update yuan_01.product set product_name = #{productName}")
    void updateProduct(Product product);

    //删除产品
    @Delete("delete from yuan_01.product where id = #{id}")
    void deleteById(Long id);
}
