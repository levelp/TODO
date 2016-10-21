package ru.levelp.beginners.todo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Список ваших задач
    private static ArrayList<String> taskList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Примеры задач
        taskList.add("Разобраться в этом примере");
        taskList.add("Задать вопросы Насте или Денису");

        while (true) {
            // Выводим список задач
            System.out.println("== ЗАДАЧИ ==");
            if (taskList.size() == 0)
                System.out.println("У вас нет задач :)");
            for (int i = 0; i < taskList.size(); i++) {
                System.out.printf("  %d. %s%n", i + 1, taskList.get(i));
            }
            // Выводим возможные действия
            System.out.println("Меню (какие действия выполнить с задачми):");
            System.out.println("  1. Добавить новую задачу");
            System.out.println("  2. Редактировать задачу");
            System.out.println("  3. Вычеркнуть выполненную задачу или удалить задачу");
            System.out.println("  0. Выход");
            // Пользователь выбирает
            System.out.print("Введите 1,2,3 или 0: ");
            int choice = Integer.parseInt(scanner.nextLine().trim());
            // Выполняем выбранный пункт
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    finishTask();
                    break;
                case 0:
                    System.out.println("Спасибо за использование нашей программы, надеемся, что вам понравилось :)");
                    return;
            }
        }
    }

    private static void addTask() {
        System.out.println("-- Добавление задачи --");
        System.out.print("Описание задачи: ");
        String task = scanner.nextLine();
        taskList.add(task);
    }

    private static void finishTask() {
        System.out.println("-- Завершили (выполнили) задачу --");
        System.out.print("Номер задачи: ");
        int no = Integer.parseInt(scanner.nextLine().trim());
        taskList.remove(no - 1);
    }

    private static void editTask() {
        System.out.println("-- Отредактировать задачу --");
        System.out.print("Номер задачи: ");
        int no = Integer.parseInt(scanner.nextLine().trim()); // Номер задачи
        // Выводим текущее описание задачи
        String task = taskList.get(no - 1);
        System.out.println("Задача: " + task);
        // Вводин новое описание задачи
        System.out.print("Новое описание задачи: ");
        task = scanner.nextLine();
        taskList.set(no - 1, task);
    }
}
