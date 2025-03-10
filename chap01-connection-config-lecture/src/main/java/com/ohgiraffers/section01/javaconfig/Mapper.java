package com.ohgiraffers.section01.javaconfig;

import java.util.Date;
import org.apache.ibatis.annotations.Select;

public interface Mapper {
    @Select("SELECT NOW()")
    Date selectNow();
}
