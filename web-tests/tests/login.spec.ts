import { ERRORS } from '../src/config/errors';
import { test, expect } from '../src/fixtures/pages';

test.describe('Login Scenarios', () => {
  test('Login exitoso', async ({ loginPage }) => {
    const username = process.env.STD_USER;
    const password = process.env.STD_PASS;

    if (!username || !password)
      throw new Error('La variable de entorno STD_USER o STD_PASS no está definida');

    await loginPage.login(username, password);
    await loginPage.assertOnInventory();

    expect(await loginPage.isOnInventory()).toBe(true);
  });

  test('Login sin usuario ni contraseña', async ({ loginPage }) => {
    const error = await loginPage.loginWithoutCredentials();
    await loginPage.assertNotLoggedIn();
    expect(error).toBe(ERRORS.usernameRequired);
  });

  test('Login sin usuario y con contraseña', async ({ loginPage }) => {
    const username = process.env.STD_USER;

    if (!username)
      throw new Error('La variable de entorno STD_USER no está definida');

    const error = await loginPage.loginWithoutUsername(username);
    await loginPage.assertNotLoggedIn();
    expect(error).toBe(ERRORS.usernameRequired);
  });

  test('Login con usuario y sin contraseña', async ({ loginPage }) => {
    const username = process.env.STD_USER;

    if (!username)
      throw new Error('La variable de entorno STD_USER no está definida');

    const error = await loginPage.loginWithoutPassword(username);
    await loginPage.assertNotLoggedIn();
    expect(error).toBe(ERRORS.passwordRequired);
  });

  test('Login usuario bloqueado', async ({ loginPage }) => {
    const username = process.env.STD_USER_LOCKED_OUT;
    const password = process.env.STD_PASS;

    if (!username || !password)
      throw new Error('La variable de entorno STD_USER_LOCKED_OUT o STD_PASS no está definida');

    const error = await loginPage.loginWithBlockedUser(username, password);
    await loginPage.assertNotLoggedIn();
    expect(error).toBe(ERRORS.lockedOutUser);
  });
});
