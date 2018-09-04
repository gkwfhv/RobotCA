# RobotCA

# =======================
# NEVER ALLOW ANDROID STUDIO TO UPDATE YOUR BUILD TOOLS.SELECT 'DO NOT ASK AGAIN FOR THIS PROJECT
# =======================

#### ROS-autom Team

This project is active again.

###### Prepare your distro for compile:

+ Download Android Studio from https://developer.android.com/studio/index.html#linux-bundle
+ Extract the zip file into a folder at your home dir(i.e. android_ide) and run the bin/studio.sh script
+ Select Standard setup and finish the installation.
+ When the download is done, press on the Configure option on the bottom side and select SDK manager
+ From SDK platforms select all API levels from 26 to 22
+ From SDK Tools select 'Show package details'
+ Select 21.1.2 ,25.0.2 and 26.0.0
+ Press apply and ok
+ Accept the license and let it download the required files
+ Press ok to SDK manager and close the Android Studio
+ Install the JDK8 by running 
	
	$ sudo add-apt-repository ppa:openjdk-r/ppa
	$ sudo apt-get update
	$ sudo apt-get install openjdk-8-jdk
+ Run the android studio: . /path/to/studio/bin/studio.sh
+ File->Open->RobotCA/src/android_foo folder and press OK.
+ Wait until Gradle is being initialized.
+ On the plugin update window,select "Dont remind me again for this project".
+ File->Other Settings->Default Project Structure->Untick default JDK and add this directory: /usr/lib/jvm/java-1.8.0-openjdk-amd64
+ Close Android Studio and run 
	$ sudo apt-get install lib32z1 lib32ncurses5 lib32stdc++6
+ Open Android Studio again and wait gradle to be initialized

Optional:
Run
+ touch ~/.gradle/gradle.properties && echo "org.gradle.daemon=true" >> ~/.gradle/gradle.properties
+ echo "org.gradle.parallel=true" >> ~/.gradle/gradle.properties

This is highly experimental and its not recommended
+ echo "org.gradle.configureondemand=true" >> ~/.gradle/gradle.properties

to speed up the build process.

#### Troubleshoot

1)======================================
If you get aapt exited with code 127
or
Error:Execution failed for task ':control_app_lib:processReleaseResources'.
> A problem occurred starting process 'command '/home/USERNAME/Android/Sdk/build-tools/21.1.2/aapt''
please run
sudo apt-get install lib32z1 lib32ncurses5 lib32stdc++6

2)======================================
Never Fix the Gradle Version that is mentioned in Messages.

#### Pin Android Studio to your launcher tab
+ Create a file called "AndroidStudio.desktop" and paste the following code:
```
[Desktop Entry]
Version=1.0
Type=Application
Name=Android Studio
Exec="/home/YOURNAME/FOLDER_TO_IDE/bin/studio.sh" %f
Icon=/home/YOURNAME/FOLDER_TO_IDE/bin/studio.png
Categories=Development;IDE;
Terminal=true
StartupNotify=false
StartupWMClass=jetbrains-android-studio
Name[en_GB]=android-studio.desktop
```
+ save it and then drag and drop that file on the launcher.
+ Click it to run the IDE.
+ When the IDE is opened right click on the new-second one icon that created on launcher
+ Press 'Lock to launcher'
+ exit the IDE
+ Remove the first icon

#### Credits

ros-autom team, Thessaloniki of Greece 2017

Originally posted by:
#### University of South Carolina  
###### CSCE 490 & 492 Capstone Design  

Our project is to design an Android application to control a robot. Specifically, the goal is to create a native Android tablet application to interface with a Robot Operating System (ROS) robot, Clearpath Robotics' HUSKY model, for direct drive, diagnostic, and navigation information. The application will have to process data from various sensors on the robot and display the information in a user understandable fashion. For example, the robot will have a laser ranging system which will be collecting data on the environment. The application must parse this data and display the environment that the robot "sees".

Dependencies:  
+ ROS
+ ROSJava
+ Android 4.0+ (API level 13+)

![Master Chooser](https://cloud.githubusercontent.com/assets/8508489/14839465/021d5f80-0bf9-11e6-9580-10fa54de7cfc.png)

![Main Layout](https://cloud.githubusercontent.com/assets/8508489/14839460/0201419c-0bf9-11e6-82c9-8e51ce85d48c.png)  

![Main Layout](https://raw.githubusercontent.com/iamzhuang/test1/master/app_cam.png) 
 
Client Information:  
Dr. Ioannis Rekleitis  
Assistant Professor  
University of South Carolina  

#### 联系我

QQ扫一扫二维码，加入我们，一起学习支持ROS技术发展。
ROS机器人操作系统QQ群号: [8346256](https://jq.qq.com/?_wv=1027&k=5sKaEzQ)

![Main Layout](https://raw.githubusercontent.com/iamzhuang/test1/master/ROS_QRCODE.png) 


