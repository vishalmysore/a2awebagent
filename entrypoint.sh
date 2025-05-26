#!/bin/sh

# Create local cache directories (in case not already created)
mkdir -p /ai/seleniumCache /ai/resolutionCache

# Show contents for debugging
ls -l /ai

# Start the Java application with WebDriverManager cache paths
exec java \
  -Dloader.path=/ai/conf \
  -Djava.security.egd=file:/dev/./urandom \
  -Dwdm.cachePath=/ai/seleniumCache \
  -Dwdm.resolutionCachePath=/ai/resolutionCache \
  -jar /ai/mcpdemo.jar
