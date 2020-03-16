package com.example.takeanote.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.takeanote.dao.NoteDao;
import com.example.takeanote.persistence.NoteDatabase;
import com.example.takeanote.entity.Note;
import com.example.takeanote.entity.NoteWithCategory;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;
    private LiveData<List<Note>> allNotes;
    private LiveData<List<NoteWithCategory>> allNotesWithCategory;

    public NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.getNoteDao();
        allNotes = noteDao.getAllNotes();
        allNotesWithCategory = noteDao.getAllNotesWithCategory();

    }

    public void insert(Note note) {
        new InsertNoteAsyncTask(noteDao).execute(note);
    }

    public void update(Note note) {

        new UpdateNoteAsyncTask(noteDao).execute(note);
    }

    public void delete(Note note) {

        new DeleteNoteAsyncTask(noteDao).execute(note);
    }

    public void deleteNoteWithId(long id) {

        new DeleteNoteWithIdAsyncTask(noteDao).execute(id);
    }

    public void deleteAllNotes() {

        new DeleteAllNotesAsyncTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {

        return allNotes;
    }

    public LiveData<List<NoteWithCategory>> getAllNotesWithCategory() {
        return allNotesWithCategory;
    }

    // static necessary, because it needs to be instantiated before the outer object is instantiated
    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao noteDao;

        private InsertNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.insert(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao noteDao;

        private UpdateNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.update(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDao noteDao;

        private DeleteNoteAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDao.delete(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteWithIdAsyncTask extends AsyncTask<Long, Void, Void> {

        private NoteDao noteDao;

        private DeleteNoteWithIdAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Long... ids) {
            noteDao.deleteNoteWithId(ids[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {

        private NoteDao noteDao;

        private DeleteAllNotesAsyncTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.deleteAllNotes();
            return null;
        }
    }
}
