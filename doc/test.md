# spring-swagger2-markdown-sample模块接口文档

### Security
****  

|oauth2|*OAuth 2.0*|
|---|---|

### /api/v1/channel/startRecord/{appId}/{channelName}

#### POST
##### Summary

startRecord

##### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ---- |
| appId | path | appId | Yes | string |
| channelName | path | channelName | Yes | string |
| record | body | record | Yes | [RecordParam](#recordparam) |

##### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | OK | object |
| 201 | Created |  |
| 401 | Unauthorized |  |
| 403 | Forbidden |  |
| 404 | Not Found |  |

##### Security

| Security Schema | Scopes |
| --- | --- |
| | |

### Models

#### RecordParam

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| streamId | string |  | No |
| vrecordType | string |  | No |
