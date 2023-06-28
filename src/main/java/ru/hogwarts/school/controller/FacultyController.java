package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.dto.FacultyDtoIn;
import ru.hogwarts.school.dto.FacultyDtoOut;
import ru.hogwarts.school.service.FacultyService;

@RestController
@RequestMapping(value = "faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public FacultyDtoOut createFaculty(@RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.createFaculty(facultyDtoIn);
    }

    @GetMapping("{id}")
    public FacultyDtoOut readeFaculty(@PathVariable("id") long id) {
        return facultyService.readFaculty(id);
    }

    @PutMapping("{id}")
    public FacultyDtoOut updateFaculty(@PathVariable("id") long id, @RequestBody FacultyDtoIn facultyDtoIn) {
        return facultyService.updateFaculty(id, facultyDtoIn);
    }

    @GetMapping("{id}")
    public FacultyDtoOut deleteFaculty(@PathVariable("id") long id) {
        return facultyService.deleteFaculty(id);
    }

}
