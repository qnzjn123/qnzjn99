# Spring Boot 게시판 애플리케이션

Java Spring Boot로 만든 간단한 게시판 애플리케이션입니다. Docker를 사용하여 쉽게 실행할 수 있습니다.

## 주요 기능

- ✍️ 게시글 작성, 수정, 삭제
- 📋 게시글 목록 조회
- 🔍 제목/내용 검색
- 👁️ 조회수 카운트
- 🎨 심플한 하얀색 디자인

## 기술 스택

- **Backend**: Java 17, Spring Boot 3.1.5
- **Frontend**: Thymeleaf, HTML, CSS
- **Database**: H2 (인메모리)
- **Build Tool**: Maven
- **Container**: Docker

## 프로젝트 구조

```
spring-tool/
├── src/
│   ├── main/
│   │   ├── java/com/example/board/
│   │   │   ├── BoardApplication.java
│   │   │   ├── controller/
│   │   │   │   ├── HomeController.java
│   │   │   │   └── PostController.java
│   │   │   ├── service/
│   │   │   │   └── PostService.java
│   │   │   ├── repository/
│   │   │   │   └── PostRepository.java
│   │   │   ├── entity/
│   │   │   │   └── Post.java
│   │   │   └── dto/
│   │   │       └── PostDto.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── templates/
│   │           ├── list.html
│   │           ├── form.html
│   │           └── view.html
├── Dockerfile
├── docker-compose.yml
└── pom.xml
```

## 실행 방법

### 1. Docker를 사용한 실행 (권장)

#### Windows PowerShell:
```powershell
# Docker Compose로 빌드 및 실행
docker-compose up --build

# 백그라운드 실행
docker-compose up -d --build

# 중지
docker-compose down
```

### 2. Maven을 사용한 실행

#### Windows PowerShell:
```powershell
# 빌드
.\mvnw.cmd clean package

# 실행
.\mvnw.cmd spring-boot:run
```

## 접속 정보

애플리케이션 실행 후 다음 주소로 접속하세요:

- **게시판**: http://localhost:8080
- **H2 콘솔**: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:boarddb`
  - Username: `sa`
  - Password: (비어있음)

## 사용 방법

1. **게시글 목록**: 메인 페이지에서 모든 게시글을 확인할 수 있습니다.
2. **글쓰기**: 우측 상단 "글쓰기" 버튼을 클릭하여 새 게시글을 작성합니다.
3. **게시글 보기**: 제목을 클릭하면 게시글 상세 페이지로 이동합니다.
4. **수정/삭제**: 상세 페이지에서 수정 및 삭제가 가능합니다.
5. **검색**: 상단 검색창에서 제목이나 내용으로 게시글을 검색할 수 있습니다.

## API 엔드포인트

- `GET /posts` - 게시글 목록 조회
- `GET /posts/new` - 게시글 작성 폼
- `POST /posts` - 게시글 작성
- `GET /posts/{id}` - 게시글 상세 조회
- `GET /posts/{id}/edit` - 게시글 수정 폼
- `POST /posts/{id}` - 게시글 수정
- `POST /posts/{id}/delete` - 게시글 삭제
- `GET /posts?search={keyword}` - 게시글 검색

## 개발 환경 요구사항

- Java 17 이상
- Maven 3.6 이상
- Docker & Docker Compose (선택사항)

## 참고사항

- H2 인메모리 데이터베이스를 사용하므로 애플리케이션을 재시작하면 데이터가 초기화됩니다.
- 프로덕션 환경에서는 MySQL, PostgreSQL 등 영구 저장소를 사용하는 것을 권장합니다.

## 라이선스

MIT License
