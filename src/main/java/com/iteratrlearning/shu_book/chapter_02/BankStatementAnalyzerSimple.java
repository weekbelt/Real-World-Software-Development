package com.iteratrlearning.shu_book.chapter_02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementAnalyzerSimple {

    private static final String RESOURCES = "src/main/resources/";

    public static void main(final String[] args) throws Exception {
        // 1. 입력 읽기
        final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
        // 2. 주어진 형식의 입력 파싱
        final List<String> lines = Files.readAllLines(path);
        // 3. 결과 처리
        double total = 0;
        for (final String line : lines) {
            String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        // 4. 결과 요약 리포트
        System.out.println("The total for all transactions is " + total);
    }
}

