# ベースイメージの指定
FROM openjdk:11-jre-slim

# アプリケーションの作成者情報
LABEL maintainer="yjtoyama@example.com"

# JARファイルをコンテナにコピー
COPY target/demo2-java-1.0-SNAPSHOT.jar /app/app.jar

# コンテナのポート指定
EXPOSE 8000

# アプリケーションの実行コマンド
CMD ["java", "-jar", "/app/app.jar"]
