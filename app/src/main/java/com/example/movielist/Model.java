package com.example.movielist;
import java.util.List;


public class Model {
    private boolean adult;
    public String backdrop_path;
    private List<Integer> genre_ids;
    private long id;
    private String original_language;
    private String original_title;
    private String overview;
    private double popularity;
    public String poster_path;
    public String release_date;
    public String title;
    private boolean video;
    private double vote_average;
    private int vote_count;

    @Override
    public String toString() {
        return "Movie{" +
                "adult=" + adult +
                ", backdrop_path='" + backdrop_path + '\'' +
                ", genre_ids=" + genre_ids +
                ", id=" + id +
                ", original_language='" + original_language + '\'' +
                ", original_title='" + original_title + '\'' +
                ", overview='" + overview + '\'' +
                ", popularity=" + popularity +
                ", poster_path='" + poster_path + '\'' +
                ", release_date='" + release_date + '\'' +
                ", title='" + title + '\'' +
                ", video=" + video +
                ", vote_average=" + vote_average +
                ", vote_count=" + vote_count +
                '}';
    }
}
