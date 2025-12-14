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
npx playwright test

4. Reportes Allure
npx playwright show-report

# Genera el reporte a partir de los resultados de la ejecución
allure generate target/allure-results --clean -o target/allure-report

# Abre el reporte en el navegador
allure open target/allure-report
