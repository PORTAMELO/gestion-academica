# INSTRUCCIONES DE DESPLIEGUE
## Pasos para ejecutar el proyecto

**1. Clonar el repositorio**
```bash
git clone <url-repositorio-backend>
```
**2. Entrar a la carpeta**
```bash
cd gestion-academica
```
**3. Levantar los contenedores**
```bash
docker compose up -d --build
```
**4. Restaurar datos de prueba**

Windows PowerShell:
```bash
Get-Content database\backup.dump | docker exec -i gestion_academica_db psql -U admin -d gestion_academica
```

Linux/Mac:
```bash
docker exec -i gestion_academica_db psql -U admin -d gestion_academica < database/backup.dump
```

**5. Verificar que la API esta corriendo**
```
http://localhost:8080/api/alumnos
```

## Backend - Gestión Académica
API REST desarrollada con Java 17 y Spring Boot 3.5.13

### Tecnologías
- Java 17
- Spring Boot 3.5.13
- Spring Data JPA
- PostgreSQL 15
- Docker

### Requisitos previos
- Docker Desktop instalado y corriendo

### Variables de entorno
Las variables están configuradas en el archivo `.env` en la raíz del proyecto:

| Variable      | Valor por defecto  | Descripción              |
|---------------|--------------------|--------------------------|
| POSTGRES_DB   | gestion_academica  | Nombre de la base de datos |
| DB_USER       | admin              | Usuario de la base de datos |
| DB_PASSWORD   | admin123           | Contraseña de la base de datos |
| DB_PORT       | 5432               | Puerto de PostgreSQL |
| SERVER_PORT   | 8080               | Puerto del backend |
