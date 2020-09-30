# Peer_Study_Helping_Backend
This is the working repository for group project Peer Study Helping platform.

**This is the backend project repository, if you are looking for the front project, checkout https://github.sydney.edu.au/ELEC5619-2020/Peer_Study_Helping_Frontend**
## Project setup
### Dependencies that need to be installed manually
- Java: Open JDK 11
- MySQL: 8

### MySQL setup
- Port: `3306`
- Database name: `peerhelping`
- Database user: `root`
- Database password: `mysql_pwd`

### Connect MySQL in IntelliJ
Click `View -> Tool Windows -> Database`, then click the `+` button and add MySQL as datasource.

In the configuration:

**General**
- `Host`: `localhost`
- `User`: `root`
- `Password`: `mysql_pwd`
- `Database`: `peerhelping`
- `Port`: `3306`

**Advanced**

Find `serverTimezone`, set the value to `UTC`, then apply.

#### Create table in database
**Create database before you use the SQL script!**
SQL script location: `./src/main/resources/static/elec5619_assignment.sql`

Run this script in IntelliJ.

#### Table
1. courses

|Field name|Type|Null type|key|
|----|----|----|----|
|courseId|int|Not Null|yes|
|description|varchar(45)|Not Null||
|name|varchar(45)|Not Null||
|courseCode|varchar(45)|Not Null||

2. users

|Field name|Type|Null type|key|
|----|----|----|----|
|sid|int|Not Null|yes|
|first_name|varchar(45)|Not Null||
|last_name|varchar(45)|Not Null||
|gender|varchar(45)|||
|password|varchar(45)|Not Null||

3. matches

|Field name|Type|Null type|key|
|----|----|----|----|
|matchId|int|Not Null|yes|
|studentSid|int)|Not Null||
|tutorSid|int|Not Null||
|courseId|int|Not Null||
|matchTime|varchar(45)|Not Null||

4. calendar

|Field name|Type|Null type|key|
|----|----|----|----|
|sid|int|Not Null||
|availableTimeStarts|varchar(45)|Not Null||
|availableTimeDuration|varchar(45)|Not Null||

5. intrestedIn

|Field name|Type|Null type|key|
|----|----|----|----|
|sid|int|Not Null||
|courseId|int|Not Null||
|teach|varchar(45)|Not Null||

