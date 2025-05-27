FROM node:16.16.0

# Install dependencies
RUN apt-get update && apt-get install -y \
    curl unzip gnupg wget tar \
    fonts-liberation \
    libasound2 \
    libatk-bridge2.0-0 \
    libatk1.0-0 \
    libatspi2.0-0 \
    libcups2 \
    libdbus-1-3 \
    libdrm2 \
    libgbm1 \
    libgtk-3-0 \
    libnspr4 \
    libnss3 \
    libwayland-client0 \
    libxcomposite1 \
    libxdamage1 \
    libxfixes3 \
    libxkbcommon0 \
    libxrandr2 \
    xdg-utils \
    libu2f-udev \
    libvulkan1

# Install OpenJDK 18 manually from Adoptium
RUN curl -L -o /tmp/openjdk18.tar.gz https://github.com/adoptium/temurin18-binaries/releases/download/jdk-18.0.2.1%2B1/OpenJDK18U-jdk_x64_linux_hotspot_18.0.2.1_1.tar.gz && \
    mkdir -p /opt/java/openjdk && \
    tar -xzf /tmp/openjdk18.tar.gz -C /opt/java/openjdk --strip-components=1 && \
    rm /tmp/openjdk18.tar.gz

# Set JAVA_HOME
ENV JAVA_HOME=/opt/java/openjdk
ENV PATH="$JAVA_HOME/bin:$PATH"

# Verify Java
RUN java -version

# Install Chrome
RUN curl -LO https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    apt-get install -y ./google-chrome-stable_current_amd64.deb && \
    rm google-chrome-stable_current_amd64.deb

# Set working directory
WORKDIR /ai

# Download your Spring Boot JAR
ARG VERSION=0.0.1
RUN curl -L -o /ai/mcpdemo.jar https://github.com/vishalmysore/a2awebagent/releases/download/release/a2awebagent-${VERSION}.jar

# Create required directories
RUN mkdir -p /ai/seleniumCache /ai/resolutionCache && chmod -R 777 /ai

# Copy entrypoint script
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

EXPOSE 7860

# Start your app
ENTRYPOINT ["/entrypoint.sh"]
