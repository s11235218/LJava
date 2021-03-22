package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    // 前端需要解析的字段 统一响应格式
    private boolean success;
    private String code;
    private String message;
    private Integer total;// 分页字段
    private Object data;
    private String stackTrace;


}
