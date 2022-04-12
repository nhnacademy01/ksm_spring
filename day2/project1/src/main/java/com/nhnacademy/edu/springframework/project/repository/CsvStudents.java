package com.nhnacademy.edu.springframework.project.repository;

import com.nhnacademy.edu.springframework.project.service.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


/** TODO 3 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/

/**
 * TODO 7 :
 * singleton 클래스를 만드세요.
 */
public class CsvStudents implements Students {

    private final Map<Integer,Student> students = new HashMap<>();


    public static Students getInstance() {
        return null;
    }

    // TODO 6 : student.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {

    }

    @Override
    public Collection<Student> findAll() {
        return this.students.values();
    }

    /**
     * TODO 8 : students 데이터에 score 정보를 추가하세요.
     * @param scores
     */
    @Override
    public void merge(Collection<Score> scores) {

    }
}
