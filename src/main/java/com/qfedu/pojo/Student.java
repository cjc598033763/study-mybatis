package com.qfedu.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor  // 创建全参构造器
@NoArgsConstructor  // 创建无参构造器
@ToString  // 添加toString 方法

public class Student {
    private int stuId;
    private String stuNum;
    private String stuName;
    private String stuGender;
    private int stuAge;

}
