package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

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

    private List<Integer> ids;
}
