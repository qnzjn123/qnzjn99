# 🎉 Spring Boot 게시판 프로젝트 완성!

## 📦 프로젝트 정보

- **프로젝트명**: Spring Boot Board (게시판)
- **저장소**: https://github.com/qnzjn123/qnzjn99
- **브랜치**: main
- **Java 버전**: 17 (로컬은 18 사용 가능)
- **Spring Boot**: 3.1.5
- **데이터베이스**: H2 (인메모리)

---

## ✅ 포함된 기능

### 🎯 게시판 기능
- ✅ 게시글 목록 조회
- ✅ 게시글 작성
- ✅ 게시글 상세보기
- ✅ 게시글 수정
- ✅ 게시글 삭제
- ✅ 제목/내용 검색
- ✅ 조회수 카운팅

### 🎨 디자인
- ✅ 하얀색 깔끔한 디자인
- ✅ 아이콘 없이 텍스트만 사용
- ✅ 반응형 레이아웃

### 🚀 배포 준비
- ✅ Docker 지원 (Dockerfile, docker-compose.yml)
- ✅ 클라우드타입 배포 준비 완료
- ✅ Linux/Windows 모두 지원

---

## 📁 프로젝트 구조

```
spring-tool/
├── src/
│   ├── main/
│   │   ├── java/com/example/board/
│   │   │   ├── BoardApplication.java          # 메인 애플리케이션
│   │   │   ├── controller/
│   │   │   │   ├── HomeController.java        # 홈 컨트롤러
│   │   │   │   └── PostController.java        # 게시글 컨트롤러
│   │   │   ├── service/
│   │   │   │   └── PostService.java           # 비즈니스 로직
│   │   │   ├── repository/
│   │   │   │   └── PostRepository.java        # 데이터 접근
│   │   │   ├── entity/
│   │   │   │   └── Post.java                  # 게시글 엔티티
│   │   │   └── dto/
│   │   │       └── PostDto.java               # 데이터 전송 객체
│   │   └── resources/
│   │       ├── application.properties          # 기본 설정
│   │       ├── application-prod.properties     # 운영 설정
│   │       └── templates/
│   │           ├── list.html                   # 목록 페이지
│   │           ├── form.html                   # 작성/수정 페이지
│   │           └── view.html                   # 상세보기 페이지
├── .mvn/wrapper/                               # Maven Wrapper
├── mvnw                                        # Linux용 Maven 실행 파일
├── mvnw.cmd                                    # Windows용 Maven 실행 파일
├── pom.xml                                     # Maven 설정
├── Dockerfile                                  # Docker 이미지 빌드
├── docker-compose.yml                          # Docker Compose 설정
├── Procfile                                    # 클라우드타입 실행 설정
├── system.properties                           # Java 버전 명시
├── .cloudtype.yaml                             # 클라우드타입 설정
├── start.sh                                    # 실행 스크립트
├── .gitignore                                  # Git 제외 파일
├── README.md                                   # 프로젝트 설명
├── DEPLOY.md                                   # 배포 가이드
├── CLOUDTYPE-DEPLOY.md                         # 클라우드타입 배포 가이드
└── TROUBLESHOOTING.md                          # 문제 해결 가이드
```

---

## 🚀 로컬 실행 방법

### Windows PowerShell:
```powershell
# 개발 모드 실행
.\mvnw.cmd spring-boot:run

# 또는 JAR로 실행
.\mvnw.cmd clean package -DskipTests
java -jar target\board-1.0.0.jar
```

### Linux/Mac:
```bash
# 개발 모드 실행
./mvnw spring-boot:run

# 또는 JAR로 실행
./mvnw clean package -DskipTests
java -jar target/board-1.0.0.jar
```

### Docker:
```bash
# Docker Compose로 실행
docker-compose up

# 백그라운드 실행
docker-compose up -d
```

---

## 🌐 로컬 접속

- **게시판**: http://localhost:8080
- **H2 Console**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:boarddb`
  - Username: `sa`
  - Password: (비어있음)

---

## ☁️ 클라우드타입 배포

### 1️⃣ 클라우드타입 설정

| 항목 | 값 |
|------|-----|
| **저장소** | `qnzjn123/qnzjn99` |
| **브랜치** | `main` |
| **빌드 명령어** | `./mvnw clean package -DskipTests` |
| **실행 명령어** | 비워두기 (Procfile 자동 사용) |
| **포트** | 자동 감지 |
| **Java 버전** | 17 |

### 2️⃣ 배포 완료 확인

- ✅ 빌드 로그: `BUILD SUCCESS`
- ✅ 앱 로그: `Tomcat started on port`
- ✅ 상태: "실행 중" (녹색)
- ✅ URL 접속: 게시판 정상 작동

---

## 📋 주요 파일 설명

### `Procfile`
```
web: java -Xmx256m -Xms128m -Dserver.port=$PORT -jar target/board-1.0.0.jar
```
클라우드타입이 자동으로 실행할 명령어

### `application.properties`
```properties
server.port=${PORT:8080}
```
동적 포트 지원 (클라우드타입용)

### `pom.xml`
Maven 빌드 설정 및 의존성 관리

### `mvnw` & `mvnw.cmd`
Maven Wrapper - Maven 설치 없이 빌드 가능

---

## 🔧 문제 해결

### 503 에러 발생 시
1. 클라우드타입 로그 확인
2. 빌드 성공 여부 확인
3. `BUILD SUCCESS` 확인
4. `Tomcat started` 메시지 확인

### mvnw not found 에러
- ✅ 이미 해결됨! `mvnw` 파일 추가 완료

### 메모리 부족 에러
- ✅ 이미 해결됨! `-Xmx256m -Xms128m` 설정 완료

자세한 내용은 `TROUBLESHOOTING.md` 참조

---

## 📚 참고 문서

- `README.md` - 프로젝트 전체 설명
- `DEPLOY.md` - 일반 배포 가이드
- `CLOUDTYPE-DEPLOY.md` - 클라우드타입 배포 상세 가이드
- `TROUBLESHOOTING.md` - 문제 해결 가이드

---

## 🎯 Git 커밋 히스토리

```bash
# 최신 커밋
e8ea390 - Spring Boot 게시판 완성 - 클라우드타입 배포 준비 완료
d8f3135 - Linux용 mvnw 파일 추가 - 클라우드타입 배포 수정
2ba2a3c - 클라우드타입 503 에러 수정 - 메모리 설정 및 H2 Console 비활성화
18a9131 - 클라우드타입 배포 설정 완료 - 동적 포트 지원, Procfile 추가
```

---

## ✨ 완료된 작업

- [x] Spring Boot 프로젝트 생성
- [x] 게시판 CRUD 기능 구현
- [x] 하얀색 디자인 적용
- [x] 검색 기능 추가
- [x] Docker 설정
- [x] 클라우드타입 배포 설정
- [x] Linux/Windows 호환성 확보
- [x] 문서화 완료
- [x] Git 저장소 정리

---

## 🎉 프로젝트 완성!

모든 기능이 정상 작동하며, 클라우드타입 배포 준비가 완료되었습니다!

### 다음 단계
1. 클라우드타입에서 자동 재배포 대기 (3-5분)
2. "실행 중" 상태 확인
3. 생성된 URL로 접속
4. 게시판 사용 시작! 🚀

---

**제작일**: 2025년 10월 12일  
**저장소**: https://github.com/qnzjn123/qnzjn99  
**버전**: 1.0.0
