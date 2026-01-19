package model;

public class Tag {
    private int tagId;
    private String name;

    public Tag(int tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public int getTagId() { return tagId; }
    public String getName() { return name; }
}
