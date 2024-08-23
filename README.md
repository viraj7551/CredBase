
# Problem Statement 	&#x1f30b;

Today users are getting engaged to infinite number of sites whether it may be related to profession, social, entertainment.
In order to access service user has to get register themselves, there are sites that have integrated third party auth feature to sign-in.
But on other side there are many sites that have not integrated auth features to their sites for <strong> due to less reliable </strong>, Now here user has to compulsory register himself with them.
Remembering credentials for infinite site has become difficult for user so they keep common credentials to all sites which can be more dangerous from security point of view.

# Problem Solution  &#x1F50D; 
- CreadBase is an website which will help you to generate, store and access the credentials whenever you need.
- CredBase rich features such as to generate password, add credentials to local database and fetch the credentials from local database will definitely address to the issue which user's are facing in above problem statement.

# Application Features &#10024; 

- Sign-in
- Sign-up
- Reset Password
     - Verify Email
     - Reset Password
- Generate Password
- Add Credentials
- Credentials List
- Session Tracking
- Validate Form Input

# Technologies Used &#x1F680;
- HTML 5
- CSS
- JavaScript
- JDK 1.8
- Servlet
- JSP
- Apache Tomcat 9.0.93
- MYSQL
- JDBC
- Git Hub


# Steps to Setup Environment 	&#127942;

1. SQL Database setup
   - Download and Install MySQL Installer
     Note: During Installation keep username as "root" and password as "root"

      Follow below sql queries:
      - create database credbase;
      - use credbase;
      - create table user(firstname varchar(10) NOT NULL, lastname varchar(10) NOT NULL, username varchar(10) PRIMARY KEY, email varchar(20) NOT NULL, 
        password varchar(15) NOT NULL, confirm_password varchar(15) NOT NULL);
      - create table credentials(sitename varchar(20) NOT NULL, username varchar(20) NOT NULL, credential1 varchar(15) NOT NULL, credential2 varchar(15),
        userId varchar(10));
      - alter table credentials add constraint Foreign Key (userId) references user(username);
      - alter table credentials alter credential2 set default 'NA';

2. Clone the project into local workspace
     - git clone https://github.com/viraj7551/CredBase
3. Install Apache Tomcat Server 9.0

4. Open Project workspace into eclipse

5. Configure Apache Tomcat Server into project workspace
     - Window > Preferences > filter and select server > select runtime environment > add Apache tomcat server 9.0 > browse and select server root directory
       > click on apply
       
6. window where there is console and many other options below, select server tab, configure admin and http port

7. Run jsp file with server
