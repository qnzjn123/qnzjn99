# 배포 스크립트 (Windows PowerShell)

Write-Host "=== Spring Boot 게시판 배포 스크립트 ===" -ForegroundColor Green

# 1. 애플리케이션 빌드
Write-Host "1. 애플리케이션 빌드 중..." -ForegroundColor Yellow
mvn clean package -DskipTests

if ($LASTEXITCODE -ne 0) {
    Write-Host "빌드 실패!" -ForegroundColor Red
    exit 1
}

# 2. 기존 프로세스 종료
Write-Host "2. 기존 프로세스 종료 중..." -ForegroundColor Yellow
$process = Get-NetTCPConnection -LocalPort 8080 -ErrorAction SilentlyContinue | Select-Object -ExpandProperty OwningProcess -Unique
if ($process) {
    Stop-Process -Id $process -Force
    Write-Host "기존 프로세스 종료됨 (PID: $process)" -ForegroundColor Cyan
}

# 3. 애플리케이션 시작
Write-Host "3. 애플리케이션 시작 중..." -ForegroundColor Yellow
Start-Process -NoNewWindow -FilePath "java" -ArgumentList "-jar","target\demo-0.0.1-SNAPSHOT.jar","--spring.profiles.active=prod" -RedirectStandardOutput "app.log" -RedirectStandardError "app-error.log"

Write-Host "배포 완료!" -ForegroundColor Green
Write-Host "애플리케이션 로그: Get-Content app.log -Wait" -ForegroundColor Cyan
Write-Host "브라우저에서 http://localhost:8080 접속" -ForegroundColor Cyan
