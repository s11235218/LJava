package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Building {

    private Integer id;  // 宿舍楼id
    private String buildingName;  // 宿舍楼名
    private String buildingDesc;
    private Date createTime;
}
