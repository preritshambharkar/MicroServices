# NotificationService

This microservice publishes and consumes notification events using RabbitMQ and registers in Eureka as `NOTIFICATION-SERVICE`.

## Run Without Docker Compose (Default)

By default, the service starts in standalone mode:
- `notification.rabbitmq.enabled=false`
- `eureka.client.enabled=false`

```bash
mvn spring-boot:run
```

`/notifications/*` APIs still work and return generated notification payloads.

## Full Mode (RabbitMQ + Eureka)

Start Service Registry:

```bash
cd ../ServiceRegistry
mvn spring-boot:run
```

Start RabbitMQ (optional via Docker Compose):

```bash
cd ../NotificationService
docker compose up -d
```

RabbitMQ UI: `http://localhost:15672`  
Credentials: `guest / guest`

Enable integrations and run NotificationService:

```bash
export NOTIFICATION_RABBITMQ_ENABLED=true
export EUREKA_CLIENT_ENABLED=true
mvn spring-boot:run
```

PowerShell:

```powershell
$env:NOTIFICATION_RABBITMQ_ENABLED = "true"
$env:EUREKA_CLIENT_ENABLED = "true"
mvn spring-boot:run
```

Service URL: `http://localhost:8084`

## API Examples

Publish a custom message:

```bash
curl -X POST http://localhost:8084/notifications/publish \
  -H "Content-Type: application/json" \
  -d '{
    "userId": "user-2002",
    "recipient": "john@example.com",
    "subject": "Auction Reminder",
    "message": "Your auction closes in 30 minutes.",
    "channel": "email"
  }'
```

Publish built-in sample:

```bash
curl -X POST http://localhost:8084/notifications/example
```
