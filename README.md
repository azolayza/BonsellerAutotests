# Автотесты (UI & API) разработаны для [Web BonSeller](https://seller.bonpass.com/) 
![BonPass](./img/bonpass.png)

## BonSeller
 - это один из сервисов CRM системы [BonPass](https://bonpass.com/)
 - это веб приложение для кассиров ( оформление продаж с учетом настроенной в CRM программы лояльности, скидок и акций)

## :spiral_notepad: Тестовое покрытие:

### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; UI Authorization And Navigation tests
:lock_with_ink_pen: задача [JIRA](https://jira.autotests.cloud/browse/HOMEWORK-370)

> 1. Кнопка Войти недоступна без пароля 
> 2. Кнопка Войти недоступна без логина (телефона)
> 3. Ошибка авторизации с неверным паролем 
> 4. Ошибка авторизации с неверным телефоном 
> 5. Проверка успешной авторизации 
> 6. Переход на страницу Истории через меню 
> 7. Переход на страницу Отчета через меню 
> 8. Переход на страницу Справки через меню 
> 9. Успешный выход из приложения 
> 10. Проверка отсутствия ошибок в консоли для внутренней страницы в авторизованном режиме 
> 11. Проверка отсутсвия ошибок в консоли для страницы атворизации
>
### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; API tests
:lock_with_ink_pen: задача [JIRA](https://jira.autotests.cloud/browse/HOMEWORK-366)

> 1. Проверка генерации токена во время логина
> 2. Проверка получения информации о покупателе по номеру телефона
> 3. Проверка получения истории продаж за выбранный период времени
> 4. Проверка получения каталога продуктов заведения
> 5. Проверка получения отчета по скидкам за выбранный период времени
> 6. Проверка получения плана продаж кассира
> 7. Проверка получения получения списка черновиков (сохраненных) чеков
> 8. Проверка получения профиля кассира
> 9. Проверка получения списка скриптов для кассира
> 10. Создание нового заказа для идентифицированного покупателя
> 11. Создание новой анонимной покупки без идентификации покупателя
> 12. Создание черновика заказа для идентифицированного покупателя
>

### &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Manual cases
:lock_with_ink_pen: задача [JIRA](https://jira.autotests.cloud/browse/HOMEWORK-367)

> 1. Оформление покупки с идентификацией по телефону и подтверждением по коду
> 2. Оформление покупки с подтверждением по коду из приложения
> 3. Оформление покупки с подтверждением по смс-коду
> 4. Проверка каскадных таблиц стилей на соответствия стандарту CSS
> 5. Проверка стартовой страницы валидатором W3C
> 
## :rocket: Технологии и инструменты

<p  align="center">

<code><img width="5%" title="Java" src="img/logo/java-logo.svg"></code>
<code><img width="5%" title="Gradle" src="img/logo/gradle-logo.svg "></code>
<code><img width="5%" title="JUnit5" src="img/logo/junit5-logo.svg"></code>
<code><img width="5%" title="Selenide" src="img/logo/selenide-logo.svg"></code>
<code><img width="5%" title="REST-Assured" src="img/logo/rest-assured-logo.svg"></code>
<code><img width="5%" title="Jenkins" src="img/logo/jenkins-logo.svg"></code>
<code><img width="5%" title="Selenoid" src="img/logo/selenoid-logo.svg"></code>
<code><img width="5%" title="Allure TestOps" src="img/logo/allure-testops-logo.svg"></code>
<code><img width="5%" title="Allure Report" src="img/logo/allure-report-logo.svg"></code>
<code><img width="5%" title="Jira" src="img/logo/jira-logo.svg"></code>
<code><img width="5%" title="Telegram" src="img/logo/telegram-logo.svg"></code>
</p>

* [Java](https://www.oracle.com/java/) - для написания тестов
* [Gradle](https://gradle.org) - для сборки проекта
* [JUnit 5](https://junit.org/junit5/) - для запуска тестов
* [Selenide](https://selenide.org) - для тестирования UI
* [Rest-Assured](https://rest-assured.io) - для тестирования API
* [Jenkins](https://www.jenkins.io/) - для обеспечения процесса непрерывной интеграции
* [Selenoid](https://aerokube.com/selenoid/) - для запуска UI тестов в [Docker containers](https://www.docker.com/resources/what-container)
* [Allure TestOps](https://docs.qameta.io/allure-testops/) и [Allure Report](http://allure.qatools.ru) - для управления тестами, анализа их прохождения и оформления отчетности
* [Jira](https://www.atlassian.com/software/jira) - для отслеживания задач
* [Telegram Bot](https://core.telegram.org/bots) - для оповещения о прохождении тестов

## Особенности реализации тестов:

### UI тесты:

- [x] Page Object
- [x] Параметризованная сборка
- [x] owner.config
- [x] Интеграция с Jira
- [x] Тестпланы авто- и ручного тестирования
- [x] Задачи на дефекты

### API тесты (REST API):

- [x] Использование библиотеки [Rest-assured](https://rest-assured.io/) 
- [x] Спецификации (оформлен единый шаблон оформления запроса и ответа)
- [x] Описание модели получаемых данных с помощью библиотеки [Lombok](https://projectlombok.org/api/)
- [x] Лямбда-подход для описания Allure Step
- [x] Шаблоны форматирования логов запросов

## Запуск и прохождение тестов:

### Локальный запуск тестов:

```
gradle clean test 
```
## <img width="4%" title="Jenkins" src="img/logo/jenkins-logo.svg"> Запуск тестов в [Jenkins](https://jenkins.autotests.cloud/job/010-AzoLayza-HW25/build?delay=0sec)

### :pushpin: Параметры сборки

Параметры для запуска:
- BROWSER (по умолчанию chrome)
- BROWSER_VERSION (по умолчанию 100.0)
- BROWSER_SIZE (по умолчанию 1920x1080)
- REMOTE_DRIVER_URL (url-адрес selenoid, по умолчанию selenoid.autotests.cloud)
- TREADS (по умолчанию 1)

![Parametrised build](./img/jenkins-job-parametrs.png)

![Jenkins](./img/allure-report-detail.png)

### Видео-отчет о прохождении теста из Selenoid:
![Selenoid](./img/video.gif)

## <img width="4%" title="Allure Report" src="img/logo/allure-report-logo.svg"> Отчет о результатах тестирования в [Allure Report](https://jenkins.autotests.cloud/job/010-AzoLayza-HW25/17/allure/)

### :pushpin: Общая информация

![Allure1](./img/allure-report1.png)

*Главная страница Allure-отчета содержит следующие информационные блоки:*

>- [x] <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время прохождения теста, общее количество прогнанных кейсов, а также диаграмму с указанием процента и количества успешных, упавших и сломавшихся в процессе выполнения тестов
>- [x] <code><strong>*TREND*</strong></code> - отображает тренд прохождения тестов от сборки к сборке
>- [x] <code><strong>*SUITES*</strong></code> - отображает распределение результатов тестов по тестовым наборам
>- [x] <code><strong>*ENVIRONMENT*</strong></code> - отображает тестовое окружение, на котором запускались тесты (в данном случае информация не задана)
>- [x] <code><strong>*CATEGORIES*</strong></code> - отображает распределение неуспешно прошедших тестов по видам дефектов
>- [x] <code><strong>*FEATURES BY STORIES*</strong></code> - отображает распределение тестов по функционалу, который они проверяют
>- [x] <code><strong>*EXECUTORS*</strong></code> - отображает исполнителя текущей сборки (ссылка на сборку в Jenkins)



![Allure1](./img/allure-report2.png)
## <img width="4%" title="Allure TestOPS" src="img/logo/allure-testops-logo.svg"> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/1222/dashboards/)

### :pushpin: Основной дашборд

<p align="center">
  <img src="img/TESTOPS-dashboard1.png" alt="dashboards" width="900">
</p>

### :pushpin: Запуски

<p align="center">
  <img src="img/testops-launches.png" alt="launches" width="900">
</p>

### :pushpin: Тест-кейсы

<p align="center">
  <img src="img/testOps-testcases.png" alt="test cases" width="900">
</p>

### :pushpin: Обнаруженные ошибки (Defects)

<p align="center">
  <img src="img/testops-defects.png" alt="test cases" width="900">
</p>

## <img width="4%" title="Jira" src="img/logo/jira-logo.svg"> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-269)

<p align="center">
  <img src="img/bonseller-jira-task.png" alt="jira" width="1000">
</p>

## <img width="4%" title="Telegram" src="img/logo/telegram-logo.svg"> Уведомления в Telegram

<p align="center">
  <img src="img/telegram-bonseller-report.png" alt="Telegram" width="440">
</p>

## Контакты
[<img title="My Github" alt="azolayza | Github" width="30px" src="https://github.githubassets.com/favicons/favicon.svg">](https://github.com/azolayza)
[<img title="My Telegram" alt="azolayza | Telegram" width="30px" src="https://telegram.org/favicon.ico">](https://t.me/azolayza) 