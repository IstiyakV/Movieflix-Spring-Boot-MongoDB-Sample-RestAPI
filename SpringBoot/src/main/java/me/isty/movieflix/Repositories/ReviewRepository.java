package me.isty.movieflix.Repositories;

import me.isty.movieflix.Models.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository  extends MongoRepository<Review, ObjectId> {

}
