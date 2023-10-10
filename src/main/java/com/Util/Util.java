package com.Util;

import java.util.Objects;
import java.util.stream.Stream;

public class Util {
    public static boolean isEmpty(String name) {
        return  (name.isEmpty() || isNull(name));
    }

    public static boolean isNull(Object... obj) {
        return Stream.of(obj).anyMatch(Objects::isNull);
    }
    public static <T extends Number> boolean isNegative(T value) {
        double val = value.doubleValue();
        return val < 0;
    }
}
