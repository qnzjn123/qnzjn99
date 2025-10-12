#!/bin/bash
# JAR 파일 찾기 및 실행
JAR_FILE=$(find target -name "*.jar" -not -name "*original*" | head -n 1)
echo "Found JAR file: $JAR_FILE"
java -Xmx256m -Xms128m -Dserver.port=$PORT -jar $JAR_FILE
