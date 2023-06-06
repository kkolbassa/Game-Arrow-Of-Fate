package org.example.missions;

import org.example.items.Item;
import org.example.items.Pass;

public class TundraMission extends Mission{
    public TundraMission(String description, String task, int countAction, boolean significant) {
        super(description, task, countAction, significant);
    }

    @Override
    public Item getReward() {
        if(isSignificant()) return new Pass();
        else return null;
    }

}
