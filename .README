 
 
El patrón Observer es un patrón de diseño de comportamiento que define una relación de uno a muchos entre objetos de manera que, cuando un objeto cambia su estado, todos sus dependientes (observadores) son notificados y actualizados automáticamente. Este patrón es utilizado comúnmente para implementar sistemas donde un objeto (llamado "sujeto" u "observable") necesita notificar a otros objetos (llamados "observadores") sobre cambios en su estado sin conocer quiénes son esos observadores.

 Observable: Representa una secuencia de eventos o cambios asincrónicos. Puede ser cualquier cosa que genere eventos, como clics de usuario, datos de sensores, mensajes de red, etc.
 Observer (suscriber): Es aquel que desea ser informado cuando ocurren eventos en el Observable. El Observer se suscribe al Observable para recibir notificaciones cuando haya cambios.
 
 
 En el proyecto Reactor de Java, que es una biblioteca para programación reactiva, el método subscribe() también se utiliza para suscribir un Subscriber a un Flux o a un Mono. Ambos Flux y Mono son tipos de Reactor que representan secuencias de eventos en programación reactiva.

 Flux: Representa una secuencia de cero o más eventos (como una secuencia de datos).
 Mono: Representa una secuencia que puede tener cero o un solo evento (por ejemplo, una operación que puede tener éxito o fallar).
 
 Nota> Un "Subscriber" en Reactor es esencialmente un observador que se suscribe a un "Flux" o a un "Mono" para recibir notificaciones sobre eventos emitidos por estos objetos reactivos.
 
 Métodos:
 - subscribe() se utiliza para registrar un "observador" en un "observable"
 