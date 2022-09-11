package ExersizePyramidsAndSearchTrees05;

/**
 * @author Leonid Zulin
 * @date 11.09.2022 12:08
 */
public class BuildingIdeaBinSearchTree {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52};

        build(arr);
    }

    private static int[] mark(int[] arr, int left, int right, int level, int[] levels) {
        int middle;

        if (left == right) {
            levels[left] = level;
        } else {
            middle = (left + right) / 2;
            levels[middle] = level;
            mark(arr, left, middle - 1, level + 1, levels);
            mark(arr, middle + 1, right, level + 1, levels);
        }
        return levels;
    }

    private static void build(int[] arr) {
        // переменная максимума среди массива levels
        int maxLevel;
        // инициализация нашего массива нулями
        int[] levels = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            levels[i] = 0;
        }

        mark(arr, 0, arr.length - 1, 0, levels);

        maxLevel = catchMaxElement(levels);

        for (int level = 0; level < maxLevel + 1; level++) {
            for (int i = 0; i < arr.length; i++) {
                if (levels[i] == level)
                    System.out.print(arr[i]);
                else System.out.print("  ");
            }
            System.out.println();
        }

    }

    // метод поиска максимума в массиве levels
    public static int catchMaxElement(int[] anyArray) {
        int maxValue = anyArray[0];
        for (int i = 0; i < anyArray.length; i++) {
            if (anyArray[i] > maxValue) {
                maxValue = anyArray[i];
            }
        }
        return maxValue;
    }


}
