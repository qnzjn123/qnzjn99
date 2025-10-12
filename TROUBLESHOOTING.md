# 🚨 클라우드타입 503 에러 해결 가이드

## ❌ 문제: "503 서비스가 중지되었습니다"

이 에러는 애플리케이션이 정상적으로 시작하지 못했다는 의미입니다.

---

## ✅ 해결 완료 사항

### 1️⃣ 메모리 설정 최적화
```
-Xmx256m -Xms128m
```
- 클라우드타입 무료 플랜의 메모리 제한에 맞게 설정
- 최대 256MB, 초기 128MB

### 2️⃣ H2 Console 비활성화
```properties
spring.h2.console.enabled=false
```
- 보안상 운영 환경에서는 H2 Console 비활성화 필요

### 3️⃣ Procfile 단순화
```
web: java -Xmx256m -Xms128m -Dserver.port=$PORT -jar target/board-1.0.0.jar
```

### 4️⃣ .cloudtype.yaml 생성
클라우드타입 전용 설정 파일 추가

---

## 🔄 클라우드타입에서 재배포 방법

### 방법 1: 자동 재배포 (권장)
Git 푸시가 완료되면 클라우드타입이 자동으로 감지하고 재배포합니다.
- 대시보드에서 "배포 중" 상태 확인
- 3-5분 정도 소요

### 방법 2: 수동 재배포
1. 클라우드타입 대시보드 접속
2. 프로젝트 선택
3. "재배포" 버튼 클릭

---

## 📋 클라우드타입 설정 확인

### ✅ 빌드 명령어
```bash
./mvnw clean package -DskipTests
```

### ✅ 실행 명령어 (둘 중 하나)

**옵션 1 - Procfile 사용 (권장):**
```
(비워두기 - Procfile이 자동 실행됨)
```

**옵션 2 - 직접 입력:**
```bash
java -Xmx256m -Xms128m -Dserver.port=$PORT -jar target/board-1.0.0.jar
```

### ✅ 환경 변수
```
PORT=(자동 할당)
```

---

## 🔍 문제 진단 방법

### 1️⃣ 로그 확인
클라우드타입 대시보드에서:
1. "로그" 탭 클릭
2. "빌드 로그" - 빌드 실패 확인
3. "애플리케이션 로그" - 런타임 에러 확인

### 2️⃣ 흔한 에러 메시지

#### 에러: "OutOfMemoryError"
**해결**: 메모리 설정 확인 (이미 수정됨)
```
-Xmx256m -Xms128m
```

#### 에러: "Address already in use"
**해결**: 포트 설정 확인
```
-Dserver.port=$PORT
```

#### 에러: "JAR file not found"
**해결**: 빌드 명령어 확인
```bash
./mvnw clean package -DskipTests
```

#### 에러: "Failed to bind to $PORT"
**해결**: Procfile에 $PORT 변수 포함 확인

---

## 🎯 배포 체크리스트

배포 전 확인사항:

- [x] Git 푸시 완료
- [x] Procfile 존재
- [x] .cloudtype.yaml 존재
- [x] H2 Console 비활성화
- [x] 메모리 설정 최적화
- [x] 빌드 명령어 정확
- [x] 실행 명령어에 $PORT 포함

---

## 📊 배포 상태 확인

### ✅ 정상 배포
- 빌드 로그: "BUILD SUCCESS"
- 애플리케이션 로그: "Tomcat started on port"
- 상태: "실행 중" (녹색)
- URL 접속: 게시판 정상 표시

### ❌ 배포 실패
- 빌드 로그: "BUILD FAILED"
- 상태: "중지됨" (빨간색)
- URL 접속: 503 에러

---

## 🚀 다음 단계

1. **클라우드타입 대시보드 확인**
   - 자동 재배포 시작 확인
   - 빌드 로그 모니터링

2. **배포 완료 대기** (3-5분)
   - "실행 중" 상태 확인

3. **URL 접속**
   - 게시판 정상 작동 확인

4. **문제 발생 시**
   - 로그 확인
   - 아래 명령어로 로컬 테스트
   ```powershell
   java -Xmx256m -Xms128m -Dserver.port=8080 -jar target\board-1.0.0.jar
   ```

---

## 💡 추가 최적화 팁

### 무료 플랜 사용 시
- 메모리: 최대 256MB로 제한
- CPU: 공유 리소스
- 슬립 모드: 일정 시간 미사용 시 자동 정지

### 성능 향상
1. 불필요한 로그 줄이기
2. H2 대신 PostgreSQL/MySQL 사용 (유료 플랜)
3. 이미지 최적화
4. Gzip 압축 활성화

---

## 📞 여전히 안 되나요?

1. **클라우드타입 로그 복사**
   - 빌드 로그 전체
   - 애플리케이션 로그 에러 부분

2. **로컬 테스트**
   ```powershell
   .\mvnw.cmd clean package -DskipTests
   java -Xmx256m -Xms128m -Dserver.port=8080 -jar target\board-1.0.0.jar
   ```

3. **에러 메시지 공유**
   - 구체적인 에러 메시지 제공

이제 클라우드타입이 자동으로 재배포합니다! 
대시보드에서 "실행 중" 상태가 되면 성공입니다! 🎉
