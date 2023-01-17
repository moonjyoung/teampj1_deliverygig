package com.deliverygig.moonjyoung.vo.account;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CustomerInfoVO {
    private Long ciSeq;
    private String ciId;
    private String ciPwd; 
    private String ciNickName;
    private String ciName;
    private String ciEmail;
    private String ciPhone;
    private LocalDate ciJoinDt;
    private String ciBirthday;
    private Integer ciGrade;
    private Long ciUiSeq;
    private Integer ciStatus;
}
