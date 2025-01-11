package com.example.datingapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class VideoChatFragment extends Fragment {

    private ImageButton muteButton, cameraButton, cameraMuteButton, endCallButton;
    private boolean isMuted = false, isCameraOn = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for the fragment
        View view = inflater.inflate(R.layout.fragment_video_chat, container, false);

        // Initialize buttons
        muteButton = view.findViewById(R.id.mute_button);
        cameraButton = view.findViewById(R.id.camera_button);
        cameraMuteButton = view.findViewById(R.id.camera_mute_button);
        endCallButton = view.findViewById(R.id.end_call_button);

        // Set OnClickListener for Mute Button
        muteButton.setOnClickListener(v -> {
            isMuted = !isMuted;
            if (isMuted) {
                muteButton.setImageResource(R.drawable.micon_img);  // Change to unmute icon
            } else {
                muteButton.setImageResource(R.drawable.mute);  // Change to mute icon
            }
            // Logic for muting the audio goes here (e.g., mute/unmute microphone)
        });

        // Set OnClickListener for Camera Flip Button
        cameraButton.setOnClickListener(v -> {
            // Logic for flipping camera goes here (e.g., switch between front and back camera)
            // For now, just changing the icon for demo purposes
            cameraButton.setImageResource(R.drawable.camera_flip);  // Change the icon after flip
        });

        // Set OnClickListener for Camera Mute Button
        cameraMuteButton.setOnClickListener(v -> {
            isCameraOn = !isCameraOn;
            if (isCameraOn) {
                cameraMuteButton.setImageResource(R.drawable.video_off);  // Show camera off icon
            } else {
                cameraMuteButton.setImageResource(R.drawable.camera_img);  // Show camera on icon
            }
            // Logic for muting/unmuting camera (e.g., turn off/on camera stream)
        });

        // Set OnClickListener for End Call Button
        endCallButton.setOnClickListener(v -> {
            // End the call logic goes here
            getActivity().getSupportFragmentManager().popBackStack();  // Example: go back to previous fragment/activity
        });

        return view;
    }
}
