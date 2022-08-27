# Money Transfer Service "Сервис перевода денег"

## Описание проекта

Разработать приложение - REST-сервис. Сервис должен предоставить интерфейс для перевода денег с одной карты на другую по
заранее описанной спецификации. Заранее подготовленное веб-приложение (FRONT) должно подключаться к разработанному
сервису без доработок и использовать его функционал для перевода денег.

## Требования к приложению

- Сервис должен предоставлять REST интерфейс для интеграции с FRONT
- Сервис должны реализовывать все методы перевода с одной банковской карты на другую описанные в
  протоколе https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml
- Все изменения должны записываться в файл (лог переводов в произвольном формате с указанием даты, времени, карта с
  которой было списание, карта зачисления, сумма, комиссия, результат операции если был)

## Требования в реализации

- Приложение разработано с использованием Spring Boot
- Использован сборщик пакетов gradle/maven
- Для запуска используется docker, docker-compose
- Код размещен на github
- Код покрыт unit тестами с использованием mockito
- Добавлены интеграционные тесты с использованием testcontainers
- Шаги реализации:
- Изучить протокол получения и отправки сообщений
- Нарисовать схему приложений
- Описать архитектуру приложения (где хранятся настройки, описать формат хранения данных о картах)
- Создать репозиторий проекта на github
- Протестировать приложение с помощью curl/postman
- Написать dockerfile и создать контейнер
- Написать docker-compose скрипт для запуска FRONT и написанного REST-SERVICE
- Протестировать запуск с помощью docker-compose и интеграцию с FRONT
- Написать README.md к проекту, где описать команду запуска, порт и примеры запросов.
- Отправить на проверку

## Описание интеграции с FRONT

FRONT доступен по адресу https://github.com/serp-ya/card-transfer, можно выкачать репозиторий и запустить nodejs
приложение локально
(в описании репозитория фронта добавлена информация как запустить) или использовать уже развернутое демо приложение по
адресу https://serp-ya.github.io/card-transfer/ (тогда ваш api должен быть запущен по адресу http://localhost:5500/).
> Весь api фронта был описан в соответствии yaml (https://github.com/netology-code/jd-homeworks/blob/master/diploma/MoneyTransferServiceSpecification.yaml)
файла по спецификации openapi (подробнее тут https://swagger.io/specification/ и тут https://starkovden.github.io/introduction-openapi-and-swagger.html)

*****************
## Вариант 1 Dockerfile
- Запускаем терминал и cобираем jar архив с нашим spring boot приложением: `./gradlew clean build`
- Создаем образ из нашего Dockerfile, мы должны запустить: `docker build --tag=myapp:latest .`
- Запускаем контейнер из нашего образа: `docker run --rm -p5500:5500 -it myapp`

## Вариант 2 с помощью файла docker-compose.yml
- Запускаем терминал и cобираем jar архив с нашим spring boot приложением: `./gradlew clean build`
- в терминале и выполнить команду: `docker-compose up`

## Проверка
- Протестировать приложение в браузере: https://serp-ya.github.io/card-transfer/
- Протестировать приложение с помощью curl/postman

POST request --> http://localhost:5500/transfer
```
{
"cardFromNumber": "1115666600101892",
"cardFromValidTill": "05/23",
"cardFromCVV": "530",
"cardToNumber": "5555636200001111",
"amount": {
"value": 67899,
"currency": "RUB"
}
}
```

 response --> 200 OK

```
{
"operationId": "1"
}
```
response --> 400 and 500

```
{
"message": "string",
"id": 0
}
```
------------------------------------------------
POST request --> http://localhost:5500/confirmOperation

```
{
"operationId":  "1",
"code": "2304"
}
```

response --> 200 OK
```
{
"operationId": "1"
}
```
response --> 400 and 500
```
{
"message": "string",
"id": 0
}
```

Для логирования используется SLF4J (Simple Logging Facade for Java)
Настройка через файл `/src/main/resources/logback.xml`

*****
## Запуск приложения front на http://localhost:3000 с помощью docker
* Вариант запуска с помощью файла docker-compose.yml
- в терминале в папке /card-transfer-master и выполнить команду: `docker-compose up`



