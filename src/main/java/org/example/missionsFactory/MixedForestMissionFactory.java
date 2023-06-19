package org.example.missionsFactory;

import org.example.missions.Mission;
import org.example.missions.MixedForestMission;

import java.util.stream.Collectors;

public class MixedForestMissionFactory extends MissionFactory{
    private static MixedForestMissionFactory instance;
    public static MixedForestMissionFactory getInstance() {
        if (instance == null) {
            instance = new MixedForestMissionFactory();
        }
        return (MixedForestMissionFactory) instance;
    }
    public MixedForestMissionFactory() {
        filteredMissions = missionData.stream()
                .filter(mission -> mission.getRegion().equals("Смешанный лес"))
                .collect(Collectors.toList());
    }

    @Override
    public Mission create(boolean significant) {
        int count = (int) (Math.random()*2)+1;
        int chosenMission = (int) (Math.random()*filteredMissions.size());

        return new MixedForestMission(filteredMissions.get(chosenMission).getDescription(),filteredMissions.get(chosenMission).getTask(),count,significant);
    }
}
