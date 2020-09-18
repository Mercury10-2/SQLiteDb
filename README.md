1. Сводные таблицы подразумевают уникальность рядов, тогда как в вашем примере ряды не уникальны;
2. SQLite не поддерживает PIVOT функцию, а реализация динамического обращения рядов в столбцы достаточно сложна.

По указанным причинам я реализовал простое обращение к БД, максимально приближенное по возвращаемому результату к примеру, приведённому в задании,
и без агрегаций - ибо мало того что агрегации вне сводных таблиц вызвали у меня вопросы, так ещё и сам тип агрегации нигде не указан.

Работа приложения проверена на Postman'е.

Реализация:
БД лежит в resources, путь к ней указан в сервисе.

Контроллер:
1. Получает на вход строку и парсит её в инстанс класса RequestDto, после чего отправляет её в сервис.

Сервис:
1. Формулирует sql-запрос на базе payload'а.
2. Пытается подключиться к БД, если не выходит, бросает SQLException.
3. Пакует ответ БД в ResponseDto инстансы, заворачивает их в список и шлёт обратно контроллеру.
