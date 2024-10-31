package View;
import java.util.Scanner;

import Controller.BookManageController;
import Dto.BookDTO;
import java.util.Scanner;

public class BookManageView {
    private BookManageController controller;
    private Scanner scanner;

    public BookManageView() {
        controller = new BookManageController();
        scanner = new Scanner(System.in);
    }


    public void displayMenu() {
        int choice = -1;
        while (choice != 0) {
            System.out.println("\n===== 도서 관리 시스템 =====");
            System.out.println("1. 도서 추가");
            System.out.println("2. 도서 삭제");
            System.out.println("3. 도서 정보 수정");
            System.out.println("4. 도서 조회");
            System.out.println("5. 도서 목록 출력");
            System.out.println("0. 나가기");
            System.out.print("메뉴를 선택하세요. ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> deleteBook();
                case 3 -> updateBook();
                case 4 -> findBook();
                case 5 -> displayAllBooks();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("다시 입력하세요.");
            }
        }
    }


    private void addBook() {
        System.out.print("ISBN을 입력하세요.: ");
        String isbn = scanner.nextLine();
        System.out.print("Title을 입력하세요.: ");
        String title = scanner.nextLine();
        System.out.print("Author을 입력하세요.: ");
        String author = scanner.nextLine();
        System.out.print("Publisher를 입력하세요.: ");
        String publisher = scanner.nextLine();
        System.out.print("Price를 입력하세요.: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // 버퍼 정리

        BookDTO book = new BookDTO(isbn, title, author, publisher, price);
        controller.addBook(book);
    }


    private void deleteBook() {
        System.out.print("삭제할 도서의 ISBN을 입력하세요.: ");
        String isbn = scanner.nextLine();
        controller.deleteBook(isbn);
    }


    private void updateBook() {
        System.out.print("업데이트할 도서의 ISBN을 입력하세요.: ");
        String isbn = scanner.nextLine();

        System.out.print("추가할 도서의 Title을 입력하세요 : ");
        String title = scanner.nextLine();
        System.out.print("추가할 도서의 Author을 입력하세요 : ");
        String author = scanner.nextLine();
        System.out.print("추가할 도서의 Publisher를 입력하세요 : ");
        String publisher = scanner.nextLine();
        System.out.print("추가할 도서의 Price를 입력하세요 ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        BookDTO updatedBook = new BookDTO(isbn, title, author, publisher, price);
        controller.updateBook(isbn, updatedBook);
    }


    private void findBook() {
        System.out.print("찾을 도서의 ISBN을 입력하세요. : ");
        String isbn = scanner.nextLine();
        BookDTO book = controller.findBookByIsbn(isbn);
        if (book != null) {
            System.out.println("도서를 찾았습니다.: " + book);
        } else {
            System.out.println("도서를 찾지 못했습니다.");
        }
    }


    private void displayAllBooks() {
        System.out.println("\n===== 책 목록 =====");
        for (BookDTO book : controller.getAllBooks()) {
            System.out.println(book);
        }
    }
}

