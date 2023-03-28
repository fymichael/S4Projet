jar -cf fw.jar -C .\Framework\build\web\WEB-INF\classes\ etu1998
jar -cvf test_fw.war -C .\Test-Framework\build\web\ WEB-INF\
copy test_fw.war C:\MyWebServer\apache-tomcat-10.0.20\webapps\
xcopy fw.jar C:\Users\P15B-79-FY\Documents\S4Projet\Test-Framework\build\web\WEB-INF\lib\