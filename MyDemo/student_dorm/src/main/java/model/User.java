package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class User {

    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Date createTime;
}
