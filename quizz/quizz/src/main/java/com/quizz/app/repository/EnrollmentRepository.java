package com.quizz.app.repository;

import com.quizz.app.model.Course;
import com.quizz.app.model.Enrollment;
import com.quizz.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    Optional<Enrollment> findByCourseAndStudent(Course course, User student);
}
