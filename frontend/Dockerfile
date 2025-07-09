# 1단계: 빌드 스테이지
FROM node:20-alpine AS builder

# corepack 완전 비활성화 + yarn 1.22.22 설치
RUN corepack disable && npm install -g yarn@1.22.22
ENV COREPACK_ENABLE=0

WORKDIR /app

# 패키지 설치 및 앱 소스 복사
COPY package.json yarn.lock ./
RUN yarn install --frozen-lockfile
COPY . .

# 앱 빌드
RUN yarn build

# 2단계: 실행 스테이지 (정적 파일 서빙)
FROM node:20-alpine

# corepack 차단 + yarn 1.22.22 재설치
RUN corepack disable && npm install -g yarn@1.22.22
ENV COREPACK_ENABLE=0

WORKDIR /app

# 빌드된 파일과 실행 스크립트 복사
COPY --from=builder /app ./

EXPOSE 11431

CMD ["yarn", "preview", "--port", "11431", "--host", "0.0.0.0", "--strictPort"]