# 1단계: 빌드 스테이지
FROM gradle:8.7-jdk17 AS builder

WORKDIR /app
COPY build.gradle.kts settings.gradle.kts gradle.properties ./
COPY gradle ./gradle
COPY src ./src

RUN gradle build -x test --no-daemon

# 2단계: 실행 스테이지
FROM eclipse-temurin:17-jre

WORKDIR /app
COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 11432
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=11432"]