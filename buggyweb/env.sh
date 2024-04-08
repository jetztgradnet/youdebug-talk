#!/bin/sh

export DEBUG_PORT=5005
export GRADLE_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT"
#export GRADLE_OPTS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=$DEBUG_PORT,onjcmd=y"

