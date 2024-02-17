## Проект по автоматизации тестирования для сайта [АО «Райффайзенбанк»](https://www.raiffeisen.ru/)
## :pushpin: Содержание:

- [Использованный стек технологий](#computer-использованный-стек-технологий)
- [Список авто/ручных тестов](#tests-список-авто/ручных-тестов)
- [Список проверок, реализованных в автотестах](#arrow_forward-запуск-тестов-из-терминала)
- [Запуск тестов из терминала](#arrow_forward-запуск-тестов-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Пример Allure-отчета](#пример-allure-отчета)
- [Уведомления в Telegram с использованием бота](#уведомления-в-telegram-с-использованием-бота)
- [Видео примера запуска тестов в Selenoid](#-видео-примера-запуска-теста-в-selenoid)

  ## :computer: Использованный стек технологий

<p align="center">
<a href="https://www.java.com/"><img src="/media/logo/java.svg" width="70" height="70"  alt="Java"/></a>
<a href="https://www.jetbrains.com/idea/"><img src="media/logo/IJ.svg" width="70" height="70"  alt="IDEA"/></a>
<a href="https://www.selenide.org/"><img src="media/logo/selenide.svg" width="70" height="70" alt="Selenide" title="Selenide"/></a> 
<a href="https://aerokube.com/selenoid/"><img src="media/logo/selenoid.svg" width="70" height="70"  alt="Selenoid"/></a>
<a href="https://github.com/allure-framework"><img src="media/logo/allure.svg" width="70" height="70"  alt="Allure"/></a>
<a href="https://gradle.org/"><img src="media/logo/gradle.svg" width="70" height="70"  alt="Gradle"/></a>
<a href="https://junit.org/junit5/"><img src="media/logo/jUnit5.svg" width="70" height="70"  alt="JUnit 5"/></a>
<a href="https://www.jenkins.io/"><img src="media/logo/jenkins.svg" width="70" height="70"  alt="Jenkins"/></a>
<a href="https://www.atlassian.com/software/jira/"><img src="media/logo/Jira.svg" width="70" height="70" alt="Jira" title="Jira"/></a> 
<a href="https://github.com/"><img src="media/logo/gitHub.svg" width="70" height="70"  alt="GitHub"/></a>
<a href="https://web.telegram.org/"><img src="media/logo/telegram.svg" width="70" height="70"  alt="Telegram"/></a>
</p>

- В проекте автотесты написаны на языке <code>Java</code> с использованием фреймворка для тестирования [Selenide](https://selenide.org/).
- Cборщик - <code>Gradle</code>.  
- Использован <code>JUnit 5</code> в качестве фреймворка модульного тестирования.
- При прогоне тестов браузер запускается в [Selenoid](https://aerokube.com/selenoid/).
- Для удаленного запуска реализована джоба в <code>Jenkins</code> с формированием Allure-отчета и отправкой результатов в <code>Telegram</code> при помощи бота. 
- Осуществлена интеграция с <code>Allure TestOps</code> и <code>Jira</code>.
  
Содержание Allure-отчета для каждого кейса:
- Шаги теста и результат их выполнения
- Скриншот страницы на последнем шаге (возможность визуально проанализировать, почему упал тест)
- Page Source (возможность открыть source страницы в новой вкладке и посмотреть причину падения теста)
- Логи консоли браузера
- Видео выполнения автотеста.

  
## Список авто/ручных тестов
**Автотесты на основном сайте РайфайзенБанк**
- [x] Проверка разделов в меню
- [x] Открытие первого офиса из списка
- [x] Проверка подсвечивания незаполненных полей в онлайн чате
- [x] Проверка наличия объектов к аренде
- [x] Проверка наличия списка страховых компаний  

**Автотесты на страницу Вакансии**
- [x] Проверка наличия вакансий IT и DGTL
- [x] Поиск вакансии QA
- [x] Проверка нотифкации при отсутсвии вакансии

**Список проверок ручного тестирования**
- [x] Проверка переключения сайта на английский язык
- [x] Проверка перехода с сайта в Онлайн-банк
- [x] Проверка заголовков меню для корпоративного бизнеса


## :arrow_forward: Запуск автотестов

### Запуск тестов на удаленном браузере
Локальный запуск тестов
```
gradle clean test 
```
При необходимости также можно переопределить параметры запуска

```
gradle clean test 
main -DremoteUrl=${SELENOID}
-DbrowserSize=${SIZE}
-Dbrowser=${BROWSER}
-Dbrowser_version="${VERSION}"
```
## <img src="media/logo/jenkins.svg" title="Allure TestOps" width="4%"/> Созданный проект в [Jenkins](https://jenkins.autotests.cloud/job/emonovaev_project/)
<p align="center">
<img title="allure-report" src="media/screen/JenkinsProject.png">
</p>

### Параметры сборки
В сборку были добавлены следующие параметры:
* <code>TASK</code> (набор тестов для запуска)
* <code>BROWSER</code> – браузер, в котором будут выполняться тесты. По умолчанию - <code>chrome</code>.
* <code>SIZE</code> – размер окна браузера, в котором будут выполняться тесты. По умолчанию 1920x1080
* <code>VERSION</code> – версия браузера, в которой будут выполняться тесты. По умолчанию - <code>100.0</code>.
* <code>SELENOID</code> – адрес удаленного сервера, на котором будут запускаться тесты.

## <img src="media/logo/jenkins.svg" title="Jenkins" width="4%"/> Страница запуска в Jenkins
<p align="center">
<img title="allure-report" src="media/screen/JenkinsJoba.png">
</p>

## <img src="media/logo/allure.svg" title="Allure TestOps" width="4%"/> Пример [Allure-отчета](https://jenkins.autotests.cloud/job/emonovaev_project/18/allure/)
В отчете отображены пройденные автотесты. На приложенном изображении открыт тест кейс, отображены его шаги, прикреплены логи, скрины и видео
<p align="center">
<img title="Allure Overview" src="media/screen/allure-report.png">
</p>

## Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4013/dashboards)

Выполнена интеграция сборки <code>Jenkins</code> с <code>Allure TestOps</code>.
Результат выполнения автотестов отображается в <code>Allure TestOps</code>
На Dashboard в <code>Allure TestOps</code> отображена статистика пройденных тестов.

<p align="center">
<img title="Allure TestOps DashBoard" src="media/screen/allureTestOps.png">
</p>

## <img src="media/logo/Jira.svg" title="Allure TestOps" width="4%"/> Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1094)

Реализована интеграция <code>Allure TestOps</code> с <code>Jira</code>, в тикете отображается информация, какие тест-кейсы были написаны в рамках задачи и результат их прогона.

<p align="center">
<img title="Jira Task" src="media/screen/jiraTask.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Telegram" src="media/logo/telegram.svg"> Уведомления в Telegram с использованием бота

После завершения сборки, бот созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с результатом.

<p align="center">
<img title="Telegram Notifications" src="media/screen/telegramBot.png"  width="400">
</p>

## Видео примера запуска тестов в Selenoid

К каждому тесту в отчете прилагается видео прогона.
<p align="center">
  <img title="Selenoid Video" src="media/video.gif">
</p>
