package org.devoxx4kids.minecraft.tnt;

import javax.ejb.Singleton;

/**
 * @author arungupta
 */
@Singleton
public class TNTDatabase {
    private int howMany;
    private int spreadX;
    private int spreadY;
    private int spreadZ;

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public int getSpreadX() {
        return spreadX;
    }

    public void setSpreadX(int spreadX) {
        this.spreadX = spreadX;
    }

    public int getSpreadY() {
        return spreadY;
    }

    public void setSpreadY(int spreadY) {
        this.spreadY = spreadY;
    }

    public int getSpreadZ() {
        return spreadZ;
    }

    public void setSpreadZ(int spreadZ) {
        this.spreadZ = spreadZ;
    }
}
