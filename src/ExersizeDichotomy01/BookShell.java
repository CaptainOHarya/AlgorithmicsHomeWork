package ExersizeDichotomy01;

/**
 * @author Leonid Zulin
 * @date 11.09.2022 9:40
 */
public class BookShell {
    public static void main(String[] args) {
        // наш массив рамеров книг
        // {3, 3, 4, 12, 14, 14, 16, 19, 30, 31, 32, 32, 32, 32, 56, 69, 72, 74} - просто побольше для проверки
        int[] books = new int[]{14, 16, 19, 32, 32, 32, 56, 69, 72};
        // переменная размера новой книги
        int sizeNewBook = 20;
        // количество книг больше размера sizeNewBook
        int numberOfBook;

        numberOfBook = binarySearch(books, sizeNewBook);
        System.out.println("Количество книг на полке больше размера " + sizeNewBook + " = " + numberOfBook);
    }

    private static int binarySearch(int[] books, int sizeNewBook) {
        // переменная количества книг, которую возвращаем, по умолчанию 0
        int result = 0;
        // зададим границы интервала поиска
        int left = 0;
        int right = books.length - 1;
        int middle;

        while (left <= right) {
            // Смотрим в середину
            middle = left + (right - left) / 2;
            // Если больше
            if (books[middle] > sizeNewBook) {
                right = middle - 1;
                // Если меньше или равно
            } else if (books[middle] <= sizeNewBook) {
                left = middle + 1;

            }
        }

        // Опеределим следующей формулой количество книг строго большее по размеру
        result = books.length - left;
        return result;
    }


}
