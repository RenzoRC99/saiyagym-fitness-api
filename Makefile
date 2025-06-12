# Archivo Compose a usar
COMPOSE_FILE=docker-compose.yml

# Servicio principal
SERVICE=backend

# 🧱 Instala (build) las imágenes Docker necesarias
install:
	docker compose -f \$(COMPOSE_FILE) build

# 🚀 Inicia los servicios (en segundo plano)
start:
	docker compose -f \$(COMPOSE_FILE) up -d

# 🛑 Detiene y elimina los contenedores
stop:
	docker compose -f \$(COMPOSE_FILE) down

# 📄 Muestra los logs del backend
logs:
	docker compose -f \$(COMPOSE_FILE) logs -f \$(SERVICE)
