# API Tests – Prueba Técnica

Este módulo contiene las pruebas automatizadas de la API usando **Java**, **Maven** y **RestAssured**.  

---

## Estructura del módulo

api-tests/
├── pom.xml ← Configuración de Maven
├── src/
│ ├── main/java/com/automation/api/
│ │ ├── App.java
│ │ └── models/
│ │ ├── UserRequest.java
│ │ └── UserResponse.java
│ └── test/java/com/automation/api/
│ ├── config/ ← Configuración de la API
│ ├── helpers/ ← Builders / RequestBuilder
│ ├── services/ ← Clases de servicios
│ └── tests/user/ ← Pruebas de endpoints (CRUD)
├── target/ ← Resultados de la ejecución
└── testng.xml ← Suite de pruebas

## Tecnologías utilizadas

- **Java 17+**
- **Maven** (gestión de dependencias)
- **RestAssured** (automatización de API)
- **TestNG** (gestión de tests)
- **Allure** (reportes de ejecución)
- **Hamcrest** (validaciones)

---

## Configuración previa

1. Clonar el repositorio:
```bash
git clone https://github.com/JhonSM39/prueba-nexos.git
cd prueba-automation/api-tests

2. Instalar dependencias
mvn clean install

3. Ejecutar pruebas
mvn clean test

4. Reportes Allure
allure serve target/allure-results
---