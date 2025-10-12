#!/bin/bash

# Cloudtype 배포 실행 스크립트

echo "Starting Spring Boot application..."

# 환경 변수 설정
export SPRING_PROFILES_ACTIVE=prod

# PORT 환경 변수가 있으면 사용, 없으면 8080 사용
PORT=${PORT:-8080}

# 애플리케이션 실행
exec java -Dserver.port=$PORT \
     -Xms256m -Xmx512m \
     -jar target/demo-0.0.1-SNAPSHOT.jar \
     --spring.profiles.active=prod
