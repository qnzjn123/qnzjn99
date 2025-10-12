#!/bin/bash

# Cloudtype 배포 빌드 스크립트

echo "Building Spring Boot application..."

# Maven 빌드 실행
mvn clean package -DskipTests

# 빌드 결과 확인
if [ -f target/demo-0.0.1-SNAPSHOT.jar ]; then
    echo "Build successful!"
    echo "JAR file created: target/demo-0.0.1-SNAPSHOT.jar"
else
    echo "Build failed!"
    exit 1
fi
