package com.challange.drinkcontrol.resource.exception;

import java.io.Serializable;

public class DefaultError implements Serializable {

  private Integer status;
  private String msg;

  public DefaultError(Integer status, String msg) {
    this.status = status;
    this.msg = msg;
  }

  public Integer getStatus() {
    return status;
  }

  public DefaultError setStatus(Integer status) {
    this.status = status;
    return this;
  }

  public String getMsg() {
    return msg;
  }

  public DefaultError setMsg(String msg) {
    this.msg = msg;
    return this;
  }
}
