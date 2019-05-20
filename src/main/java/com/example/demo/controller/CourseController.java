package com.example.demo.controller;

import com.example.demo.modal.Course;
import com.example.demo.modal.dto.CourseDto;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// single function interface
@RestController
@RequestMapping
public class CourseController {
    @Autowired // IOC
    CourseService courseService; // Singleton

    @GetMapping(path = "/", produces = "application/json")
    public HttpEntity findAllCourses(){
        List<Course> allCourses = courseService.findAllCourses();

        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public HttpEntity addCourse(@RequestBody Course course){
        List<Course> allCourses = courseService.addCourse(course);

        return new ResponseEntity<>(allCourses,HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{inputString}", produces = "application/json")
    public HttpEntity<Course> deleteCourse(@PathVariable("inputString") String inputString) {

        List<Course> allCourses = courseService.deleteCourse(inputString);

        return new ResponseEntity(allCourses, HttpStatus.OK);
    }
    @PutMapping(path = "/update/{inputString}", consumes = "application/json", produces = "application/json")
    public HttpEntity<Course> updateCourse(@PathVariable("inputString") String inputString, @RequestBody Course course) {

        List<Course> allCourses = courseService.updateCourse(inputString, course);

        return new ResponseEntity(allCourses, HttpStatus.OK);
    }

//    @GetMapping(path = "/api/course/findAllCourses", produces = "application/json")
//    public HttpEntity<List<CourseDto>> findAllCourses(){
//        List<CourseDto> allCourses = courseService.findAllCourses();
//
//        return new ResponseEntity<>(allCourses, HttpStatus.OK);
//    }

    @GetMapping(path = "/look-up/{inputString}", produces = "application/json")
    public HttpEntity<Course> searchCourse(@PathVariable("inputString") String inputString) {

        List<Course> findedCourse = courseService.searchByCourseName(inputString);

        return new ResponseEntity(findedCourse, HttpStatus.OK);
    }
}
