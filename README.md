# Spring Boot 게시판 프로젝트

하얀색 디자인의 Spring Boot 게시판 애플리케이션입니다.

## ✨ 주요 기능

- 게시글 목록 조회
- 게시글 작성
- 게시글 상세 조회
- 게시글 수정
- 게시글 삭제
- 깔끔한 하얀색 UI 디자인

## 🛠️ 기술 스택

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- Thymeleaf
- H2 Database
- Maven

## 🚀 실행 방법

### 개발 모드
```bash
mvn spring-boot:run
```

### 배포 모드
```bash
mvn clean package -DskipTests
java -jar target/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

또는 Windows에서:
```powershell
.\deploy.ps1
```

## 📦 배포

자세한 배포 가이드는 [DEPLOYMENT.md](DEPLOYMENT.md)를 참조하세요.

## 🌐 접속

- 로컬 개발: http://localhost:8080
- H2 콘솔 (개발 모드): http://localhost:8080/h2-console

## 📋 요구사항

- Java 17 이상
- Maven 3.6 이상

## 📁 프로젝트 구조

```
spring-tool/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── controller/    # 컨트롤러
│   │   │   ├── entity/        # 엔티티
│   │   │   ├── repository/    # 레포지토리
│   │   │   └── DemoApplication.java
│   │   └── resources/
│   │       ├── templates/     # HTML 템플릿
│   │       └── application.properties
│   └── test/
├── target/                    # 빌드 결과
├── pom.xml                   # Maven 설정
├── Dockerfile                # Docker 이미지
├── docker-compose.yml        # Docker Compose
├── deploy.ps1               # Windows 배포 스크립트
├── deploy.sh                # Linux/Mac 배포 스크립트
└── DEPLOYMENT.md            # 배포 가이드
```
