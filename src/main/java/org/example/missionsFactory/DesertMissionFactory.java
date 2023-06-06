package org.example.missionsFactory;

import org.example.missions.DesertMission;
import org.example.missions.Mission;

import java.util.stream.Collectors;

public class DesertMissionFactory extends MissionFactory{
    private static DesertMissionFactory instance;
    public static DesertMissionFactory getInstance() {
        if (instance == null) {
            instance = new DesertMissionFactory();
        }
        return (DesertMissionFactory) instance;
    }

    public DesertMissionFactory() {
        filteredMissions = missionData.stream()
                .filter(mission -> mission.getRegion().equals("Пустыня"))
                .collect(Collectors.toList());
    }

    @Override
    public Mission create(boolean significant) {
        int count = (int) (Math.random()*10)+1;
        int chosenMission = (int) (Math.random()*filteredMissions.size());

        return new DesertMission(filteredMissions.get(chosenMission).getDescription(),filteredMissions.get(chosenMission).getTask(),count,significant);
    }
}
