package org.example.missionsFactory;

import org.example.missions.DesertMission;
import org.example.missions.Mission;

public class DesertMissionFactory extends MissionFactory{
    private static DesertMissionFactory instance;
    public static DesertMissionFactory getInstance() {
        if (instance == null) {
            instance = new DesertMissionFactory();
        }
        return (DesertMissionFactory) instance;
    }

    @Override
    public Mission create(boolean significant) {
        int count = (int) (Math.random()*10);
        return new DesertMission("","",count,significant);
    }
}
