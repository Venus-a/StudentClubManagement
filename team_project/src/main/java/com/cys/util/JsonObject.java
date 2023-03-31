package com.cys.util;

import lombok.Data;

import java.util.List;

@Data
public class JsonObject {
    private int code;
    private List data;
    private long total;
}
