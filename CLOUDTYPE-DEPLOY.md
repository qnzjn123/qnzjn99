# 🚀 클라우드타입 배포 완벽 가이드

## ⚠️ 사이트가 안 보이는 문제 해결!

### 주요 수정 사항
1. ✅ 동적 포트 설정: `server.port=${PORT:8080}`
2. ✅ Procfile 생성
3. ✅ system.properties 생성 (Java 버전 명시)
4. ✅ Production 프로파일 설정

---

## 📋 클라우드타입 배포 단계별 가이드

### 1️⃣ Git 저장소에 푸시

```bash
git add .
git commit -m "클라우드타입 배포 설정 완료"
git push origin main
```

### 2️⃣ 클라우드타입 웹사이트 설정

#### ▶️ 프로젝트 생성
1. 클라우드타입 접속: https://cloudtype.io/
2. "새 프로젝트" 클릭
3. GitHub 저장소 연결

#### ▶️ 빌드 설정

| 설정 항목 | 값 |
|---------|-----|
| **빌드 명령어** | `./mvnw clean package -DskipTests` |
| **실행 명령어** | `java -Dserver.port=$PORT -Dspring.profiles.active=prod -jar target/board-1.0.0.jar` |
| **포트** | `자동 감지` 또는 비워두기 |
| **Java 버전** | `17` |

#### ▶️ 환경 변수 (선택사항)

```
SPRING_PROFILES_ACTIVE=prod
```

### 3️⃣ 배포 확인

배포 완료 후:
- 클라우드타입이 자동으로 URL 생성
- 예: `https://your-app.cloudtype.app`
- 해당 URL로 접속하여 게시판 확인

---

## 🔍 문제 해결 (Troubleshooting)

### ❌ 502 Bad Gateway 에러
**원인**: 애플리케이션이 시작되지 않음

**해결**:
1. 빌드 로그 확인
2. Java 버전 확인 (17 사용 중인지)
3. 메모리 부족 시 플랜 업그레이드

### ❌ 빈 화면 또는 404 에러
**원인**: 포트 설정 문제

**해결**:
1. `server.port=${PORT:8080}` 설정 확인
2. 실행 명령어에 `-Dserver.port=$PORT` 포함 확인
3. Procfile 사용하는지 확인

### ❌ 데이터베이스 연결 에러
**원인**: H2 인메모리 DB는 재시작 시 초기화됨

**해결**:
- 정상 동작! H2는 인메모리라서 재시작마다 데이터 초기화됨
- 영구 저장 필요 시 MySQL/PostgreSQL 연결 필요

---

## 📁 주요 파일 설명

### `Procfile`
```
web: java -Dserver.port=$PORT -Dspring.profiles.active=prod -jar target/board-1.0.0.jar
```
- 클라우드타입이 자동으로 읽어서 실행
- `$PORT` 환경 변수 자동 주입

### `system.properties`
```
java.runtime.version=17
```
- Java 버전 명시

### `application.properties`
```properties
server.port=${PORT:8080}
```
- `$PORT` 환경 변수 없으면 8080 사용
- 있으면 클라우드타입이 제공한 포트 사용

---

## ✅ 배포 체크리스트

배포 전에 확인하세요:

- [ ] `Procfile` 파일 존재
- [ ] `system.properties` 파일 존재
- [ ] `mvnw`, `mvnw.cmd` 파일 존재
- [ ] `.mvn/wrapper/` 폴더 존재
- [ ] `pom.xml` 파일 존재
- [ ] Git 저장소에 모든 파일 푸시 완료
- [ ] 클라우드타입에서 빌드 명령어 정확히 입력
- [ ] 클라우드타입에서 실행 명령어 정확히 입력

---

## 🎯 빠른 명령어 모음

### 로컬 빌드 & 실행
```powershell
# 빌드
.\mvnw.cmd clean package -DskipTests

# 실행
java -jar target\board-1.0.0.jar

# 또는 포트 지정
java -Dserver.port=8080 -jar target\board-1.0.0.jar
```

### Git 푸시
```bash
git add .
git commit -m "배포 설정 완료"
git push origin main
```

---

## 📞 추가 도움이 필요하면

1. 클라우드타입 빌드 로그 확인
2. 애플리케이션 로그 확인
3. 에러 메시지 복사해서 질문하기

행운을 빕니다! 🍀
