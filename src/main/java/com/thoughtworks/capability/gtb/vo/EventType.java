package com.thoughtworks.capability.gtb.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EventType {
  UPLOAD("U"),
  DOWNLOAD("D");

  public String code;

  EventType(String code) {
    this.code = code;
  }

  public static EventType createFromCode(String code) {
    switch (code) {
      case "D":
        return DOWNLOAD;
      case "U":
        return UPLOAD;
      default:
        return null;
    }
  }
}
