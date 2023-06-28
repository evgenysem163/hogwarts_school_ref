package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.dto.StudentDtoIn;
import ru.hogwarts.school.dto.StudentDtoOut;
import ru.hogwarts.school.entity.Student;
import ru.hogwarts.school.exception.StudentNotFindException;
import ru.hogwarts.school.mapper.StudentMapper;
import ru.hogwarts.school.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentDtoOut createStudent(StudentDtoIn studentDtoIn) {
        return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(studentDtoIn)));
    }

    public StudentDtoOut readStudent(long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new StudentNotFindException(id));
    }

    public StudentDtoOut updateStudent(long id, StudentDtoIn studentDtoIn) {
        return studentRepository.findById(id)
                .map(oldStudent -> {
                            oldStudent.setAge(studentDtoIn.getAge());
                            oldStudent.setName(studentDtoIn.getName());
                            return studentMapper.toDto(studentRepository.save(oldStudent));

                        }
                )
                .orElseThrow(() -> new StudentNotFindException(id));
    }

    public StudentDtoOut deleteStudent(long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new StudentNotFindException(id));
        studentRepository.delete(student);
        return studentMapper.toDto(student);
    }
}
