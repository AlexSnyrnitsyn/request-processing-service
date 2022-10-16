# Request processing service
Request processing service - это сервис для обработки запросов. Данный сервис состоит из трех объектов: Request, Folder, Tag, связь которых позволяет выбрать request по любому tag, а также выбрать request по любому folder. Также релизован поиск request по полю text, при помощи ElasticSearch.

---

## OpenAPI & Swagger
#### OpenAPI
Для описания API для REST API используется OpenAPI.
#### Swagger
В проекте используется swagger -  http://localhost:4546/swagger-ui/index.html

---

Локальная разработка
-------------------
#### Запуск docker-compose
~~~
docker-compose up -d
~~~
---
#### Стек технологий применяемый в проекте:
* Spring boot
* Spring Data
* Swagger
* Postgres
* ElasticSearch
* Mapstruct
* Liquibase
* Lombok