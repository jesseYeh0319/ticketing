## Day 1

* **1.  Git 初始化 + 第一個 commit**（順便設定了 user.name / user.email）
* **2.  解決 JAVA_HOME**——用 `[Environment]::SetEnvironmentVariable` 設到 User 範圍
* **3.  Maven wrapper 跑起來**，確認 Spring Boot 4.1.0 + Java 21 能編譯啟動
* **4.  建了 docker-compose.yml**，PostgreSQL 17 起來且 healthy（中間還排除了一次公司網路的 DNS 問題）
* **5.  寫了 application.yml**——`ddl-auto: validate`、`open-in-view: false`、Actuator 端點
* **6.  第一支 Flyway migration**（`V1__create_event.sql`），啟動時自動建表成功
* **7.  `/actuator/health` 回 db: UP**，整條鏈驗證完成
* **8.  Repo 推上 GitHub**（`jesseYeh0319/ticketing`），開始累積公開的 commit 歷史
