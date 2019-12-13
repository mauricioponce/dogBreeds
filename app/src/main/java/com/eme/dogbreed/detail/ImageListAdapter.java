package com.eme.dogbreed.detail;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.eme.dogbreed.databinding.ListImageItemBinding;

public class ImageListAdapter extends ListAdapter<String, ImageListAdapter.ViewHolder> {

    protected ImageListAdapter() {
        super(new ImageDiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListImageItemBinding binding = ListImageItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = getItem(position);
        holder.bind(item);
    }

    /*******************************************
     ******* Callback product diff *************
     *******************************************/

    private static class ImageDiffCallback extends DiffUtil.ItemCallback<String> {
        @Override
        public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return areItemsTheSame(oldItem, newItem);
        }
    }

    /*******************************************
     *************** ViewHolder ****************
     *******************************************/
    public class ViewHolder extends RecyclerView.ViewHolder {
        ListImageItemBinding binding;

        private ViewHolder(ListImageItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(@NonNull String imageUrl) {
            this.binding.setImageUrl(imageUrl);
            this.binding.executePendingBindings();
        }
    }
}
