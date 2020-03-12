package com.example.takeanote.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.takeanote.R;
import com.example.takeanote.entity.Note;

public class NoteAdapter extends ListAdapter<Note, NoteAdapter.NoteHolder> {
    private static final DiffUtil.ItemCallback<Note> DIFF_CALLBACK = new DiffUtil.ItemCallback<Note>() {
        @Override
        public boolean areItemsTheSame(Note oldItem, Note newItem) {
            return oldItem.getId().equals( newItem.getId() );
        }

        @Override
        public boolean areContentsTheSame(Note oldItem, Note newItem) {
            return oldItem.getTitle().equals( newItem.getTitle() ) &&
                    oldItem.getDescription().equals( newItem.getDescription() ) &&
                    oldItem.getPriority() == newItem.getPriority();
        }
    };

    private OnItemClickListener listener;

    public NoteAdapter() {
        super( DIFF_CALLBACK );
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.note_item, parent, false );
        return new NoteHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note currentNote = getItem( position );
        holder.textViewTitle.setText( currentNote.getTitle() );
        holder.textViewDescription.setText( currentNote.getDescription() );
        holder.textViewPriority.setText( String.valueOf( currentNote.getPriority() ) );
    }

    public Note getNoteAt(int position) {
        return getItem( position );
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Note note);
    }

    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView textViewTitle;
        private TextView textViewDescription;
        private TextView textViewPriority;

        public NoteHolder(View itemView) {
            super( itemView );
            textViewTitle = itemView.findViewById( R.id.text_view_title );
            textViewDescription = itemView.findViewById( R.id.text_view_description );
            textViewPriority = itemView.findViewById( R.id.text_view_priority );

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick( getItem( position ) );
                    }
                }
            } );
        }
    }
}