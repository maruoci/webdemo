package com.bluesky.web.util;

import org.apache.commons.collections.MapUtils;

import java.util.Collection;
import java.util.Map;

public final class CollectionUtil {

    public static boolean isEmpty(Collection<?> collection) {
        return CollectionUtil.isEmpty(collection);
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return MapUtils.isEmpty(map);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}