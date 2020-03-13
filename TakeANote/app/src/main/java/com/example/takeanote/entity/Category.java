package com.example.takeanote.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Entity(tableName = "category_table")
public class Category {

    @PrimaryKey(autoGenerate = true)
    @Setter
    private Long categoryId;
    private String category;

    public Category(String category) {
        this.category = category;
    }
}
