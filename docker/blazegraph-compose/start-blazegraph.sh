java -server $BLAZE_OPTS -XX:+UseG1GC\
     -Djetty.overrideWebXml=web.xml \
     -jar blazegraph.jar
