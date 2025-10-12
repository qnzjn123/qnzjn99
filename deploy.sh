#!/bin/bash

# 배포 스크립트 (Linux/Mac)

echo "=== Spring Boot 게시판 배포 스크립트 ==="

# 1. 애플리케이션 빌드
echo "1. 애플리케이션 빌드 중..."
mvn clean package -DskipTests

if [ $? -ne 0 ]; then
    echo "빌드 실패!"
    exit 1
fi

# 2. 기존 프로세스 종료
echo "2. 기존 프로세스 종료 중..."
PID=$(lsof -ti:8080)
if [ ! -z "$PID" ]; then
    kill -9 $PID
    echo "기존 프로세스 종료됨 (PID: $PID)"
fi

# 3. 애플리케이션 시작
echo "3. 애플리케이션 시작 중..."
nohup java -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod > app.log 2>&1 &

echo "배포 완료!"
echo "애플리케이션 로그: tail -f app.log"
