# 클라우드타입 배포 가이드

## ✅ JAR 파일 빌드 완료!

빌드된 파일: `target/board-1.0.0.jar`

## 🚀 클라우드타입 배포 방법

### 1️⃣ 빌드 명령어 (클라우드타입 설정에서 입력)

**Maven 사용:**
```bash
./mvnw clean package -DskipTests
```

**또는 Windows에서 로컬 빌드:**
```powershell
.\mvnw.cmd clean package -DskipTests
```

### 2️⃣ 실행 명령어 (⚠️ 중요!)

**옵션 1 - Procfile 사용 (권장):**
```bash
# Procfile이 자동으로 실행됨
```

**옵션 2 - 직접 명령어 입력:**
```bash
java -Dserver.port=$PORT -Dspring.profiles.active=prod -jar target/board-1.0.0.jar
```

### 3️⃣ 포트 설정 (⚠️ 중요!)

- 클라우드타입은 **동적 포트**를 사용합니다
- `$PORT` 환경 변수를 자동으로 할당합니다
- 포트를 고정하지 마세요! (8080 대신 `$PORT` 사용)

### 4️⃣ 환경 변수

클라우드타입 설정에서 추가:
```
SPRING_PROFILES_ACTIVE=prod
```

### 5️⃣ Git 저장소 푸시

```bash
git add .
git commit -m "클라우드타입 배포 설정"
git push origin main
```

---

## 🔧 로컬에서 JAR 실행 테스트

빌드 후 로컬에서 테스트:

```powershell
java -jar target\board-1.0.0.jar
```

그 다음 http://localhost:8080 접속

---

## 📝 클라우드타입 배포 체크리스트

- ✅ Git 저장소에 코드 푸시 완료
- ✅ `mvnw` 파일 포함 확인
- ✅ `pom.xml` 파일 포함 확인
- ✅ 빌드 명령어: `./mvnw clean package -DskipTests`
- ✅ 실행 명령어: `java -jar target/board-1.0.0.jar`
- ✅ 포트: 8080
- ✅ Java 버전: 17

---

## 🎯 Gradle로 변환하고 싶다면?

Gradle이 더 익숙하거나 클라우드타입에서 Gradle을 요구한다면
별도로 요청해주세요. Gradle 프로젝트로 변환해드리겠습니다.
