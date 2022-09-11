package ExersizeHashing06;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Leonid Zulin
 * @date 11.09.2022 12:12
 */
public class RabinCarpWithTemplates {
    public static void main(String[] args) {

        // Строка в которой будем искать
        String source = "Alibaba or Alibubab? I do not know!";
        // Наш шаблон
        String pattern = "b*b";
        ArrayList<Integer> found;
        found = defSeach(source, pattern);

        if (found.isEmpty()) {
            // если нам вернулся нулевой список, то так и напечатаем
            System.out.println("Такой подстроки точно нет!!!");
        } else {
            // а иначе выведем наш массив найденных началов элементов подстроки
            System.out.println(Arrays.toString(found.toArray()));
        }

    }

    public static ArrayList<Integer> defSeach(String source, String pattern) {

        // позиция символа "*" в нашем паттерне
        int asterikPosition = 1;

        // ArrayList для поиска
        ArrayList<Integer> foundSearch = new ArrayList<>(pattern.length());

        // преобразуем в массив наш шаблон для расчёта hash
        String[] patternArray = pattern.split("");

        // преобразуем в массив нашу изначальную строку для расчёта hash
        String[] sourceArray = source.split("");

        // переменная hash шаблона, изничально равно 0
        int patternHash = 0;

        // инициализация суммы кодов
        int windowHash = 0;

        if (source.length() < pattern.length()) {
            // вернём пустой ArrayList поиска
            return foundSearch;

        } else {
            // Подсчитаем сумму hash шаблона
            for (int i = 0; i < patternArray.length; i++) {
                patternHash += patternArray[i].hashCode();

            }
            // и вычтем hash символа "*"
            // таким образом найдём сумму кодов в паттерне без учёта '*'
            patternHash = patternHash - patternArray[asterikPosition].hashCode();

        }


        for (int start = 0; start < source.length() - (pattern.length() + 1); start++) {

            if (start == 0) {

                for (int i = 0; i < pattern.length(); i++) {
                    windowHash += sourceArray[i].hashCode();
                }
                windowHash -= sourceArray[asterikPosition].hashCode();

            } else {

                windowHash -= sourceArray[start - 1].hashCode();
                windowHash += sourceArray[start + patternArray.length - 1].hashCode();
                windowHash += sourceArray[start + asterikPosition - 1].hashCode();
                windowHash -= sourceArray[start + asterikPosition].hashCode();

            }

            if (windowHash == patternHash) {
                for (int i = 0; i < pattern.length(); i++) {

                    if (patternArray[i] != "*" && sourceArray[start + i] != patternArray[i]) {
                        continue;
                        // System.out.println("Строка " + i + " не подходит!");
                    }

                }

                foundSearch.add(start); // если подошёл, то добавим в наш ArrayList
            }

        }
        // Вернём полученный ArrayList
        return foundSearch;
    }

}
