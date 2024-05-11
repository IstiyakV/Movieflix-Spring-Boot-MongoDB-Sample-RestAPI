import { useEffect, useRef } from 'react';
import api from '../../api/axiosConfig';
import { useParams } from 'react-router-dom';
import { Container, Row, Col } from 'react-bootstrap';
import ReviewForm from '../reviewForm/ReviewForm';

import React from 'react'

const Reviews = ({ getMovieData, movie, reviews, setReviews }) => {

    const revText = useRef();
    let params = useParams();
    const movieId = params.movieId;

    useEffect(() => {
        getMovieData(movieId);
    }, [])

    const addReview = async (e) => {
        e.preventDefault();

        const rev = revText.current;

        try {
            const response = await api.post("/api/v1/reviews", { reviewBody: rev.value, imdbId: movieId });

            // const updatedReviews = [...reviews, {body:rev.value}];

            // rev.value = "";

            // setReviews(updatedReviews);

            const newReview = response.data;

            // Ensure reviews is an array or initialize it as an empty array
            const updatedReviews = Array.isArray(reviews) ? [...reviews, newReview] : [newReview];

            // Update the state of reviews with the new review
            setReviews(updatedReviews);

            // Clear the input field
            rev.value = "";
            window.location.reload();
        }
        catch (err) {
            console.error(err);
        }




    }

    return (
        <Container>
            <Row>
                <Col><h3>Reviews</h3></Col>
            </Row>
            <Row className="mt-2">
                <Col>
                    <img src={movie?.poster} alt="" />
                </Col>
                <Col>
                    {
                        <>
                            <Row>
                                <Col>
                                    <ReviewForm handleSubmit={addReview} revText={revText} labelText="Write a Review?" />
                                </Col>
                            </Row>
                            <Row>
                                <Col>
                                    <hr />
                                </Col>
                            </Row>
                        </>
                    }
                    {
                        movie && movie.reviewIds ? (
                            movie.reviewIds.map((review) => {
                                return (
                                    <>
                                        <Row>
                                            <Col>{review.body}</Col>
                                        </Row>
                                        <Row>
                                            <Col>
                                                <hr />
                                            </Col>
                                        </Row>
                                    </>
                                );
                            })
                        ) : (
                            <div>No reviews available</div>
                        )
                    }
                </Col>
            </Row>
            <Row>
                <Col>
                    <hr />
                </Col>
            </Row>
        </Container>
    )
}

export default Reviews
