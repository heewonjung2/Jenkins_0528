package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookManagerTest {
	private static BookManager manager;

	@BeforeAll
	static void setUpBeforeClass() {
		manager = new BookManager();
	}


	@ParameterizedTest
	@Order(1)
	@ValueSource(strings = {"어린 왕자", "해리 포터", "반지의 제왕", "돈키호테", "토끼와 거북이", "빨간 머리 앤", "이솝우화"})
	void testAddBook(String name) {
		// 책 추가
		manager.addBook(name);
		
		// 해당 이름의 책이 추가되었는지 확인
		Boolean hasBook = manager.hasBook(name);
		assertTrue(hasBook, "책 추가가 이루어지지 않았습니다.");	
	}
	
	@ParameterizedTest
	@Order(2)
	@ValueSource(strings = {"어린 왕자", "해리 포터", "반지의 제왕", "돈키호테", "토끼와 거북이", "빨간 머리 앤", "이솝우화"})
	void tesAddDuplicatedBook(String name) throws Exception {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> manager.addBook(name));
		System.out.println(e.toString());
	}
	
	@ParameterizedTest
	@Order(3)
	@ValueSource(strings = {"어린 왕자", "해리 포터", "반지의 제왕", "돈키호테", "토끼와 거북이", "빨간 머리 앤", "이솝우화"})
	void testRemoveBook(String name) {
		// 책 제거
		manager.removeBook(name);
		
		// 해당 이름의 책이 제거되었는지 확인
		Boolean hasBook = manager.hasBook(name);
		assertFalse(hasBook, "책 제거가 이루어지지 않았습니다.");
	}
	
	@ParameterizedTest
	@Order(4)
	@ValueSource(strings = {"어린 왕자", "해리 포터", "반지의 제왕", "돈키호테", "토끼와 거북이", "빨간 머리 앤", "이솝우화"})
	void testAlreadyRemovedBook(String name) {
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> manager.removeBook(name));
		System.out.println(e.toString());
	}
}
