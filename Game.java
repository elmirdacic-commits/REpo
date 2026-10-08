package com.d;

import java.util.ArrayList;
import java.util.List;


class Game {
    private Player player;
    private Enemy[] enemies;
    private int enemyCount;
    private List<String> eventLog;

    public Game(Player player, int maxEnemies) {
        this.player = player;
        this.enemies = new Enemy[maxEnemies];
        this.enemyCount = 0;
        this.eventLog = new ArrayList<>();
        eventLog.add("Igra je inicijalizovana sa igračem: " + player.getName());
    }

    public void addEnemy(Enemy enemy) {
        if (enemyCount < enemies.length) {
            enemies[enemyCount++] = enemy;
            eventLog.add("Dodat neprijatelj tipa: " + enemy.getType());
        } else {
            eventLog.add("Greška: Niz neprijatelja je popunjen!");
        }
    }

    public boolean checkCollision(Player p, Enemy e) {
        return p.getX() < e.getX() + e.getWidth() &&
               p.getX() + p.getWidth() > e.getX() &&
               p.getY() < e.getY() + e.getHeight() &&
               p.getY() + p.getHeight() > e.getY();
    }

    public void decreaseHealth(Player p, int amount) {
        int newHealth = Math.max(0, p.getHealth() - amount);
        p.setHealth(newHealth);
        eventLog.add("Igraču " + p.getName() + " smanjen health za " + amount + ". Trenutni health: " + newHealth);
    }

    public void decreaseHealth(Enemy e, int amount) {
        int newHealth = Math.max(0, e.getHealth() - amount);
        e.setHealth(newHealth);
        eventLog.add("Neprijatelju tipa " + e.getType() + " smanjen health za " + amount + ". Trenutni health: " + newHealth);
    }

    public Enemy[] findByType(String type) {
        int count = 0;
        for (int i = 0; i < enemyCount; i++) {
            if (enemies[i].getType().equalsIgnoreCase(type)) {
                count++;
            }
        }
        
        Enemy[] found = new Enemy[count];
        int index = 0;
        for (int i = 0; i < enemyCount; i++) {
            if (enemies[i].getType().equalsIgnoreCase(type)) {
                found[index++] = enemies[i];
            }
        }
        return found;
    }

    public boolean collidingWithPlayer(Enemy enemy) {
        return checkCollision(player, enemy);
    }

    public void resolveCollisions() {
        eventLog.add("Pokrenuta provjera i rješavanje kolizija...");
        for (int i = 0; i < enemyCount; i++) {
            if (enemies[i] != null && enemies[i].getHealth() > 0) {
                if (collidingWithPlayer(enemies[i])) {
                    eventLog.add("DETEKTOVANA KOLIZIJA: Igrač i neprijatelj tipa " + enemies[i].getType());
                    decreaseHealth(player, 15);
                    decreaseHealth(enemies[i], 30);
                }
            }
        }
    }

    public void printEventLog() {
        System.out.println("\n--- DNEVNIK DOGAĐAJA (EVENT LOG) ---");
        for (String log : eventLog) {
            System.out.println(log);
        }
    }

    public void printGameStatus() {
        System.out.println("\n--- STANJE IGRE ---");
        System.out.println(player);
        System.out.println("Aktivni neprijatelji:");
        for (int i = 0; i < enemyCount; i++) {
            System.out.println("  " + enemies[i]);
        }
    }
}

