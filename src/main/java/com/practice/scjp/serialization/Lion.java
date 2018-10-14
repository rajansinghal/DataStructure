package com.practice.scjp.serialization;

import java.io.Serializable;
/*
 this is example which shows what happens
 when serial verson UID changes during 
 deserializaiton.
 http://javapapers.com/core-java/serialversionuid-in-java-serialization/
 */

public class Lion implements Serializable {
 
  private static final long serialVersionUID = 2L;
  //static field will never be serialize with object beside serial Version UID
  private static int age = 10;
  private String sound;
 
  public Lion(String sound) {
    this.sound = sound;
  }
 
  public String getSound() {
    return sound;
  }
 
}