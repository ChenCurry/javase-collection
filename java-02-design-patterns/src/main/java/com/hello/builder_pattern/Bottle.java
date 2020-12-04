package com.hello.builder_pattern;

public class Bottle implements Packing {
 
   @Override
   public String pack() {
      return "Bottle";
   }
}