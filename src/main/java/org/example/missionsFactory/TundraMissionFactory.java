package org.example.missionsFactory;

import org.example.missions.Mission;
import org.example.missions.TundraMission;

import java.util.stream.Collectors;

public class TundraMissionFactory extends MissionFactory{
    private static TundraMissionFactory instance;
    public static TundraMissionFactory getInstance() {
        if (instance == null) {
            instance = new TundraMissionFactory();
        }
        return (TundraMissionFactory) instance;
    }
    public TundraMissionFactory() {
         filteredMissions = missionData.stream()
                .filter(mission -> mission.getRegion().equals("Тундра"))
                .collect(Collectors.toList());
    }
    @Override
    public Mission create(boolean significant) {
        int chosenMission = (int) (Math.random()*filteredMissions.size());
        int count = (int) (Math.random()*10)+1;

        return new TundraMission(filteredMissions.get(chosenMission).getDescription(),filteredMissions.get(chosenMission).getTask(),count,significant);
    }
}
