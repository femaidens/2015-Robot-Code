package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CameraServer;

public class Camera
{
  public staic void Camera {
    CameraServer server = CameraServer.getInstance();
    server.setQuality(50);
    server.startAutomaticCapture("cam0"); //must look in RoboRio Webdashboard for the actual name
    //http://wpilib.screenstepslive.com/s/4485/m/24166/l/262266-roborio-webdashboard
    //afterwards enable usb camera viewer on smartdashboard
    //http://www.chiefdelphi.com/forums/attachment.php?attachmentid=17804&d=1420947396
  }
}

//code from http://www.chiefdelphi.com/forums/showthread.php?t=132606&highlight=smartdashboard+camera
