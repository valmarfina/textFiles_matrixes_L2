import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

  //функция заполняет массив случайными числами от -N до N
  public static void randomFill(int[][] myMass, int N) {
    Random rnd = new Random();
    for (int i = 0; i < myMass.length; i++) {
      for (int j = 0; j < myMass[i].length; j++) {
        myMass[i][j] = rnd.nextInt((N + N) + 1) - N;
      }
    }
  }

  //функция вывод массива
  public static void printMass(int[][] myMass) {
    //System.out.print(Arrays.deepToString(myMass));
    Arrays.stream(myMass).map(Arrays::toString).forEach(System.out::println);
    System.out.println();
  }

  //поворот матрицы на 90 градусов против часов стрелки
  public static int[][] turn90Mass(int[][] myMass) {
     if (myMass.length == 0) return myMass;

    int rows = myMass.length, cols = myMass[0].length;
    int[][] result = new int[cols][rows];

    for(int row = 0; row < cols; row++) {
      for(int col = 0; col < rows; col++) {
        result[row][col] = myMass[col][rows - row - 1];
      }
    }
    return result;
  }

  //запись в файл(NOT DONE)
  public static void write(String filename, int[] x) throws IOException {
    BufferedWriter outputWriter = null;
    outputWriter = new BufferedWriter(new FileWriter(filename));
    outputWriter.flush();
    outputWriter.close();
  }

  public static void main(String[] args) {
    try {

      //считываем размерность матрицы из файла file.txt
      Scanner scanner = new Scanner(new File("D:\\study\\POLYTEC\\ява\\лабы\\labs\\textFiles_matrixes\\src\\file.txt"));
      int N = scanner.nextInt();

      //массив который заполним радомно
      int[][] myMass = new int[N][N];

      //функция заполняет массив случайными числами от -N до N
      randomFill(myMass, N);
      //функция вывод массива
      printMass(myMass);

      //поворот матрицы на 90 градусов и печать в консоль
      printMass(turn90Mass(myMass));
      //поворот матрицы на 180 градусов и печать в консоль
      printMass(turn90Mass(turn90Mass(myMass)));
      //поворот матрицы на 270 градусов и печать в консоль
      printMass(turn90Mass(turn90Mass(turn90Mass(myMass))));


      //запись в файл NOT DONE
      FileWriter writer = new FileWriter("file_out.txt");
      writer.write("hello world");
      writer.write("hello world");
      writer.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
