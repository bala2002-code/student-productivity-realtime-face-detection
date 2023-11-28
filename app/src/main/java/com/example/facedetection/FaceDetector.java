package com.example.facedetection;

import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetectorOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;

public class FaceDetector {

    private FaceDetectorOptions options;
    private FaceDetector detector;

    public FaceDetector() {
        options = new FaceDetectorOptions.Builder()
                .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
                .build();

        detector = FaceDetector.newInstance(options);
    }

    private static FaceDetector newInstance(FaceDetectorOptions options) {
    }

    public List<Face> detectFaces(InputImage inputImage) throws IOException {
        List<Face> faces = new ArrayList<>();

        Task<List<Face>> result = detector.process(inputImage);

        result.addOnCompleteListener(new OnCompleteListener<List<Face>>() {
            @Override
            public void onComplete(@NonNull Task<List<Face>> task) {
                if (task.isSuccessful()) {
                    // Get the list of faces from the task.
                    List<Face> faces = task.getResult();

                    // Do something with the list of faces.
                } else {
                    // Handle the failure.
                }
            }
        });

        return faces;
    }
}
