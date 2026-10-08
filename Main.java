package com.d;

public class Main {
	

    public static void main(String[] args) {
        Player hero = new Player("Heroj", 10, 10, 30, 30, 100);

        Game game = new Game(hero, 3);

        Enemy e1 = new Enemy("Goblin", 20, 15, 25, 25, 50);
        Enemy e2 = new Enemy("Boss", 200, 200, 50, 50, 150);
        Enemy e3 = new Enemy("Goblin", 300, 300, 20, 20, 40);

        game.addEnemy(e1);
        game.addEnemy(e2);
        game.addEnemy(e3);

        game.printGameStatus();

        System.out.println("\nPretraga neprijatelja tipa 'Goblin':");
        Enemy[] goblini = game.findByType("Goblin");
        for (Enemy e : goblini) {
            System.out.println(e);
        }

        game.resolveCollisions();

        game.printGameStatus();
        game.printEventLog();
    }
}