# language: es
Característica: Gestor de Tareas - Pulse Gym

  Escenario: Agregar una nueva tarea a la lista
    Dado que el usuario navega a la aplicación de tareas en Selenium
    Cuando escribe la tarea "Probar Cucumber con Selenium en Java" en el campo
    Y hace clic en el botón de agregar tarea
    Entonces la tarea "Probar Cucumber con Selenium en Java" debe mostrarse en la lista

  Escenario: Marcar una tarea como completada
    Dado que el usuario navega a la aplicación de tareas en Selenium
    Cuando hace clic sobre la tarea "Aprender automatización con Cypress"
    Entonces la tarea "Aprender automatización con Cypress" debe marcarse como completada

  Escenario: Eliminar una tarea de la lista
    Dado que el usuario navega a la aplicación de tareas en Selenium
    Cuando elimina la tarea "Estudiar Angular 17"
    Entonces la tarea "Estudiar Angular 17" no debe existir en la lista