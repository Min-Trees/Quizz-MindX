INSERT INTO users (id, email, password, name) VALUES
 (1, 'admin@example.com', '$2a$10$7EqJtq98hPqEX7fNZaFWoO5h8uchUKZcD/r6BjqOqvOB0fOkHn2g.', 'Admin'),
 (2, 'instructor@example.com', '$2a$10$7EqJtq98hPqEX7fNZaFWoO5h8uchUKZcD/r6BjqOqvOB0fOkHn2g.', 'Instructor'),
 (3, 'student1@example.com', '$2a$10$7EqJtq98hPqEX7fNZaFWoO5h8uchUKZcD/r6BjqOqvOB0fOkHn2g.', 'Student One'),
 (4, 'student2@example.com', '$2a$10$7EqJtq98hPqEX7fNZaFWoO5h8uchUKZcD/r6BjqOqvOB0fOkHn2g.', 'Student Two'),
 (5, 'student3@example.com', '$2a$10$7EqJtq98hPqEX7fNZaFWoO5h8uchUKZcD/r6BjqOqvOB0fOkHn2g.', 'Student Three');

INSERT INTO user_roles (user_id, role) VALUES
 (1, 'ADMIN'), (2, 'INSTRUCTOR'), (3, 'STUDENT'), (4, 'STUDENT'), (5, 'STUDENT');

INSERT INTO courses (id, title, description, status, instructor_id) VALUES
 (1, 'Sample Course', 'Demo course', 'PUBLISHED', 2);
