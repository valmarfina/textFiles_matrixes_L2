import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {
  //функция заполняет массив случайными числами от -N до N
  public static void randomFill(double[][] myMass, int N) {
    Random rnd = new Random();
    for (int i = 0; i < myMass.length; i++) {
      for (int j = 0; j < myMass[i].length; j++) {
        myMass[i][j] = rnd.nextInt((N + N) + 1) - N;
      }
    }
  }

  //запись в файл
  public static void printToFile(double[][] myMass, FileWriter writer) throws Exception {
    for (double[] elements : myMass)
      writer.write(Arrays.toString(elements) + '\n');

    writer.write('\n');
  }

  //поворот матрицы на 90 градусов против часов стрелки
  public static void turn90Mass(double[][] myMass) throws Exception {
    if (myMass.length == 0)
      throw new Exception("mass's length is not correct");

    int rows = myMass.length, cols = myMass[0].length;
    double[][] temp = new double[cols][rows];
    for (int row = 0; row < cols; row++) {
      for (int col = 0; col < rows; col++) {
        temp[row][col] = myMass[col][rows - row - 1];
      }
    }
    for (int i = 0; i < myMass.length; i++) {
      System.arraycopy(temp[i], 0, myMass[i], 0, myMass.length);
    }
  }

  //поворот матрицы на 180 градусов против часов стрелки
  public static void turn180Mass(double[][] myMass) throws Exception {
    if (myMass == null || myMass.length == 0)
      throw new Exception("mass's length is not correct");

    if (myMass.length % 2 == 1) {
      for (int j = 0; j < myMass.length / 2; j++) {
        double temp = myMass[myMass.length / 2][j];
        myMass[myMass.length / 2][j] = myMass[myMass.length / 2][myMass.length - j - 1];
        myMass[myMass.length / 2][myMass.length - j - 1] = temp;
      }
    }

    for (int i = 0; i < myMass.length / 2; i++) {
      for (int j = 0; j < myMass.length; j++) {
        double temp = myMass[i][j];
        myMass[i][j] = myMass[myMass.length - i - 1][myMass.length - j - 1];
        myMass[myMass.length - i - 1][myMass.length - j - 1] = temp;
      }
    }
  }

  //поворот матрицы на 270 градусов против часов стрелки
  public static void turn270Mass(double[][] myMass) throws Exception {
    turn180Mass(myMass);
    turn90Mass(myMass);
  }

  //деление элементов на сумму соседних
  public static void division(double[][] myMass) throws DoNotDivideByZeroException {
    double[][] temp = new double[myMass.length + 2][myMass.length + 2];
    for (int i = 0; i < myMass.length; i++)
      System.arraycopy(myMass[i], 0, temp[i + 1], 1, myMass.length);

    double sum = 0;
    for (int i = 1; i < temp.length - 1; i++) {
      for (int j = 1; j < temp.length - 1; j++) {
        sum = temp[i - 1][j] + temp[i][j + 1] + temp[i + 1][j] + temp[i][j - 1];
        if (sum == 0)
          throw new DoNotDivideByZeroException();
        else
          myMass[i - 1][j - 1] = roundNum(temp[i][j] / sum);
        sum = 0;

      }
    }
  }

  public static double roundNum(double value) {
    double scale = Math.pow(10, 2);
    double result = Math.ceil(value * scale);
    result /= scale;
    return result;
  }


  public static void main(String[] args) throws Exception {

    File file = new File("D:\\study\\POLYTEC\\ява\\лабы\\labs\\textFiles_matrixes\\src\\file.txt");
    if (!file.exists() && !file.isDirectory())
      throw new TheFileDoesNotExist();

    Scanner scanner = new Scanner(file);
    int N = scanner.nextInt();

    if (N == 0)
      throw new Exception("N is less oe equal to 0");

    if (N < 0)
      throw new NegativeArraySizeException("Массив с отрицательным размером");

    if (N > 1000000)
      throw new OverOneMillionException();

    double[][] myMass = new double[N][N];

    //заполняем массив случайными числами от -N до N
    randomFill(myMass, N);

    FileWriter writer = new FileWriter("file_out.txt");

    writer.write("полученная матрица из элементов " + N + " на " + N + '\n');
    printToFile(myMass, writer);

    writer.write("поворот матрицы на 90 градусов против часовой стрелки" + '\n');
    turn90Mass(myMass);
    printToFile(myMass, writer);

    writer.write("поворот матрицы на 180 градусов против часовой стрелки" + '\n');
    turn180Mass(myMass);
    printToFile(myMass, writer);

    writer.write("поворот матрицы на 270 градусов против часовой стрелки" + '\n');
    turn270Mass(myMass);
    printToFile(myMass, writer);

    writer.write("деление элементов матрицы на сумму соседних" + '\n');
    division(myMass);
    printToFile(myMass, writer);

    writer.close();
  }
}
