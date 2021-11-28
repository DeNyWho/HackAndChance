API сервиса

Запрос создается с помощью HTTP. Запросы делаются в виде:

НТТР-запрос url/api/category/object?data.

url – url-адрессервиса

api – категория (также записывается api)

category – выбранная категория

object – выбранная функция

data – передаваемыеданные (name=Ivan&amp;&amp;first\_name=Ivanov)

все параметры, которые находятся в parameter могут со временем изменяться в количестве полей, которые будут дополняться инструкцией (спецификацией).

Account

GetAccess(parameters) – запрос доступа к сервису. Ответом является JSON-объект. В случае успеха в объекте находится только одно поле – token(число). В случае неуспеха:

1. Если не хватает полей для аутентификации, то в ответном запросе будет поле undefined\_fields (массив строк).
2. Если данные неверны, то возвращается поле incorrect\_fields (bool).

AccountChangeParameters(token, parameters) – изменение параметров и данных в аккаунте (возможно расширить функционал)

GetAccount(parameters) – возращает JSON объект аккаунтов по параметру.

StructuralChangeAccount(token)- структурные изменения в аккаунте (изменения, связь с другим, удаление, выход)

DeleteAccount(token)-удаление аккаунта. //пока не утвержденный.

Messenger

GetTalkId(token,parameters) – возвращает JSON объектдиалогов, удовлетворяющеепараметрам (parameters: list id).

GetMessage(token, parameters) возвращает JSON объект сообщений удовлетворяющее параметрам. (parameters: поля (по дефолту string - поле со подстрокой, которую мы ищем) + поле order – служебный параметр (по умолчанию самое новое))

ChangeMessage(token, idmessage, parameters ) – изменяетсообщениесданным id попараметру (поле change: delete, change ит.д.)

CreateMessage(token, TalkID, parameters) – добавляетвбеседу TalkId сообщениеспараметром parameters (чащевсегострокасообщения). Возвращает MessageID

CreateTalk(token, parameters) – создаетдиалогивозращает TalkID

ChangeTalk(token, TalkID, parameters) – изменяетпараметрыпополям parameters в TalkId беседе.

News

CreateNews(Token, parameters) – создание новостей от юзера по параметрам

ChangeNews(Token, parameters) – изменения структуры или самих новостей по параметрам.

GetNews(parameters) – получить информацию о новости по параметрам.