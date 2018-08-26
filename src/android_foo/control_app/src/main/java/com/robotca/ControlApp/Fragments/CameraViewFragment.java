package com.robotca.ControlApp.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robotca.ControlApp.ControlApp;
import com.robotca.ControlApp.Core.RobotController;
import com.robotca.ControlApp.R;

import org.ros.android.BitmapFromCompressedImage;
import org.ros.android.view.RosImageView;
import org.ros.message.MessageListener;

import sensor_msgs.CompressedImage;

/**
 * Fragment for showing the view from the Robot's camera.
 *
 * Created by Michael Brunson on 11/7/15.
 */
public class CameraViewFragment extends RosFragment {

    private RosImageView<sensor_msgs.CompressedImage> cameraView;
    private TextView noCameraTextView;
    private RobotController controller;

    /**
     * Default Constructor.
     */
    public CameraViewFragment(){}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        @SuppressLint("InflateParams") View view = inflater.inflate(R.layout.fragment_camera_view, null);
        noCameraTextView = (TextView)view.findViewById(R.id.noCameraTextView);
        //noinspection unchecked
        cameraView = (RosImageView<sensor_msgs.CompressedImage>) view.findViewById(R.id.camera_fragment_camera_view);

        String imageTopic = PreferenceManager.getDefaultSharedPreferences(view.getContext())
                .getString(view.getContext().getString(R.string.prefs_camera_topic_edittext_key),
                        view.getContext().getString(R.string.camera_topic));
        Log.w("setCustom topic is ", imageTopic);
        if(imageTopic.isEmpty())
            cameraView.setTopicName(PreferenceManager.getDefaultSharedPreferences(getActivity()).getString("edittext_camera_topic", getString(R.string.camera_topic)));
        else
            cameraView.setTopicName(imageTopic);
 
        cameraView.setMessageType(CompressedImage._TYPE);
        cameraView.setMessageToBitmapCallable(new BitmapFromCompressedImage());

        try {
            controller = ((ControlApp) getActivity()).getRobotController();
        }
        catch(Exception ignore){
        }

        // Create a message listener for getting camera data
        if(controller != null){
            controller.setCameraMessageReceivedListener(new MessageListener<CompressedImage>() {
                @Override
                public void onNewMessage(CompressedImage compressedImage) {
                    if (compressedImage != null) {
                        controller.setCameraMessageReceivedListener(null);
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                noCameraTextView.setVisibility(View.GONE);
                            }
                        });
                    }
                }
            });
        }

        if (nodeConfiguration != null)
            nodeMainExecutor.execute(cameraView, nodeConfiguration.setNodeName("android/fragment_camera_view"));

        return view;
    }

    @Override
    void shutdown() {
        nodeMainExecutor.shutdownNodeMain(cameraView);
    }
}
