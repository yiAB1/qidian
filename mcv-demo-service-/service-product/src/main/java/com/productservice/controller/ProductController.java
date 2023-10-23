package com.productservice.controller;

import com.commonService.comnon.Result;
import com.productservice.poji.Product;
import com.productservice.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
@Slf4j
@Api(tags = "产品管理")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/incrense")
    @ApiOperation("添加产品")
    public Result ProInsert(@RequestBody Product product) {
        log.info("添加产品 : {}" ,product);
        productService.save(product);
        return Result.success();
    }
    @DeleteMapping("/delete")
    @ApiOperation("删除产品")
    public Result ProDelete(@RequestParam Long id) {
        log.info("删除产品 : {}" ,id);
        productService.deleteProduct(id);
        return Result.success();
    }
    @PutMapping("/update")
    @ApiOperation("修改产品")
    public Result ProUpdate(@RequestBody Product product) {
        log.info("修改产品 : {}" ,product);
        productService.updateProduct(product);
        return Result.success();
    }
    @GetMapping("/{get}")
    @ApiOperation("浏览产品")
    public Result<Product> gatById(@PathVariable("get") Long id) {
        log.info("浏览产品 : {}" ,id);
        Product product = productService.getById(id);
        return Result.success(product);
    }

}
