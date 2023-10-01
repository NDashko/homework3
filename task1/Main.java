package task1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

public static void main(String[] args) throws Exception {
Scanner scanner = new Scanner(System.in);

System.out.println("Введите данные через пробел (Фамилия Имя Отчество дата рождения (dd.mm.yyyy) номер телефона пол (f или m)):");
String input = scanner.nextLine();

String[] data = input.split(" ");

if (data.length != 6) {
System.out.println("Введено неверное количество данных");
return;
}

String lastName = data[0];
String firstName = data[1];
String middleName = data[2];
String birthDate = data[3];
String phoneNumber = data[4];
String gender = data[5];


if (!isValidDate(birthDate)) {
System.out.println("Неверный формат даты рождения");
return;
}

String[] dateParts = birthDate.split("\\.");
int day = Integer.parseInt(dateParts[0]);
int month = Integer.parseInt(dateParts[1]);
int year = Integer.parseInt(dateParts[2]);
if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1900 || year > 2021) {
System.out.println ("Неверный формат даты рождения");
return;
}

if ((!phoneNumber.matches("\\d{11}"))) {
System.out.println("Неверный формат номера телефона");
return;
}

if (!isValidGender(gender)) {
System.out.println("Неверный формат пола");
return;
}

String fileName = lastName + ".txt";

try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
writer.write("<" + lastName + " " + firstName + " " + middleName + ">" + "<" + birthDate + ">" + "<" + phoneNumber + ">" + "<"+ gender + ">" + "\n");
System.out.println("Данные успешно записаны в файл " + fileName);
} catch (IOException e) {
System.out.println("Ошибка при записи в файл " + fileName);
e.printStackTrace();
}
}

private static boolean isValidDate(String date) {
return date.matches("\\d{2}\\.\\d{2}\\.\\d{4}");
}

private static boolean isValidPhoneNumber(String phoneNumber) {
return phoneNumber.matches("\\d+");
}

private static boolean isValidGender(String gender) {
return gender.equals("f") || gender.equals("m");
}
}











