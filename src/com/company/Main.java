package com.company;

import java.util.Scanner;

class Game {
    String player1;
    String player2;
    byte randomNumber;
    private static Scanner in;

    public void setRandomNumber() {
        randomNumber = (byte) (Math.random() * 30);
        System.out.printf("Число успешно сгенерирован, ваше число %d, нажмите на любую кнопку для возврата: %n", randomNumber);
        in.nextLine();
    }

    public Game() {
        in = new Scanner(System.in);
    }

    public void setPlayersName() {

        System.out.print("Введите имя первого игрока: ");
        player1 = in.next();
        System.out.print("Введите имя второго игрока: ");
        player2 = in.next();

        System.out.printf("Имена успешно введины, нажмите на любую кнопку для возврата: %n");
        in.nextLine();
    }

    public void startGame() {

        boolean stepPlayers = true;
        String actualPlayer;
        byte numberPlayer;
        byte rNumber = randomNumber;

        System.out.printf("Игра начинается!%n" +
                "Игрок 1 - %s%n" +
                "Игрок 2 - %s%n" +
                "Рандомное число: %d%n", player1, player2, randomNumber);

        while (true) {

            actualPlayer = stepPlayers ? player1 : player2;

            System.out.printf("Ходит игрок - %s%n", actualPlayer);
            System.out.print("Введите число от 1 до 4: ");

            numberPlayer = in.nextByte();
            if (numberPlayer < 1 || numberPlayer > 4) {
                System.out.println("Вы ввели неверное число, попробуйте заново");
                continue;
            }

            rNumber -= numberPlayer;
            if (rNumber <= 0) {
                System.out.printf("Игрок %s, победил!!", actualPlayer);
                System.out.println("Нажмите на любую кнопку для возврата:");
                in.nextLine();
                break;
            }
            System.out.printf("Игрок %s, ввел %d, осталось %d из %d%n", actualPlayer, numberPlayer, rNumber, randomNumber);
            stepPlayers = !stepPlayers;
        }
    }

}

public class Main {

    private static Scanner in;

    public static void main(String[] args) {

        in = new Scanner(System.in);
        Game game = new Game();

        while (true) {
            System.out.println("Выберите один из пунктов:\n" +
                    "1.Ввести имена игроков.\n" +
                    "2.Задать рандомное число.\n" +
                    "3.Начать игру\n" +
                    "4.Выйти");

            switch (in.nextByte()) {
                case 1 -> game.setPlayersName();
                case 2 -> game.setRandomNumber();
                case 3 -> game.startGame();
                case 4 -> System.exit(0);
                default -> System.out.println("Соре, я не знаю такую команду");
            }

        }
    }

}

