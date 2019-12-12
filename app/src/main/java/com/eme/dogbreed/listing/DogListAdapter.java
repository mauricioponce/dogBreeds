package com.eme.dogbreed.listing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.eme.dogbreed.databinding.ListItemBinding;
import com.eme.dogbreed.model.Dog;
import com.eme.dogbreed.viewmodel.DogViewModel;

import timber.log.Timber;

public class DogListAdapter extends ListAdapter<Dog, DogListAdapter.ViewHolder> {

    private DogViewModel viewModel;

    protected DogListAdapter(DogViewModel viewModel) {
        super(new DogDiffCallback());
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dog item = getItem(position);
        holder.bind(createOnClickListener(item), item);
    }

    private View.OnClickListener createOnClickListener(Dog dog) {
        return (view) -> {
            Timber.d("createOnClickListener() called with: dog = [" + dog + "]");
            viewModel.setSelected(dog);
        };
    }

    /*******************************************
     ******* Callback product diff *************
     *******************************************/

    private static class DogDiffCallback extends DiffUtil.ItemCallback<Dog> {

        @Override
        public boolean areItemsTheSame(@NonNull Dog oldItem, @NonNull Dog newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Dog oldItem, @NonNull Dog newItem) {
            return areItemsTheSame(oldItem, newItem);
        }
    }

    /*******************************************
     *************** ViewHolder ****************
     *******************************************/
    public class ViewHolder extends RecyclerView.ViewHolder {
        ListItemBinding binding;

        private ViewHolder(ListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(@NonNull View.OnClickListener listener, @NonNull Dog dogBreed) {
            this.binding.setClickListener(listener);
            this.binding.setDogBreed(dogBreed);
            this.binding.executePendingBindings();
        }
    }
}
