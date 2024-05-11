package me.isty.movieflix.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.ArrayList;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private ObjectId id;
    public String imdbId;
    public String title;
    public String releaseDate;
    public String trailerLink;
    public ArrayList<String> genres;
    public String poster;
    public ArrayList<String> backdrops;
    @DocumentReference
    public ArrayList<Review> reviewIds;



}
