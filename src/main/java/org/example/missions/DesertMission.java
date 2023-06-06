package org.example.missions;

import org.example.items.Item;
import org.example.items.LiveWater;

public class DesertMission extends Mission{
    public DesertMission(String description, String task, int countAction, boolean significant) {
        super(description, task, countAction, significant);
    }

    @Override
    public Item getReward() {
        if(isSignificant()) return new LiveWater();
        else return null;
    }

}
