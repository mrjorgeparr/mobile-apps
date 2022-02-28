# mobile-apps
Source code for mobile applications project done in UC3M

# Ideas
* Sistema de ranking

# Enlaces de interés

- Build your first android app using java: https://developer.android.com/codelabs/build-your-first-android-app#3
- Part 1 of a android app development course in java (quite long): https://www.youtube.com/watch?v=fis26HvvDII
- Part 2 of the course: https://www.youtube.com/watch?v=RcSHAkpwXAQ&t=0s

## About the data base SQL lite
|BUSINESS| | |
|----------|-|-|
|id|int|Primary key|
|name|char| | |
|longitude| float| |
|latitude| float| |
|description| char| |
|keywords| char| |
|rating| float| |
|reviews| int| |

|SCHEDULE| | |
|-|-|-|
|language|char| |
|business_id| int| Foreign Key|
|hours| char| |

|USER| | |
|-|-|-|
|id| int| Primary Key|
|name| char| |
|email| | |
|longitude| float| |
|latitude| float| |
