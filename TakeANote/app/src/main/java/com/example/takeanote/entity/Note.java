package com.example.takeanote.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

import static androidx.room.ForeignKey.*;

@Getter
@Entity(tableName = "note_table")
public class Note {

    @PrimaryKey(autoGenerate = true)
    @Setter
    private Long noteId;
    private String title;
    private String description;
    private int priority;
    @Setter
    @ForeignKey( entity = Category.class, parentColumns = "id", childColumns = "category_id", onDelete = CASCADE)
    @ColumnInfo(name = "category_id")
    private Long categoryId;

    public Note(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
}
