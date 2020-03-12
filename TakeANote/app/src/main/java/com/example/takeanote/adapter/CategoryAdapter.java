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
import com.example.takeanote.entity.Category;

public class CategoryAdapter extends ListAdapter<Category, CategoryAdapter.CategoryHolder> {
    private static final DiffUtil.ItemCallback<Category> DIFF_CALLBACK = new DiffUtil.ItemCallback<Category>() {
        @Override
        public boolean areItemsTheSame(Category oldItem, Category newItem) {
            return oldItem.getId().equals( newItem.getId() );
        }

        @Override
        public boolean areContentsTheSame(Category oldItem, Category newItem) {
            return oldItem.getCategory().equals( newItem.getCategory() );
        }
    };

    private OnItemClickListener listener;

    public CategoryAdapter() {
        super( DIFF_CALLBACK );
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.note_item, parent, false );
        return new CategoryHolder( itemView );
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category currentCategory = getItem( position );
        holder.textViewCategory.setText( currentCategory.getCategory() );
    }

    public Category getCategoryAt(int position) {
        return getItem( position );
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(Category category);
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        private TextView textViewCategory;

        public CategoryHolder(View itemView) {
            super( itemView );
            textViewCategory = itemView.findViewById( R.id.text_view_category );

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
