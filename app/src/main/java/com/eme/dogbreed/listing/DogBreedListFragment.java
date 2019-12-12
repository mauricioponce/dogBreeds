package com.eme.dogbreed.listing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.eme.dogbreed.databinding.FragmentDogBreedListBinding;
import com.eme.dogbreed.util.InjectorUtils;
import com.eme.dogbreed.viewmodel.DogViewModel;
import com.eme.dogbreed.viewmodel.DogViewModelFactory;

import timber.log.Timber;

public class DogBreedListFragment extends Fragment {

    private DogViewModel viewModel;

    private FragmentDogBreedListBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = (DogViewModel) new DogViewModelFactory(InjectorUtils.getDogRepository(getContext())).create(DogViewModel.class);


        viewModel.getDogs().observe(this, dogs -> {
            Timber.d("observing changes for dogs list %d", dogs.size());

            dogs.stream().forEach(dog -> Timber.d(dog.toString()));
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentDogBreedListBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}
