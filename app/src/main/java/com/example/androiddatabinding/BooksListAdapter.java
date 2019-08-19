package com.example.androiddatabinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.example.androiddatabinding.databinding.LayoutBookRowBinding;

import java.util.List;

public class BooksListAdapter extends RecyclerView.Adapter<BooksListAdapter.MyViewHolder> {

    private List<Book> postList;
    private LayoutInflater layoutInflater;
    private RowItemClickListener listener;


    public BooksListAdapter(List<Book> postList, RowItemClickListener listener) {
        this.postList = postList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        LayoutBookRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.layout_book_row, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.binding.setBook(postList.get(position));
        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onRowClicked(postList.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final LayoutBookRowBinding binding;

        public MyViewHolder(final LayoutBookRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;
        }
    }

    public interface RowItemClickListener {
        void onRowClicked(Book book);
    }

}