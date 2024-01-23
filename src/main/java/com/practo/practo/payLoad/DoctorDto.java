package com.practo.practo.payLoad;

import com.practo.practo.entities.Doctor;
import com.practo.practo.entities.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Doctor doctor;
    private List<Review> reviews;
    private double ratingPercentage;

    public double getRatingPercentage() {
        return ratingPercentage;
    }

    public void setRatingPercentage(double ratingPercentage) {
        this.ratingPercentage = ratingPercentage;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
