# Дипломный проект
Разработка приложения по автоматизированному сбору, хранению, выводу для пользователей информации о тендерных закупках лекарственных препаратов в сегменте ФЗ-44 с использованием Telegram API (на примере автоматизированного сбора информации по сегменту “рентгеноконтрастные препараты”)

## Задачи приложения
* Парсер (Python) - сбор данных о новых закупках лекарственных препаратов по категориям:
    * "21.20.23.112: Вещества контрастные",
    * "21.20.10.190: Препараты противомикробные для системного использования",
    * "21.20.10.191: Препараты антибактериальные для системного использования"
* Бот (Java) - бот для отображения данных, исполняющий команды пользователей

## Масштабирование
Приложение может быть дополнено любым количеством категорий лекарственных препаратов. 

## Технологический стэк
* Базы данных: sqllite3
* Библиотеки/зависимости: 
    1. Python – beautifulsoup4, requests, sqllite3; 
    2. Java – TelegramBots API, JPA Hibernate sqllite3;
* Контроль версий: GitHub
## Запуск приложения
### 1. git clone:
1. Скачать приложение к себе на локальный репозиторий с использованием команды git clone

        git clone https://github.com/AlexServGE/PharmaBotJava.git
### 2. Настройка telegram-бота:
1. С использование BotFather зарегистрировать бот и получить токен. Инструкция по регистрации бота: 

        https://marketolog.mts.ru/blog/kak-sozdat-bota-v-botfather-gaid-dlya-novichkov 
2. Перейти в директорию проекта: <b>PharmaBotJava\BotSqlJava\ </b>. Создать файл <b>BotToken.txt</b> в директории <b>PharmaBotJava\BotSqlJava\ </b> (название файла и расширение файла должны строго соответствовать указанному) 
3. Вставить полученный от BotFather токен (без добавления дополнительных символов) в <b>BotToken.txt</b>
### 3. Docker Compose:
1. Перейти в корневую директорию проекта <b>PharmaBotJava/ </b>, где расположен файл <b>docker-compose.yml</b>
2. Развернуть приложение с использованием команды:
        
        docker-compose up

## После запуска:
* <b>Парсер</b> и <b>Telegram-бот</b> запустятся одновременно
В консоли появится сообщение:
        
        bot_container     | SLF4J(W): No SLF4J providers were found.
        bot_container     | SLF4J(W): Defaulting to no-operation (NOP) logger implementation
        bot_container     | SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.

* Необходимо дождаться пока <b>Парсер</b> не вернёт сообщение в командной строке: 

        parser_container  | Начало сбора - ####-##-## ##:##:##.######
        parser_container  | Connection is established: Database is created in memory
        parser_container  | Connection is established: Database is created in memory
        parser_container  | Connection is established: Database is created in memory
        parser_container  | Окончание сбора - ####-##-## ##:##:##.######. Длительность - #:##:##.######
        parser_container exited with code 0
* После этого можно открыть созданный <b>Telegram-бот</b> в приложении Telegram
* Нажать кнопку "Запустить", либо набрать в текстовом поле команду в виде сообщения "/start" и начать работу в приложении
