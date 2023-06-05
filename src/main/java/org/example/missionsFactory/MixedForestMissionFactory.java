package org.example.missionsFactory;

import org.example.missions.Mission;
import org.example.missions.MixedForestMission;

public class MixedForestMissionFactory extends MissionFactory{
    private static MixedForestMissionFactory instance;
    public static MixedForestMissionFactory getInstance() {
        if (instance == null) {
            instance = new MixedForestMissionFactory();
        }
        return (MixedForestMissionFactory) instance;
    }

    @Override
    public Mission create(boolean significant) {
        int count = (int) (Math.random()*10);
        return new MixedForestMission("","",count,significant);
    }
}
