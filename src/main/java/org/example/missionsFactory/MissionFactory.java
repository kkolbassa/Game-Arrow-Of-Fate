package org.example.missionsFactory;

import org.example.missions.Mission;
import org.example.ExcelReader.MissionData;

import java.util.ArrayList;
import java.util.List;

public abstract class MissionFactory {
    protected static ArrayList<MissionData> missionData = new ArrayList<>();
    protected List<MissionData> filteredMissions;

    public static void addMissionData(MissionData oneMissionData){
        missionData.add(oneMissionData);
    }

    public abstract Mission create(boolean significant);
}
