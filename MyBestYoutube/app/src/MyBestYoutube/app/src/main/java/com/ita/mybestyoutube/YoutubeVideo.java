package com.ita.mybestyoutube;

import java.io.Serializable;

public class YoutubeVideo implements Serializable {
    Long id;
    String title;
    String description;
    String url;
    String category;

    public YoutubeVideo(){};

    public YoutubeVideo(String title, String description, String url, String category){
        this.title = title;
        this.description = description;
        this.url = url;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "YoutubeVideo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
