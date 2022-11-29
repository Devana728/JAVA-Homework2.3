//Дана строка json:
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"}, {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"}, {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод, который распарсит json и, используя StringBuilder, создаст строки вида:
//Студент [фамилия] получил [оценка] по предмету [предмет]. Например:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

            public static void main(String[] args) {
                Scanner scanner;
                try {
                    scanner = new Scanner(new File("text.txt"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    return;
                }


                String filter = scanner.nextLine().trim();
                scanner.close();

                //String filter ="[{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}, {\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}, {\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]";
                filter = filter.substring(3, filter.length() - 3);
                String[] param = filter.split("\\}, \\{");

                for (int i = 0; i <= param.length - 1; i++) {
                    String[] name = param[i].trim().replace("\"", "").split("\\,|\\:");
                    StringBuilder students = new StringBuilder();


                    students.append("студент " ).append(name[1]).append(" получил ").append(name[3]).append(" по предмету ").append(name[5]);
                    System.out.println(students);
                }


    }
}
