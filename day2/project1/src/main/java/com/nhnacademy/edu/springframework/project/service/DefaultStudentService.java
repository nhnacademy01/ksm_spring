package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.CsvStudents;
import com.nhnacademy.edu.springframework.project.repository.Students;

import java.util.Collection;

public class DefaultStudentService implements StudentService {
    @Override
    public Collection<Student> getPassedStudents() {
        Students studentRepository = CsvStudents.getInstance();
        System.out.println(CsvStudents.getInstance());
        // TODO 1 : pass 한 학생만 반환하도록 수정하세요.
        return studentRepository.findAll();
    }

    @Override
    public Collection<Student> getStudentsOrderByScore() {
        Students studentRepository = CsvStudents.getInstance();
        // TODO 4 : 성적 순으로 학생 정보를 반환합니다.
        return studentRepository.findAll();
    }

}
