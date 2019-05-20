package com.example.demo.repository;

import com.example.demo.modal.Course;
import com.example.demo.modal.Instructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public CourseRepository() {
        Course javaOne = Course.builder()
                .className("Java I")
                .instructor(new Instructor("Steve", "Jobs", "Phd", "TownHall201"))
                .startDate(new Date("8/1/2018"))
                .endDate(new Date("12/24/2018"))
                .timeFrame("8am-10am")
                .build();

        courses.add(javaOne);
    }


    public List<Course> findAllClasses(){
        //链接数据库
        //返回数据库的信息
        return  courses;
    }

    public List<Course> findAllCourse(String searchByCourseName){

        return new ArrayList<Course>();
    }

    public List<Course> findCourseByName(String courseName) {
        if(courseName.equals("Java_I")) {
            return courses;
        }

        return new ArrayList<Course>();
    }

    public List<Course> addCourse(Course course) {
        Course newCourse = Course.builder()
                .className(course.getClassName())
                .instructor(course.getInstructor())
                .startDate(course.getStartDate())
                .endDate(course.getEndDate())
                .timeFrame(course.getTimeFrame())
                .build();

        courses.add(newCourse);
        return courses;
    }

    public List<Course> deleteCourse(String name){
        for(int i=0; i< courses.size(); i++){
            if(courses.get(i).getClassName().equals(name)){
                courses.remove(i);
            }
        }
        return courses;
    }
    public List<Course> updateCourse(String name, Course course){
        for(int i=0; i< courses.size(); i++){
            if(courses.get(i).getClassName().equals(name)){
                courses.get(i).setClassName(course.getClassName());
                courses.get(i).setInstructor(course.getInstructor());
                courses.get(i).setStartDate(course.getStartDate());
                courses.get(i).setEndDate(course.getEndDate());
                courses.get(i).setTimeFrame(course.getTimeFrame());
            }
        }
        return courses;
    }
}
