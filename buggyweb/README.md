# YouDebug demo

The project can be imported into Eclipse using the "Existing Projects into Workspace" Import wizard. 

## Build demo app

    ./gradlew --offline war

## run demo app in IDE debugger
start web application "buggyweb" on a servlet runtime
browse to [http://localhost:8080/buggyweb/MyServlet](http://localhost:8080/buggyweb/MyServlet)

## run demo app in Tomcat

    cd $CATALINA_HOME
    # 8000 is Tomcat's default debug port
    export DEBUG_PORT=8000
    bin/catalina.sh jpda start

browse to [http://localhost:8080/buggyweb/MyServlet](http://localhost:8080/buggyweb/MyServlet)

### show Tomcat log file

    tail -30f logs/localhost.`date +%Y-%m-%d`.log


## Run demo app in Jetty

    export DEBUG_PORT=5005
    export GRADLE_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT"
    #export GRADLE_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT,onjcmd=y"
    ./gradlew --offline appRun


browse to [http://localhost:8081/buggyweb/MyServlet](http://localhost:8081/buggyweb/MyServlet)


### line break

    ./youdebug -socket $DEBUG_PORT linebreak.ydb

### diagnostics: exception

    ./youdebug -socket $DEBUG_PORT exception.ydb


### diagnostics: parameter check

    ./youdebug -socket $DEBUG_PORT diagnose.ydb

### First fix

    ./youdebug -socket $DEBUG_PORT firstbugfix.ydb

### Final fix

    ./youdebug -socket $DEBUG_PORT finalbugfix.ydb

### threaddump

    ./youdebug -socket $DEBUG_PORT threaddump.ydb
