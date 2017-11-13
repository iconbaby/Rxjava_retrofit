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
public class ZhihuRootBean {

    private String date;
    private List<Stories> stories;

    private List<TopStories> top_stories;
    public void setDate(String date) {
         this.date = date;
     }
     public String getDate() {
         return date;
     }

    public void setStories(List<Stories> stories) {
         this.stories = stories;
     }
     public List<Stories> getStories() {
         return stories;
     }

    public void setTopStories(List<TopStories> topStories) {
         this.top_stories = topStories;
     }
     public List<TopStories> getTopStories() {
         return top_stories;
     }
     public String toString(){
        return String.valueOf(top_stories.size());
     }

}