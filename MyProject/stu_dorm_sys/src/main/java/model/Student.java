package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Student {

    private Integer id;
    private String studentName;
    private String studentGraduateYear;
    private String studentMajor;
    private String studentEmail;
    private Integer dormId;
    private Date createTime;

    private Integer buildingId;
    private String buildingName;
    private String dormNo;
}
