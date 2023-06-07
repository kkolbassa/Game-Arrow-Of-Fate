package org.example.missionsFactory;

import org.example.missions.Mission;
import org.example.missionsReader.MissionData;
import org.example.missionsReader.MissionExcelReader;

import java.util.ArrayList;
import java.util.List;

public abstract class MissionFactory {
    protected MissionExcelReader missionExcelReader = new MissionExcelReader();
    protected static ArrayList<MissionData> missionData;
    protected List<MissionData> filteredMissions;

    public MissionFactory() {
        if(missionData == null) missionData = missionExcelReader.createMissionsFromExcel();
    }

    public abstract Mission create(boolean significant);
}
