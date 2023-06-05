package org.example.missionsFactory;

import org.example.missions.Mission;

public abstract class MissionFactory {
    public abstract Mission create(boolean significant);
}
