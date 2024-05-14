package com.develhope.proveSpringBoot;

@org.springframework.stereotype.Service
public class Service {

    public String reverseString(String name) {
        if (name == null || name.isEmpty()) {
            return "";
        }
        return new StringBuilder(name).reverse().toString();
    }
}
