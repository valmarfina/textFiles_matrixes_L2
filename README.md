# LABA IS NOT DONE YET
## ***Задание:***
***Написать консольное приложение, которое:***
* [X] Считывает из текстового файл размерность матрицы N*N. 
* [X] Создаёт и заполняет матрицу случайными числами от -N до N.
* [X] Последовательно поворачивает матрицу на 90, 180 и 270 градусов
против часовой стрелки и делит каждый элемент на сумму
соседних.
* [X] Каждую из трёх получившихся матриц вывести в общий файл


***Требования к обработке исключительных ситуаций:***
* контролировать состояние потоков ввода/вывода (отсутствие
записи в файле, недопустимые значения, etc);
* генерировать и обрабатывать исключение при некорректных
математических операциях;
* выбрасывать исключение при нехватке памяти;
* реализовать собственные классы исключений для случаев
     * деление на 0 
     * файл не существует
     * N > 1_000_000


## ***Task:***
***Write a console application that:***
* Reads from a text file the dimension of a matrix N*N.
* Creates and fills the matrix with random numbers from -N to N.
* Rotates the matrix 90, 180, and 270 degrees sequentially
  counterclockwise and divides each element by the sum
  neighbors.
* Output each of the three resulting matrices to a common file


***Requirements for handling of exceptional situations:***
* Control the state of the input/output streams (no
* control the state of the input/output streams (no record in the file, invalid values, etc.);
* to generate and handle exceptions in case of incorrect
  mathematical operations;
* throw exception on memory shortage;
* implement own exception classes for the cases of
    * division by 0
    * file does not exist
    * N > 1_000_000