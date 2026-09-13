import { Given, When, Then } from '@badeball/cypress-cucumber-preprocessor';

// Dado
Given('que el usuario navega a la aplicación', () => {
  cy.visit('/');
});

// Cuando
When('escribe la tarea {string} en el campo de texto', (title: string) => {
  cy.get('[data-cy="task-input"]').type(title);
});

When('hace clic en el botón de agregar tarea', () => {
  cy.get('[data-cy="add-task-btn"]').click();
});

When('hace clic sobre la tarea {string}', (title: string) => {
  cy.get('[data-cy="task-item"]')
    .contains('[data-cy="task-title"]', title)
    .click();
});

When('elimina la tarea {string}', (title: string) => {
  cy.get('[data-cy="task-item"]')
    .contains(title)
    .parents('[data-cy="task-item"]')
    .find('[data-cy="delete-task-btn"]')
    .click();
});

// Entonces
Then('el título principal debe ser {string}', (expectedTitle: string) => {
  cy.get('[data-cy="main-title"]').should('have.text', expectedTitle);
});

Then('la lista debe contener {int} tareas predeterminadas', (count: number) => {
  cy.get('[data-cy="task-item"]').should('have.length', count);
});

Then('la lista debe contener la tarea {string}', (title: string) => {
  cy.get('[data-cy="task-list"]')
    .contains('[data-cy="task-item"]', title)
    .should('be.visible');
});

Then('la tarea {string} debe marcarse como completada', (title: string) => {
  cy.get('[data-cy="task-item"]')
    .contains('[data-cy="task-title"]', title)
    .parents('[data-cy="task-item"]')
    .should('have.class', 'completed');
});

Then('la tarea {string} no debe existir en la lista', (title: string) => {
  cy.get('[data-cy="task-list"]')
    .contains('[data-cy="task-item"]', title)
    .should('not.exist');
});