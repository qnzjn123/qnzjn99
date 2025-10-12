# ☁️ Cloudtype 배포 가이드

## 📋 준비사항

1. [Cloudtype](https://cloudtype.io/) 계정 생성
2. GitHub 저장소에 코드 푸시
3. Java 17 환경

---

## 🚀 Cloudtype 배포 방법

### 1단계: GitHub에 코드 푸시

```bash
# Git 초기화 (아직 안 했다면)
git init

# 파일 추가
git add .

# 커밋
git commit -m "Initial commit - Spring Boot Board"

# GitHub 저장소 연결 (본인의 저장소 URL로 변경)
git remote add origin https://github.com/qnzjn123/qnzjn99.git

# 푸시
git push -u origin main
```

### 2단계: Cloudtype에서 배포

1. **Cloudtype 로그인**
   - https://cloudtype.io/ 접속
   - GitHub 계정으로 로그인

2. **새 프로젝트 생성**
   - "새 프로젝트" 버튼 클릭
   - GitHub 저장소 연결

3. **저장소 선택**
   - Repository: `qnzjn123/qnzjn99`
   - Branch: `main`

4. **빌드 설정**
   - **Runtime**: Java 17
   - **Build Command**: 
     ```bash
     mvn clean package -DskipTests
     ```
   - **Start Command**:
     ```bash
     java -jar target/demo-0.0.1-SNAPSHOT.jar
     ```
   - **Port**: 8080 (자동 감지됨)

5. **환경 변수 설정** (선택사항)
   ```
   SPRING_PROFILES_ACTIVE=prod
   ```

6. **배포 시작**
   - "배포하기" 버튼 클릭
   - 빌드 및 배포 진행 상황 확인

---

## 🌐 배포 후 접속

배포가 완료되면 Cloudtype에서 제공하는 도메인으로 접속할 수 있습니다:

```
https://your-app-name.cloudtype.app
```

---

## ⚙️ 고급 설정

### 커스텀 도메인 연결

1. Cloudtype 대시보드에서 프로젝트 선택
2. "도메인" 탭 클릭
3. "커스텀 도메인 추가" 클릭
4. 본인의 도메인 입력 (예: myboard.com)
5. DNS 설정에서 CNAME 레코드 추가:
   ```
   CNAME  your-app-name.cloudtype.app
   ```

### 환경별 설정

**개발 환경 (로컬)**
- H2 인메모리 데이터베이스
- 포트: 8080
- 프로파일: default

**운영 환경 (Cloudtype)**
- H2 파일 데이터베이스 (또는 외부 DB)
- 포트: 환경 변수로 자동 설정
- 프로파일: prod

---

## 🔄 자동 배포 설정

Cloudtype은 GitHub와 자동 연동되어 있습니다:

1. **main 브랜치에 푸시하면 자동 배포**
   ```bash
   git add .
   git commit -m "Update features"
   git push origin main
   ```

2. **배포 진행 상황 확인**
   - Cloudtype 대시보드에서 실시간 로그 확인

---

## 📊 모니터링

### 로그 확인
- Cloudtype 대시보드 → 프로젝트 선택 → "로그" 탭

### 리소스 사용량
- CPU, 메모리, 네트워크 사용량 실시간 모니터링

---

## 🛠️ 문제 해결

### 빌드 실패 시
1. **Java 버전 확인**: Java 17 사용 중인지 확인
2. **의존성 문제**: `pom.xml` 확인
3. **로그 확인**: Cloudtype 빌드 로그에서 오류 메시지 확인

### 애플리케이션 실행 실패 시
1. **포트 설정**: PORT 환경 변수가 올바른지 확인
2. **메모리 부족**: 플랜 업그레이드 고려
3. **시작 명령어**: JAR 파일 경로가 정확한지 확인

### 데이터베이스 문제
H2 파일 DB를 사용하려면 `application-prod.properties` 수정:
```properties
spring.datasource.url=jdbc:h2:file:./data/boarddb
```

---

## 💰 요금 및 플랜

Cloudtype 무료 플랜:
- ✅ 무제한 프로젝트
- ✅ 기본 리소스 제공
- ✅ HTTPS 자동 적용
- ✅ GitHub 자동 배포

---

## 📝 체크리스트

배포 전 확인사항:
- [ ] GitHub에 코드 푸시 완료
- [ ] `pom.xml` 파일 확인
- [ ] `.cloudtype.yaml` 파일 존재
- [ ] 포트 설정 확인 (${PORT:8080})
- [ ] H2 데이터베이스 설정 확인

배포 후 확인사항:
- [ ] 애플리케이션 정상 실행
- [ ] 게시판 목록 페이지 접속
- [ ] 게시글 작성/조회 기능 테스트
- [ ] 도메인 정상 작동

---

## 🔗 유용한 링크

- [Cloudtype 공식 문서](https://docs.cloudtype.io/)
- [Spring Boot 배포 가이드](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html)
- [GitHub 저장소](https://github.com/qnzjn123/qnzjn99)

---

## 💡 팁

1. **무료 플랜 활용**: 개인 프로젝트는 무료 플랜으로 충분
2. **자동 배포**: main 브랜치에 푸시만 하면 자동으로 배포됨
3. **HTTPS 자동**: SSL 인증서 자동 적용
4. **모니터링**: 대시보드에서 실시간 로그 확인 가능
5. **스케일링**: 트래픽 증가 시 쉽게 플랜 업그레이드 가능

---

## 🎉 배포 완료!

이제 전 세계 어디서나 접속 가능한 게시판이 완성되었습니다!

접속 주소: `https://your-app-name.cloudtype.app`
