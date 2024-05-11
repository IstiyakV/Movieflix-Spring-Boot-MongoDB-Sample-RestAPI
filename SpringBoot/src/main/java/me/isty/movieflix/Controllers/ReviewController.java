package me.isty.movieflix.Controllers;

import me.isty.movieflix.Models.Review;
import me.isty.movieflix.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String,String> data){;
        return new ResponseEntity<Review>(reviewService.createReview(data.get("reviewBody"),data.get("imdbId")), HttpStatus.CREATED);
    }

}
