package com.practo.practo.service;

import com.practo.practo.entities.Doctor;
import com.practo.practo.entities.Patient;
import com.practo.practo.entities.Review;
import com.practo.practo.repository.DoctorRepository;
import com.practo.practo.repository.PatientRepository;
import com.practo.practo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ReviewRepository reviewRepo;

    public Review createReview(Review review){

        Doctor doctor = doctorRepo.findById(review.getDoctorId()).get();

        Patient patient = patientRepo.findById(review.getPatientId()).get();
        Review savedReview=null;
        if(doctor!=null||patient!=null){
             savedReview = reviewRepo.save(review);
        }
        return savedReview;
    }

    public List<Review> getReviewByDoctorId(long doctorId){
        List<Review> reviews = reviewRepo.findByDoctorId(doctorId);
    return reviews;
    }
}
