package com.zsoft.cra.service.util;

import com.zsoft.cra.domain.Authority;

import java.util.Set;
import java.util.stream.Collectors;

public final class ConverterUtil {

    private ConverterUtil() {
    }

    public static Set<Authority> authoritiesFromStrings(Set<String> strings) {
        return strings.stream().map(string -> {
            Authority auth = new Authority();
            auth.setName(string);
            return auth;
        }).collect(Collectors.toSet());
    }
}
