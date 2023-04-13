# ZOO-API
### Pasos para la instalación
1. Instalar nodejs ^16.19.0
2. Clonar este repositorio
3. Crear una base de datos en mysql
4. Crear un archivo `.env` en el root del proyecto, con los siguientes valores
```
PORT = 3000

# Database Configuration

DB_HOST=localhost
DB_PORT=3306
DB_NAME=ZOO
DB_USER=root
DB_PASS=root
```

Ejecutar el siguiente comando para construir la base de datos

```
  npm run build-db
```
Ejecutar el siguiente comando para correr el sevidor de desarrollo

```
  npm run dev
```
Ejecutar el siguiente comando para construir la API
```
  npm run build
```
Ejecutar el siguiente comando para construir y correr el entorno de producción
```
  npm run start
```
