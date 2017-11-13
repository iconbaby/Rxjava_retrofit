/**
  * Copyright 2017 aTool.org 
  */
package com.slkk.rxjava_retrofig.modle;
import java.util.List;

/**
 * Auto-generated: 2017-11-13 20:50:16
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool.org/json2javabean.php
 */
public class Stories {

    private List<String> images;
    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    public void setImages(List<String> images) {
         this.images = images;
     }
     public List<String> getImages() {
         return images;
     }

    public void setType(int type) {
         this.type = type;
     }
     public int getType() {
         return type;
     }

    public void setId(int id) {
         this.id = id;
     }
     public int getId() {
         return id;
     }

    public void setGaPrefix(String gaPrefix) {
         this.ga_prefix = gaPrefix;
     }
     public String getGaPrefix() {
         return ga_prefix;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

}