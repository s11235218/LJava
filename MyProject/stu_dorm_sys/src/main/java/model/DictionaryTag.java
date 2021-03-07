package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class DictionaryTag {

    private Integer id;
    private String dictionaryTagKey;
    private String dictionaryTagValue;
    private String dictionaryTagDesc;
    private Integer dictionaryId;
    private Date createTime;
}
