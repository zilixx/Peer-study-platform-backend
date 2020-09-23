# Peer_Study_Helping_Backend
This is the working repository for group project Peer Study Helping platform.

**This is the backend project repository, if you are looking for the front project, checkout https://github.sydney.edu.au/ELEC5619-2020/Peer_Study_Helping_Frontend**
## Project setup
### Dependencies that need to be installed manually
- Java: Open JDK 11
- MySQL: 8

### MySQL setup
- Port: `3306`
- Database: `peerhelping`
- Table: `users`

### Connect MySQL in IntelliJ
Click `View -> Database`, then click the `+` button and add MySQL as datasource.

In the configuration:

**General**
- `Host`: `localhost`
- `User`: `root`
- `Password`: `mysql_pwd`
- `Database`: `peerhelping`
- `Port`: `3306`

**Advanced**

Find `serverTimezone`, set the value to `UTC`, then apply.
