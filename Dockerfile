FROM openjdk:18

# Set working directory
WORKDIR /ai

# Define the version as a build argument
ARG VERSION=0.0.1

# Download the JAR file
RUN curl -L -o /ai/mcpdemo.jar https://github.com/vishalmysore/a2awebagent/releases/download/release/a2awebagent-${VERSION}.jar

# Create writable directories for WebDriverManager
RUN mkdir -p /ai/seleniumCache /ai/resolutionCache && \
    chmod -R 777 /ai/seleniumCache /ai/resolutionCache

# Copy the entrypoint script
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Expose the port
EXPOSE 7860

# Set entrypoint
ENTRYPOINT ["/entrypoint.sh"]
