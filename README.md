# Автотесты разработаны для [Web BonSeller](https://seller.bonpass.com/) 
![BonPass](./img/bonpass.png)
BonSeller
- это один из сервисов CRM системы [BonPass](https://bonpass.com/)
- это веб приложение для кассиров ( оформление продаж с учетом настроенной в CRM программы лояльности, скидок и акций)
## Тестовое покрытие:

- [x] UI тесты на проверку авторизации на странице https://seller.bonpass.com/login
- [x] UI тесты на проверку навигации по страницам приложения
- [x] API тесты на регрес проверку базовых методов работы приложения
- [x] Ручные тесты проверки верстки приложения и тестов на основе динамических кодов подтверждения

## Технологии и инструменты

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
* ## Запуск и прохождение тестов:

### Команда для локального запуска тестов:

```
gradle clean test 
```
### Для удаленного запуска тестов воспользуйтесь [Jenkins](https://jenkins.autotests.cloud/job/09_sprokaev_Web-UI_API/build?delay=0sec)
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

### Результаты прохождения тестов в [Allure Report](https://jenkins.autotests.cloud/job/09_sprokaev_Web-UI_API/27/allure/)
![Allure1](./img/allure-report1.png)

### Результаты прохождения тестов в Allure TestOps
![Allure2](./img/testOps-testcases.png)

### Результаты прохождения тестов в Jira
![Allure2](./images/bonseller-jira-task.png)

### Уведомление о прохождении тестов в Telegram
![Allure2](./images/telegram-bonseller-report.png)