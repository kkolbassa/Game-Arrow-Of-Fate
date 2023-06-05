package org.example.missionsFactory;

import org.example.missions.Mission;
import org.example.missions.TundraMission;

public class TundraMissionFactory extends MissionFactory{
    private static TundraMissionFactory instance;
    public static TundraMissionFactory getInstance() {
        if (instance == null) {
            instance = new TundraMissionFactory();
        }
        return (TundraMissionFactory) instance;
    }
    @Override
    public Mission create(boolean significant) {
        int count = (int) (Math.random()*10);
        return new TundraMission("","",count,significant);
    }
}
