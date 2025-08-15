package com.quizz.app.service;

import com.quizz.app.dto.CourseDto;
import com.quizz.app.model.Course;
import com.quizz.app.model.User;
import com.quizz.app.repository.CourseRepository;
import com.quizz.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    public List<CourseDto> getAll() {
        return courseRepository.findAll().stream().map(CourseDto::fromEntity).collect(Collectors.toList());
    }

    public CourseDto create(CourseDto dto) {
        User instructor = userRepository.findById(dto.getInstructorId()).orElseThrow();
        Course course = Course.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .status(Enum.valueOf(com.quizz.app.model.CourseStatus.class, dto.getStatus()))
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .instructor(instructor)
                .build();
        return CourseDto.fromEntity(courseRepository.save(course));
    }
}
