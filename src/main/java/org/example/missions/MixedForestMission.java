package org.example.missions;

import org.example.items.Item;
import org.example.items.SilverThread;

public class MixedForestMission extends Mission{
    public MixedForestMission(String description, String task, int countAction, boolean significant) {
        super(description, task, countAction, significant);
    }

    @Override
    public Item getReward() {
        if(isSignificant()) return new SilverThread();
        else return null;
    }

}
