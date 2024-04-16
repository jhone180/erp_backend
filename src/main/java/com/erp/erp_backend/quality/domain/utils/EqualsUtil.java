package com.erp.erp_backend.quality.domain.utils;

public class EqualsUtil {
    public static Long equalsLongOrNull(Long a, Long b) {
        return a.equals(b) || b == null ? a : b;
    }
}
