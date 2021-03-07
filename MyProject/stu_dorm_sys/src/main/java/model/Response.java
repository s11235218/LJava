package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {

    private boolean success;
    private String code;
    private String message;
    private Integer total;// 分页字段
    private Object data;
    private String stackTrace;


}
