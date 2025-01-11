package com.example.datingapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    private DrawerLayout drawerLayout;
    private CardView explorePremium;
    private CircleImageView img; // For profile layout image
    private CircleImageView navHeaderImg; // Navigation header image

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        explorePremium = rootView.findViewById(R.id.explorepremium);
        drawerLayout = rootView.findViewById(R.id.drawerLayout);
        NavigationView navigationView = rootView.findViewById(R.id.navigationView);
        img = rootView.findViewById(R.id.img);

        // Access the navigation header's ImageView
        View headerView = navigationView.getHeaderView(0); // Get the first header view
        navHeaderImg = headerView.findViewById(R.id.nav_header_img);

        // Retrieve the image URI passed from the hosting activity
        Intent intent = requireActivity().getIntent(); // Use requireActivity() to get the activity's Intent
        String imageUriString = intent.getStringExtra("imageUri");

        if (imageUriString != null) {
            Uri imageUri = Uri.parse(imageUriString);

            // Set the image in the profile fragment's ImageView
            img.setImageURI(imageUri);

            // Set the image in the navigation header's ImageView
            navHeaderImg.setImageURI(imageUri);
        }

        // Set up Explore Premium button
        explorePremium.setOnClickListener(v -> {
            Intent intent1 = new Intent(requireContext(), PlansActivity.class);
            startActivity(intent1);
            if (getActivity() != null) {
                getActivity().overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            }
        });

        return rootView;
    }
}
