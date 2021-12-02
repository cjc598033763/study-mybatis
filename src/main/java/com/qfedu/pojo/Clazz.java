package com.qfedu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Clazz {
    
    
    
    private List<Students> stus;

    private String classDesc;
    private String className;
    private int classId;
}
