package me.isty.movieflix.Services;

import me.isty.movieflix.Models.Movie;
import me.isty.movieflix.Repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    public MovieRepository movieRepository;


    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String id) {
        return movieRepository.findMovieByImdbId(id);
    }
}
