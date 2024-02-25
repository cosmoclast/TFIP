1. Create a database called capstone

2. Open the folder capstonedatabase, run the SQL file create_tables.sql to create the tables in capstone database

3. Open the folder capstonedatabase, run the SQL file populate_tables.sql to populate the tables with data in capstone database. NOTE: populate_tables.sql cannot be run multiple consecutive times because of the auto incremented ids. Before populate_tables.sql is run, create_tables.sql must run first.

4. Open the folder capstonebackend in IntelliJ

5. Open application.properties in IntelliJ

6. In line 2, change the port if mariadb is not using port 3306

7. In line 4, change the password to the password used for mariadb

8. Run the application

9. Open the folder capstonefrontend in Visual Studio Code

10. Open terminal and run the command npm install

11. After step 10 is complete, run the command npm install axios

12. After step 11 is complete, run the command npm install @react-google-maps/api

13. After step 12 is complete, run the command npm install react-router-dom

14. After step 13 is complete, run the command npm start

15. If the browser does not automatically open, open browser and type http://localhost:3000