package com.roytrack.monitor.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class Process extends BaseBean {

    private long userId;
    private String bookName;
    private String bookId;
    private Integer total;
    private Integer consume;

}
