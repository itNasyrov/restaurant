# restaurant
## Модуль Заказы (Order)

### Назначение

Модуль Заказы предназначен для работы с заказами, сформированными 
из блюд меню. Заказ состоит из основной части, характеризующей заказ, и переменной части,
состоящей из блюд меню. Модуль позволяет:
 * добавлять, удалять, обновлять, просматривать заказы
 * добавлять блюда в заказ
 * менять статус заказа
 * получать информацию о заказах 
 
### Структура

##### Заказы (orders)
1. **id** bigint — первичный ключ    
2. **date** timestamp — дата и время заказа  
3. **date_ready** timestamp — дата и время выполнения заказа
3. **customer character** varying(255) — заказчик
4. **tableNumber** integer — номер столика
5. **status** character varying(20) — статус заказа [новый, готов]
6. **comment** character varying(255) — комментарий к заказа

##### Строчки заказа (order_items)
1. **id** bigint — первичный ключ    
2. **name** character varying(255) — наименование блюда   
3. **amount** integer — количество

### Обращение к модулю
Обращение к модулю осуществляется на основании REST запросов с корнем

 ```/order```
 
#### Список запросов REST:

1. Добавить заказ.  
    
   ```/add```
   
    Post метод. Производится добавление данных о заказе, находящихся в теле запроса, в БД.
   
2. Обновить заказ.
     
   ```/update```
   
    Post метод. Производится обновление существующего заказа в БД. Обновленные данные расположены в теле запроса.
   
3. Просмотреть заказ по указанному номеру заказа: 
 
   ```/get/{id}```
   
    Get метод. В запросе передается номер заказ {id}. В ответе получаем данные о заказе. Если заказ с номером id не найден, то возвращается пустой ответ. 
 
4. Удалить заказ по указанному номеру заказа:  
 
   ```/delete/{id}```
   
   Delete метод. Удаляется заказ с указанным номером {id} из базы данных.
 
5. Получить список заказов, относящимуся к определенному столику. 
 
   ```/table/{table}```
   
   Get метод. Получаем список заказов, относящимся к столику, номер которого {table} указан в запросе.
   
6. Получить список всех заказов. 
 
   ```/all```
   
   Get метод. Получаем список всех заказов из БД.
 
7. Получить список заказов с определенным статусом. 
 
   ```/status/{status}```
   
   Get метод. Получаем список заказов из БД со статусом, введенном в запросе {status}. Если указан несуществующий статус, возвращается пустой список.
  
8. Получаем последний заказ для столика.
  
   ```/lastorder/{table}```
   
   Get метод. Получаем последний заказ для столика, номер которого {table} указан в запросе.                                                            

9. Добавить блюдо в заказ.
  
   ```/additem/{id}```
   
   Get метод. Производится добавление блюда, передаваемого в теле запроса, к 
    заказу, номер которого {id} задается.
  
10. Изменить состояние заказа. 
 
    ```/changestatus/{id}/{status}```
    
     Post метод. Меняем сосояние заказ {status} для заказа с номером {id}. Если введем несуществующий номер заказа, то возвращается пустой ответ. 
     Если введем несуществующий статус, то статус заказа не изменится.
     Если введем статус "готов", то поле **date_ready** заказа заполняется текущими датой и временем.