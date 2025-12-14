# Web Tests – Prueba Técnica

Este módulo contiene las pruebas automatizadas de la aplicación web usando **Playwright** y **JavaScript/TypeScript**.  

---

## Estructura del módulo

web-tests/
├── package.json ← Configuración de NPM y dependencias
├── playwright.config.ts ← Configuración de Playwright
├── tests/ ← Carpeta principal de tests
│ ├── login/ ← Pruebas de login
│ ├── inventory/ ← Pruebas de productos
│ ├── cart/ ← Pruebas de carrito de compras
│ └── checkout/ ← Flujo de checkout
│ └── overview/ ← pruebas de finalizar la compra
├── pages/ ← Page Objects (POM)
│ ├── LoginPage.ts
│ ├── InventoryPage.ts
│ ├── CartPage.ts
│ ├── OverviewPage.ts
│ └── CheckoutPage.ts
└── reports/ ← Reportes de ejecución

## Tecnologías utilizadas

- **Node.js 18+**
- **Playwright** (automatización web)
- **TypeScript** (tipado seguro)
- **Page Object Model (POM)** para organizar los selectores y acciones
- **Allure o Playwright reporter** para reportes

---

## Configuración previa

1. Clonar el repositorio:
```bash
git clone https://github.com/JhonSM39/prueba-nexos.git
cd prueba-automation/web-tests

2. Instalar dependencias
npm install

3. Ejecutar pruebas
todo los test (npm run test:allure)
un test (npm run test:allure -- tests/login.spec.ts)

4. Reportes Allure
npm run allure:report
cd ./allures/reports/
python3 -m http.server 8080
