package task1;

import java.util.concurrent.TimeUnit;

public class TimeDisplayProgram {

    public static void main(String[] args) {
        // Створення та запуск потоку для відображення часу
        Thread timeDisplayThread = new Thread(() -> {
            long startTime = System.currentTimeMillis();
            while (true) {
                long currentTime = System.currentTimeMillis();
                long elapsedTimeInSeconds = TimeUnit.MILLISECONDS.toSeconds(currentTime - startTime);
                System.out.println("Пройшло часу: " + elapsedTimeInSeconds + " секунд");
                try {
                    Thread.sleep(1000); // Почекати 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Створення та запуск потоку для виведення повідомлення кожні 5 секунд
        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000); // Почекати 5 секунд
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Запуск обох потоків
        timeDisplayThread.start();
        messageThread.start();
    }
}