package com.roytrack.monitor.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User extends BaseBean {

    private String username;
    private String password;
    private Date  luru;
    private int status;
    private String shenfenxinxi;

}
