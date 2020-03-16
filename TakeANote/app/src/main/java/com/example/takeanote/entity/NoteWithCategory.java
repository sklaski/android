package com.example.takeanote.entity;

import androidx.room.Embedded;

import com.example.takeanote.entity.Category;
import com.example.takeanote.entity.Note;

public class NoteWithCategory {

    @Embedded
    public Note node;

    @Embedded(prefix = "c_")
    public Category category;
}
