# Android-приложение для поиска вакансий, размещенных на сервисе [HeadHunter](https://hh.ru/)

## Общая функциональность приложения:
- Поиск вакансий;
- Указание фильтров для поиска;
- Просмотр деталей отдельной вакансии;
- Добавление вакансий в список "Избранного".

## [Wiki проекта](https://github.com/falconArdente/HeadHunter_Job_Search_team/wiki)
## [Доска разработки проекта](https://github.com/users/falconArdente/projects/1/)

# Сборка приложения

## Использование релиза, размещенного в репозитории
- Минимальная поддерживаемая версия операционной системы - Android 8.0 (API level 26);
- [Apk-файл релиза](https://github.com/falconArdente/HeadHunter_Job_Search_team/releases) уже содержит токен для аутентификации приложения и готов для использования на устройстве.
## Последующее использование репозитория
- Приложение успешно компилируется в среде разработки Android Studio Jellyfish | 2023.3.1 Patch 1 в соответствии настройкам конфигурационных файлов репозитория;
- Дли использования функционала [HeadHunter API](https://api.hh.ru/openapi/redoc#section/Obshaya-informaciya) в собственных форках необходимо пройти регистрацию и получить Bearer-токен приложения. В настоящем репозитории он содержится в защищенной секции Secrets, и не может быть использован в форках напрямую;
- Полученный Bearer-токен приложения необходимо прописать в поле "GH_HH_ACCESS_TOKEN" секретов репозитория форка и в локальный файл "develop.properties" ключём вида "hhAccessToken=Bearerтокен".
  
![GitHub top language](https://img.shields.io/github/languages/top/falconArdente/HeadHunter_Job_Search_team)
![GitHub Repo stars](https://img.shields.io/github/stars/falconArdente/HeadHunter_Job_Search_team)
