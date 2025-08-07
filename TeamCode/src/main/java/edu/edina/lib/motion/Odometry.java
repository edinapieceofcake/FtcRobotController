package edu.edina.lib.motion;

public interface Odometry {
    void update();

    Pose2d getPoseEstimate();

    PoseVelocity2d getVelocityEstimate();
}


