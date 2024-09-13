package com.dream.interview4.aopreview;

import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Service;

/**
 * @Author : huzejun
 * @Date: 2024/9/14-5:19
 */
@Service
public class PayServiceImpl implements PayService {
    @Override
    public void pay() {
        System.out.println("PayServiceImpl微信支付业务逻辑: "+ IdUtil.simpleUUID());
//        int age = 10 / 0;
    }
}
