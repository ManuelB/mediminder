FROM airhacks/wildfly
MAINTAINER Manuel Blechschmidt Incentergy GmbH, www.incentergy.de
RUN mkdir -p /home/manuel/workspace/src/main/data/
COPY src/main/data/20160711_AaA_ifap_DS_20160715.sqlite /home/manuel/workspace/src/main/data/20160711_AaA_ifap_DS_20160715.sqlite 
COPY target/mediminder.war ${DEPLOYMENT_DIR}