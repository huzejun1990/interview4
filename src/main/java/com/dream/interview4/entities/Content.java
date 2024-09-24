package com.dream.interview4.entities;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: huzejun
 * @Date: 2024/9/24 17:05
 *
 * 直播间每个观众的发言内容，封装进Content里面
 */
@Data
public class Content implements Serializable {

    //主键
    private Long id;
    //发言用户id
    private Integer userId;
    //用户发言内容
    private String content;
}
