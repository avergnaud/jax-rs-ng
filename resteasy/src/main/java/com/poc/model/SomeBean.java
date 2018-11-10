package com.poc.model;

public class SomeBean {

    protected String id;
    protected String title;

    public SomeBean(String imdbId, String title) {
        this.id = imdbId;
        this.title = title;
    }

    public SomeBean() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        SomeBean movie = (SomeBean) o;

        if (id != null ? !id.equals(movie.id) : movie.id != null)
            return false;
        return title != null ? title.equals(movie.title) : movie.title == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
