package test;

import java.util.Set;
import java.util.HashSet;

public class BookManager {
    // 책 목록
    // 책 이름이 같다면 중복 책으로 처리
    private Set<String> books = new HashSet<>();

    // 책 추가
    public void addBook(String name) {
        if (books.contains(name)) {
            throw new IllegalArgumentException("이미 존재하는 책입니다: " + name);
        }
        books.add(name);
    }

    // 책 제거
    public void removeBook(String name) {
        if (!books.contains(name)) {
            throw new IllegalArgumentException("존재하지 않는 책입니다: " + name);
        }
        books.remove(name);
    }

    // 책 목록에 해당 책이 있는지 여부를 확인(boolean 타입 반환)
    public boolean hasBook(String name) {
        return books.contains(name);
    }
}