package com.nhnacademy.edu.springframework.project.repository;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/** TODO 2 :
 * load 를 제외한 메소드 실행시
 * 데이터 로드가 완료되지 않으면 IllegalStateException 이 발생해야 한다.
 **/
public class CsvScores implements Scores {

    private static final Scores INSTANCE = new CsvScores();

    private final List<Score> scores = new ArrayList<>();

    private CsvScores(){}

    public static Scores getInstance() {
        return INSTANCE;
    }

    // TODO 5 : score.csv 파일에서 데이터를 읽어 scores 에 추가하는 로직을 구현하세요.
    @Override
    public void load() {
        try(FileInputStream scoreFileIn = new FileInputStream("D:\\NHN_Academy\\lectureSpring\\day2\\project1\\src\\main\\resources\\data\\score.csv")) {
            System.out.println(scoreFileIn.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Score> findAll() {
        return this.scores;
    }
}
