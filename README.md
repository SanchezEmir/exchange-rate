# exchange-rate

## login
POST: localhost:8080/login
```bash
{
    "username": "demo1@gmail.com",
    "password": "123"
}
``` 
## convert
GET: localhost:8080/api/v1/currency-converter/currency

Authorization: Bearer <...>
```bash
{
    "amount": 100.00,
    "originCurrency": "USD",
    "finalCurrency": "PEN"
}
```
