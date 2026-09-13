# language: es
Característica: Gestión de Tareas - Pulse Gym

  Escenario: Cargar las tareas iniciales correctamente
    Dado que el usuario navega a la aplicación
    Entonces el título principal debe ser "Gestor de Tareas - Pulse Gym"
    Y la lista debe contener 2 tareas predeterminadas

  Escenario: Agregar una nueva tarea
    Dado que el usuario navega a la aplicación
    Cuando escribe la tarea "Revisar código del proyecto" en el campo de texto
    Y hace clic en el botón de agregar tarea
    Entonces la lista debe contener la tarea "Revisar código del proyecto"

  Escenario: Marcar tarea como completada y eliminarla
    Dado que el usuario navega a la aplicación
    Cuando hace clic sobre la tarea "Aprender automatización con Cypress"
    Entonces la tarea "Aprender automatización con Cypress" debe marcarse como completada
    Cuando elimina la tarea "Estudiar Angular 17"
    Entonces la tarea "Estudiar Angular 17" no debe existir en la lista