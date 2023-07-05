import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeWork3 {
    public static void main(String[] args) {

        // 1.Пусть дан произвольный список целых чисел.
        ArrayList<Integer> res = createArray(7, 15);
        System.out.println("Исходный массив: " + res);
        // 1) Нужно удалить из него чётные числа
        System.out.print("Нечётные числа массива: ");
        System.out.println(dellArray(res));

        ArrayList<Integer> res2 = createArray(7, 15);
        System.out.println("Исходный массив для поиска минимального, максимального и среднего чисел: " + res2);
        // 2) Найти минимальное значение
        int min = minNumber(res2);
        System.out.println("Минимальное число в массиве: " + min);
        // 3) Найти максимальное значение
        int max = maxNumber(res2);
        System.out.println("Максимальное число в массиве: " + max);
        // 4) Найти среднее значение
        double average = averageNumbers(res2);
        System.out.println("Cреднее значение: " + average);

        planetsCounter(15);
    }

    // формирование числового массива
    static ArrayList<Integer> createArray(int n, int maxValue) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < n; i++)
            list.add(random.nextInt(maxValue));
        return list;
    }

    // 1) Нужно удалить из него чётные числа
    // метод, который чётные числа
    static ArrayList<Integer> dellArray(ArrayList<Integer> arr) {
        for (int i = arr.size() - 1; i >= 0; i--) {
            if (arr.get(i) % 2 == 0) {
                arr.remove(i);
            }
        }
        return arr;
    }

    // 2) Найти минимальное значение
    static int minNumber(ArrayList<Integer> arr) {
        int min = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }
        return min;
    }

    // максимальное значение
    static int maxNumber(ArrayList<Integer> arr) {
        int max = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }
        }
        return max;
    }

    // среднее значение
    static double averageNumbers(ArrayList<Integer> arr) {
        double count = 0;
        for (int i = 0; i < arr.size(); i++) {
            count += arr.get(i);
        }
        return count / arr.size();
    }

    // 2. Заполнить список названиями планет Солнечной системы в произвольном
    // порядке с повторениями.
    // Вывести название каждой планеты и количество его повторений в списке.
    static void planetsCounter(int n) {
        List<String> listPlanets = List.of("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus",
                "Neptune");
        List<String> randPlanets = new ArrayList<String>(n);
        int[] counts = new int[listPlanets.size()];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
            System.out.print(randPlanets.get(i) + " ");
            counts[listPlanets.indexOf(randPlanets.get(i))]++;
        }
        System.out.println();

        for (int i = 0; i < counts.length; i++)
            System.out.printf("%s - %s\n", listPlanets.get(i), counts[i]);
        System.out.println();
        //Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы.
        for (int i = 0; i < randPlanets.size(); i++) {
            for (int j = i + 1; j < randPlanets.size(); j++) {
                if (randPlanets.get(i).equals(randPlanets.get(j))) {
                    randPlanets.remove(j);
                    j--;
                }
            }
        }
        System.out.println("Список уникальных элементов: ");

        int[] uniqueCol = new int[listPlanets.size()];
        for (String planet : randPlanets) {
            uniqueCol[listPlanets.indexOf(planet)]++;
        }

        for (int i = 0; i < listPlanets.size(); i++) {
            if (uniqueCol[i] == 0) {
                System.out.printf("%s - %s\n", listPlanets.get(i), "0");
            } else {
                System.out.printf("%s - %s\n", listPlanets.get(i), uniqueCol[i]);
            }
        }


    }

}