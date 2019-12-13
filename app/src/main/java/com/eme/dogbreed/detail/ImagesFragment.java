package com.eme.dogbreed.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.eme.dogbreed.databinding.FragmentImagesBinding;
import com.eme.dogbreed.util.InjectorUtils;
import com.eme.dogbreed.viewmodel.DogViewModel;
import com.eme.dogbreed.viewmodel.DogViewModelFactory;

import timber.log.Timber;

public class ImagesFragment extends Fragment {

    private DogViewModel viewModel;

    private ImageListAdapter imageListAdapter;

    private FragmentImagesBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = ViewModelProviders.of(getActivity(), new DogViewModelFactory(InjectorUtils.getDogRepository(getContext()))).get(DogViewModel.class);

        this.imageListAdapter = new ImageListAdapter();

        viewModel.getImages().observe(this, strings -> {
            this.imageListAdapter.submitList(strings);
        });


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentImagesBinding.inflate(inflater, container, false);

        viewModel.getSelected().observe(this, binding::setDogBreed);

        setupAdapter();

        return binding.getRoot();
    }

    private void setupAdapter() {
        binding.imagesList.setAdapter(this.imageListAdapter);
    }
}
