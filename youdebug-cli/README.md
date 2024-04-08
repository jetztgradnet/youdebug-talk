# YouDebug demo

## set up alias for youdebug

    alias youdebug=../../youdebug/youdebug

## Build demo app

    ./gradlew --offline war

## run demo app in Eclipse debugger
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

    ./gradlew --offline appRunDebug

browse to [http://localhost:8080/buggyweb/MyServlet](http://localhost:8080/buggyweb/MyServlet)

## Exploring YouDebug

### threaddump

    youdebug -socket $DEBUG_PORT threaddump.ydb | more
    
### VM Information

    youdebug -socket $DEBUG_PORT vminfo.ydb

## Diagnosing the bug

### diagnostics: get exception stacktrace

    youdebug -socket $DEBUG_PORT exception.ydb

### set line break

    youdebug -socket $DEBUG_PORT linebreak.ydb


### diagnostics: check parameter value 

    youdebug -socket $DEBUG_PORT diagnose.ydb

### First fix

    youdebug -socket $DEBUG_PORT firstbugfix.ydb

### Final fix

    youdebug -socket $DEBUG_PORT finalbugfix.ydb

