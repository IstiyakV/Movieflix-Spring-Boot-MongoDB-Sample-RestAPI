package me.isty.movieflix.Controllers;

import me.isty.movieflix.Models.Movie;
import me.isty.movieflix.Services.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return new ResponseEntity<List<Movie>>( movieService.getAllMovies(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovies(@PathVariable String id){
        return new ResponseEntity<Optional<Movie>>( movieService.singleMovie(id), HttpStatus.OK);
    }

}
