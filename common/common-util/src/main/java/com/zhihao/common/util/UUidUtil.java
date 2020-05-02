package com.zhihao.common.util;

import java.util.UUID;

public class UUidUtil {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
