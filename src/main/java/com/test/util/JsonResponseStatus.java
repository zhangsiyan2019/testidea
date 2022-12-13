package com.test.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum JsonResponseStatus {
    SUCCESS(200,"成功"),
    ERROR(100,"失败"),
    DELERROR(101,"删除失败"),
    NULLVALUE(2001,"查不到数据"),
    UPDATEERROR(301,"修改失败"),
    SAVEERROR(401,"新增失败")
    ;

    private Integer code;
    private String msg;
}
