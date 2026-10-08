package com.d;


class Enemy {
    private String type;
    private int x;
    private int y;
    private int width;
    private int height;
    private int health;

    public Enemy(String type, int x, int y, int width, int height, int health) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = health;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getX() { return x; }
    public void setX(int x) { this.x = x; }

    public int getY() { return y; }
    public void setY(int y) { this.y = y; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    
    public String toString() {
        return "Enemy [type=" + type + ", x=" + x + ", y=" + y + 
               ", width=" + width + ", height=" + height + ", health=" + health + "]";
    }
}

