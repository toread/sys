#!/bin/bash

docker run -it -d \
--name quickstart-access-ctl \
-e "JAVA_OPTS=-javaagent:/usr/local/pinpoint-agent/pinpoint-bootstrap-1.6.0.jar -Dpinpoint.agentId=access-ctl -Dpinpoint.applicationName=quickstart-access-ctl" \
-e "COLLECTOR_IP=collector" \
--link="pinpoint-collector:collector" \
-p 8081:8080 \
-v $(pwd)/ROOT.war:/usr/local/tomcat/webapps/ROOT.war \
naver/access-ctl:0.0.1-SNAPSHOT

