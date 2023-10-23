package com.commonService.comnon;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data

public class Result<T> {

    private Integer code;//响应码 1 代表成功 0 代表失败
    private String message;// 相应信息 描述字符串
    private T data; // 返回的数据

    /*public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.date = object;
        result.code = 1;
        return result;
    }*/
    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 1;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 1;
        return result;
    }
    /*public static <T> Result<T> error(String message) {
        Result<T> result = new Result<T>();
        result.message = message;
        result.code = 0;
        return result;
    }*/
    public static <T> Result<T> error(String message) {
        Result result = new Result();
        result.message = message;
        result.code = 0;
        return result;
    }
   /* public static Result success() { // 增删改查 成功相应
        return new Result(1,"success",null);
    }
    public static Result success(Object date) { //查询成功相应
        return new Result(1,"success",date);
    }
    public static Result error(String message) { //失败响应
        return new Result(0,"success",null);
    }*/
}
