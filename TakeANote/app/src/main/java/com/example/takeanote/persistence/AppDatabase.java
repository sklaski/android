package com.example.takeanote.persistence;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.takeanote.entity.Category;
import com.example.takeanote.entity.Note;

import lombok.NonNull;

@Database(entities = {Note.class, Category.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    //singleton
    private static AppDatabase instance;
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate( db );
            new PopulateDbAsyncTask( instance ).execute();
        }
    };

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder( context.getApplicationContext(), AppDatabase.class, "note_database" )
                    .fallbackToDestructiveMigration()
                    .addCallback( roomCallback )
                    .build();
        }
        return instance;
    }

    public abstract NoteDao noteDao();
    public abstract CategoryDao categoryDao();

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private NoteDao noteDao;
        private  CategoryDao categoryDao;

        private PopulateDbAsyncTask(AppDatabase db) {
            categoryDao = db.categoryDao();
            noteDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.insert( new Category( "red" ) );
            categoryDao.insert( new Category( "blue" ) );
            categoryDao.insert( new Category( "green" ) );
            noteDao.insert( new Note( "Title 1", "Description 1", 1 ) );
            noteDao.insert( new Note( "Title 2", "Description 2", 2 ) );
            noteDao.insert( new Note( "Title 3", "Description 3", 3 ) );
            return null;
        }
    }
}
