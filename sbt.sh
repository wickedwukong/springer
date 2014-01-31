#!/usr/bin/env sh

WORKSPACE=~

JAVA_OPTS="-Dbuild.number=$BUILD_NUMBER -Dsbt.global.base=$WORKSPACE/.sbt -Dsbt.boot.directory=$WORKSPACE/.sbt/boot -Dsbt.ivy.home=$WORKSPACE/.ivy2 -Dhttp.proxyHost=surf-proxy.intranet.db.com -Dhttp.proxyPort=8080 -Dhttp.nonProxyHosts=*.db.com -Xmx1024M -XX:MaxPermSize=512m -XX:ReservedCodeCacheSize=128m"

exec java $JAVA_OPTS -jar sbt-launch-0.13.0.jar "$@"
