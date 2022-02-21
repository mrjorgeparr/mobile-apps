# mobile-apps
Source code for mobile applications project done in UC3M

# Ideas
* Sistema de ranking

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
