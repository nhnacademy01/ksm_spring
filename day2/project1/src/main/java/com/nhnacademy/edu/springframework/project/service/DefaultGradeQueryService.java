package com.nhnacademy.edu.springframework.project.service;

import com.nhnacademy.edu.springframework.project.repository.Score;

import java.util.List;

public class DefaultGradeQueryService implements GradeQueryService {
    @Override
    public List<Score> getScoreByStudentName(String name) {
        // TODO 5: 학생 이름으로 점수를 반환합니다. 동명이인 고려합니다.
        return null;
    }

    @Override
    public Score getScoreByStudentSeq(int seq) {
        // TODO 6 : 학생 번호로 점수를 반환합니다.
        return null;
    }
}
