# Spring Boot 게시판 배포 가이드

## 📦 배포 파일

배포를 위해 생성된 JAR 파일:
- `target/demo-0.0.1-SNAPSHOT.jar`

## 🚀 배포 방법

### 1️⃣ 로컬 서버에서 직접 실행

#### Windows
```powershell
# PowerShell 배포 스크립트 실행
.\deploy.ps1
```

또는 수동으로:
```powershell
# JAR 파일 빌드
mvn clean package -DskipTests

# 애플리케이션 실행
java -jar target\demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

#### Linux/Mac
```bash
# 배포 스크립트 실행 권한 부여
chmod +x deploy.sh

# 배포 스크립트 실행
./deploy.sh
```

또는 수동으로:
```bash
# JAR 파일 빌드
mvn clean package -DskipTests

# 백그라운드 실행
nohup java -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod > app.log 2>&1 &
```

---

### 2️⃣ Docker로 배포

#### Docker 이미지 빌드 및 실행
```bash
# Docker 이미지 빌드
docker build -t spring-board-app .

# Docker 컨테이너 실행
docker run -d -p 8080:8080 --name spring-board spring-board-app
```

#### Docker Compose 사용
```bash
# Docker Compose로 실행
docker-compose up -d

# 로그 확인
docker-compose logs -f

# 중지
docker-compose down
```

---

### 3️⃣ 클라우드 서비스 배포

#### AWS EC2
1. EC2 인스턴스 생성 (Ubuntu 20.04 LTS 권장)
2. Java 17 설치:
```bash
sudo apt update
sudo apt install openjdk-17-jre -y
```
3. JAR 파일 업로드:
```bash
scp target/demo-0.0.1-SNAPSHOT.jar ubuntu@your-ec2-ip:/home/ubuntu/
```
4. 실행:
```bash
nohup java -jar demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod > app.log 2>&1 &
```

#### Heroku
```bash
# Heroku CLI 로그인
heroku login

# 앱 생성
heroku create your-app-name

# Git 푸시로 배포
git push heroku main
```

#### Railway / Render
1. GitHub 저장소와 연결
2. 빌드 명령: `mvn clean package -DskipTests`
3. 시작 명령: `java -jar target/demo-0.0.1-SNAPSHOT.jar`

---

## 🔧 환경 설정

### 포트 변경
`application-prod.properties` 파일 수정:
```properties
server.port=원하는포트번호
```

### 데이터베이스 변경 (MySQL 사용 시)
`pom.xml`에 의존성 추가:
```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
```

`application-prod.properties` 수정:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/boarddb
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

---

## 📊 모니터링

### 로그 확인
```bash
# Windows
Get-Content app.log -Wait

# Linux/Mac
tail -f app.log
```

### 애플리케이션 상태 확인
```bash
# 포트 8080에서 실행 중인지 확인
curl http://localhost:8080
```

---

## 🛑 애플리케이션 중지

### Windows
```powershell
# 포트 8080 사용 중인 프로세스 찾기 및 종료
$process = Get-NetTCPConnection -LocalPort 8080 | Select-Object -ExpandProperty OwningProcess -Unique
Stop-Process -Id $process -Force
```

### Linux/Mac
```bash
# 포트 8080 사용 중인 프로세스 종료
kill -9 $(lsof -ti:8080)
```

---

## 🌐 접속 주소

로컬: http://localhost:8080
서버: http://your-server-ip:8080

---

## 📝 주의사항

1. **보안**: 운영 환경에서는 H2 콘솔을 비활성화하세요
2. **데이터베이스**: 운영 환경에서는 MySQL/PostgreSQL 사용 권장
3. **방화벽**: 서버의 8080 포트가 열려있는지 확인
4. **메모리**: 최소 512MB RAM 권장
5. **Java**: Java 17 이상 필요

---

## 🔗 유용한 명령어

```bash
# JAR 파일 정보 확인
java -jar target/demo-0.0.1-SNAPSHOT.jar --version

# 특정 포트로 실행
java -jar target/demo-0.0.1-SNAPSHOT.jar --server.port=9090

# 메모리 설정과 함께 실행
java -Xms256m -Xmx512m -jar target/demo-0.0.1-SNAPSHOT.jar
```
