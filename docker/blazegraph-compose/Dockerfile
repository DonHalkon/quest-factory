FROM java:8-jre-alpine

ENV BLAZEGRAPH_DIR /blazegraph

RUN mkdir $BLAZEGRAPH_DIR

COPY start-blazegraph.sh ${BLAZEGRAPH_DIR}/start-blazegraph.sh
COPY web.xml ${BLAZEGRAPH_DIR}/web.xml

RUN apk add --update openssl
RUN wget -O ${BLAZEGRAPH_DIR}/blazegraph.jar "https://sourceforge.net/projects/bigdata/files/bigdata/2.1.4/blazegraph.jar/download"
RUN chmod +x ${BLAZEGRAPH_DIR}/start-blazegraph.sh

ENTRYPOINT cd ${BLAZEGRAPH_DIR} && ./start-blazegraph.sh
