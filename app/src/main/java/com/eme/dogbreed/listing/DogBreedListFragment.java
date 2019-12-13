package com.eme.dogbreed.listing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.eme.dogbreed.databinding.FragmentDogBreedListBinding;
import com.eme.dogbreed.util.InjectorUtils;
import com.eme.dogbreed.viewmodel.DogViewModel;
import com.eme.dogbreed.viewmodel.DogViewModelFactory;

import timber.log.Timber;

public class DogBreedListFragment extends Fragment {

    private DogListAdapter dogListAdapter;

    private FragmentDogBreedListBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DogViewModel viewModel = ViewModelProviders.of(getActivity(), new DogViewModelFactory(InjectorUtils.getDogRepository(getContext()))).get(DogViewModel.class);

        dogListAdapter = new DogListAdapter(viewModel);

        viewModel.getDogs().observe(this, dogs -> {
            Timber.d("observing changes for dogs list %d", dogs.size());

            dogListAdapter.submitList(dogs);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentDogBreedListBinding.inflate(inflater, container, false);

        setupAdapter();

        return binding.getRoot();
    }

    private void setupAdapter() {
        Timber.d("setupAdapter() called");
        binding.dogBreedList.setAdapter(dogListAdapter);
    }
}
