package com.example.datingapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.yalantis.library.Koloda;
import com.yalantis.library.KolodaListener;

import java.util.ArrayList;
import java.util.List;

public class PeopleFragment extends Fragment {

    private SwipeAdapter adapter;
    private List<Integer> list;
    private Koloda koloda;
    private LottieAnimationView heartAnimationView, crossAnimationView;

    @SuppressLint("WrongViewCast")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people, container, false);

        // Initialize views
        koloda = view.findViewById(R.id.koloda);
        heartAnimationView = view.findViewById(R.id.heart_animation);
        crossAnimationView = view.findViewById(R.id.cross_animation_view);

        // Populate the list with images
        list = new ArrayList<>();
        list.add(R.drawable.male);
        list.add(R.drawable.facebook_img);
        list.add(R.drawable.male_img);
        list.add(R.drawable.female);
        list.add(R.drawable.female_img);

        // Set up the adapter and assign it to Koloda
        adapter = new SwipeAdapter(requireContext(), list);
        koloda.setAdapter(adapter);

        // Koloda listener
        koloda.setKolodaListener(new KolodaListener() {
            @Override
            public void onCardLongPress(int position) {
                Vibrator vibrator = (Vibrator) requireContext().getSystemService(Context.VIBRATOR_SERVICE);
                if (vibrator != null) {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(60, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        vibrator.vibrate(500);
                    }
                }
                Toast.makeText(requireContext(), "<- Please Swipe ->", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCardSingleTap(int position) {
                Intent intent = new Intent(requireActivity(), OnSingleTapActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCardSwipedLeft(int position) {
                playAnimation(crossAnimationView);
                Toast.makeText(requireContext(), "Pass", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCardSwipedRight(int position) {
                playAnimation(heartAnimationView);
                Toast.makeText(requireContext(), "Liked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onEmptyDeck() {
                Toast.makeText(requireContext(), "No more cards!", Toast.LENGTH_SHORT).show();
            }

            // Unused methods
            @Override public void onClickLeft(int position) {}
            @Override public void onClickRight(int position) {}
            @Override public void onCardDrag(int position, View card, float progress) {}
            @Override public void onCardDoubleTap(int position) {}
            @Override public void onNewTopCard(int position) {}
        });

        return view;
    }

    private void playAnimation(LottieAnimationView animationView) {
        animationView.setVisibility(View.VISIBLE);

        // Set the speed of the animation to 2.5x
        animationView.setSpeed(2.5f);

        animationView.playAnimation();
        animationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                animationView.setVisibility(View.GONE);
            }
        });
    }
}
