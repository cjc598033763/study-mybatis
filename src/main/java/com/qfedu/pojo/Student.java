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
     int stuId;

//    public Student(int stuId, String stuNum, String stuName, String stuGender, int stuAge) {
//        this.stuId = stuId;
//        this.stuNum = stuNum;
//        this.stuName = stuName;
//        this.stuGender = stuGender;
//        this.stuAge = stuAge;
//    }

    String stuNum;
     String stuName;
    String stuGender;
     int stuAge;

}
