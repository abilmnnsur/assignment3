package model;

public class MapStats {
    private final String mapName;
    private final int matchesCount;

    public MapStats(String mapName, int matchesCount) {
        this.mapName = mapName;
        this.matchesCount = matchesCount;
    }

    public String getMapName() { return mapName; }
    public int getMatchesCount() { return matchesCount; }
}