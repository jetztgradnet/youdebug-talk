h1. YouDebug demo

h2. Build demo app

./gradlew war

h2. run demo app in Eclipse debugger
start web application "buggyweb" on a servlet runtime
browse to "http://localhost:8080/buggyweb/MyServlet":http://localhost:8080/buggyweb/MyServlet 

h2. run demo app in Tomcat

bc. 
cd $CATALINA_HOME
bin/catalina.sh jpda start

browse to "http://localhost:8080/buggyweb/MyServlet":http://localhost:8080/buggyweb/MyServlet 

h3. show Tomcat log file

bc. 
tail -30f logs/localhost.`date +%Y-%m-%d`.log


h2. Run demo app in Jetty

export GRADLE_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8001"
./gradlew jettyRun

browse to "http://localhost:8081/buggyweb/MyServlet":http://localhost:8081/buggyweb/MyServlet


h3. line break

bc. 
./youdebug -socket 8000 linebreak.ydb
./youdebug -socket 8001 linebreak.ydb

h3. diagnostics: exception

bc. 
./youdebug -socket 8000 exception.ydb
./youdebug -socket 8001 exception.ydb


h3. diagnostics: parameter check

bc. 
./youdebug -socket 8000 diagnose.ydb
./youdebug -socket 8001 diagnose.ydb

h3. First fix

bc. 
./youdebug -socket 8000 firstbugfix.ydb
./youdebug -socket 8001 firstbugfix.ydb

h3. Final fix

bc. 
./youdebug -socket 8000 finalbugfix.ydb
./youdebug -socket 8001 finalbugfix.ydb

h3. threaddump

bc. 
./youdebug -socket 8000 threaddump.ydb
./youdebug -socket 8001 threaddump.ydb