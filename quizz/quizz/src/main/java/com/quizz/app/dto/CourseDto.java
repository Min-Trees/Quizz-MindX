package com.quizz.app.dto;

import com.quizz.app.model.Course;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDto {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long instructorId;

    public static CourseDto fromEntity(Course course) {
        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setStatus(course.getStatus().name());
        dto.setStartDate(course.getStartDate());
        dto.setEndDate(course.getEndDate());
        if (course.getInstructor() != null) {
            dto.setInstructorId(course.getInstructor().getId());
        }
        return dto;
    }
}
