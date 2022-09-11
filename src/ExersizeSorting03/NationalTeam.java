package ExersizeSorting03;

/**
 * @author Leonid Zulin
 * @date 11.09.2022 11:09
 */
public class NationalTeam {
    public static void main(String[] args) {
        // Инициализация наших массивов, здесь его лучше реализовать как двумерный, указав только количество строк
        int[][] regionalTeams = new int[3][];

        // Инициализируем массив, заполняя его нашими массивами рейтингов игроков
        regionalTeams[0] = new int[]{45, 31, 24, 22, 20, 17, 14, 13, 12, 10};
        regionalTeams[1] = new int[]{31, 18, 15, 12, 10, 8, 6, 4, 2, 1};
        regionalTeams[2] = new int[]{51, 30, 10, 9, 8, 7, 6, 5, 2, 1};

        // Вызовем метод для выбора национальной команды
        int[] teamNational = getNationalTeam(regionalTeams);
        // и напечатаем результат
        printNationalTeam(teamNational);
    }

    private static void printNationalTeam(int[] teamNational) {
        System.out.println("Национальная команда имеет следующий состав по рейтингу игроков");
        System.out.print("[ ");
        for (int i = 0; i < teamNational.length; i++) {
            System.out.print(teamNational[i] + " ");
        }
        System.out.print("]");
    }

    private static int[] getNationalTeam(int[][] regionalTeams) {
        int[] team = regionalTeams[0];
        for (int i = 1; i < regionalTeams.length; i++) {
            team = mergeArray(team, regionalTeams[i]);
        }
        return team;
    }

    // метод слияния команд для выбора топ-10 из обеих команд
    private static int[] mergeArray(int[] team1, int[] team2) {
        // Нам нужно чтобы в национальной команде было не более 10 игроков
        int lengthMergingTeam = 10;
        int[] teamMerging = new int[lengthMergingTeam];
        // счётчики в соотвествующих массивах
        int iTeam1 = 0;
        int iTeam2 = 0;
        int iMergingTeam = 0;
        while (iTeam1 < team1.length || iTeam2 < team2.length) {
            // Проверим, набрали ли мы 10 лучших игроков или нет? Если да, то команда собрана!
            if (iMergingTeam > lengthMergingTeam - 1) break;

            // проверка если первый массив закончился
            if (iTeam1 == team1.length) {
                teamMerging[iMergingTeam] = team2[iTeam2];
                iTeam2 += 1;

            } // иначе смотрим не закончился ли второй массив
            else {
                if (iTeam2 == team2.length) {
                    teamMerging[iMergingTeam] = team1[iTeam1];
                    iTeam1 += 1;

                    // если ни то ни другое
                } else {
                    if (team1[iTeam1] >= team2[iTeam2]) {
                        teamMerging[iMergingTeam] = team1[iTeam1];
                        iTeam1 += 1;
                    } else {
                        teamMerging[iMergingTeam] = team2[iTeam2];
                        iTeam2 += 1;
                    }
                    iMergingTeam += 1;
                }
            }
        }
        return teamMerging;
    }
}
