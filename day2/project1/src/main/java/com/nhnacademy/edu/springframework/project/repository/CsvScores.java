package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 2 : (완료&검토요망) - load() 가 되는중에 다른 메소드가 실행되는 경우의 예외 발생 처리를 해결해야됨
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/
public class CsvScores implements Scores {

    private static final Scores INSTANCE = new CsvScores();

    private final List<Score> scores = new ArrayList<>();

    private CsvScores() {
    }

    public static Scores getInstance() {
        return INSTANCE;
    }

    // TODO 5(완료) : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        try (FileInputStream scoreFileIn = new FileInputStream(
            "D:\\NHN_Academy\\lectureSpring\\day2\\project1\\src\\main\\resources\\data\\score.csv")) {
            BufferedReader br = new BufferedReader(new InputStreamReader(scoreFileIn));
            String l;
            while ((l = br.readLine()) != null) {
                int commaIndex = l.indexOf(",");
                int studentSeq = Integer.parseInt(l.substring(0, commaIndex));
                int score = Integer.parseInt(l.substring(commaIndex + 1));
                Score studentScore = new Score(studentSeq, score);
                this.scores.add(studentScore);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Score> findAll() {
        if (scores.isEmpty()) {
            throw new IllegalStateException("데이터 로드가 완료되지 않았습니다.");
        }
        return this.scores;
    }
}
