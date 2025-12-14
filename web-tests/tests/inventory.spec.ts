import { test, expect } from '../src/fixtures/pages';

test.describe('Inventory Scenarios', () => {
  test('Agregar 2 productos y validar el badge', async ({ loggedPage, inventoryPage }) => {
    // Ya estás autenticado gracias a loggedPage 👌

    await inventoryPage.verifyPageLoaded();

    await inventoryPage.addProductForName('Sauce Labs Backpack');
    await inventoryPage.addProductForName('Sauce Labs Bike Light');

    const badge = await inventoryPage.getCartBadgeValue();
    expect(badge).toBe(2);
  });
});