# Statics en Java

En java, la palabra clave `static` se usa como modificador al definir un miembro en una clase, haciendo que el miembro pase a ser parte de la clase en lugar de la instancia.

Los miembros no estáticos forman parte de un objeto y tienen acceso a todos los métodos y atributos del mismo. Cuando un miembro es marcado como estático deja de depender de una instancia y pasa a ser propiedad de la clase en sí, y se puede utilizar directamente sin instanciar nada, pero no pueden acceder a los miembros no estáticos.

Los atributos estáticos son inicializados la primera vez que se hace referencia a la clase a la que pertenecen y su ciclo de vida dura hasta la finalización de proceso del programa, siendo accesibles en todo momento de forma global.

Los métodos estáticos suelen ser utilizados para funciones de uso común y repetitivo que no requieren acceso a los miembros de instancia de la clase. Ejemplos de esto podrían ser funciones puras (como la mayoría de los métodos de la clase `Math`) o métodos de fabricación ("static factory methods").

Esta palabra clave no solo se usa como un modificador, también sirve para definir bloques de inicialización estáticos. Estos bloques solo se evaluan una unica vez cuando se referencia a la clase, justo después de que todos los atributos estáticos se inicializan. Al igual que los métodos estáticos, estos bloques no tienen acceso a los miembros no estáticos de la clase.

El modificador `static` es muy utilizado en combinación con el modificador `final` para definir constantes (aunque yo no usaría ese término). Las constantes se caracterizan por ser de solo lectura, es decir, que no pueden cambiar su valor inicial. Esto es muy útil para evitar usar "números mágicos" o para tener una referencia a un objeto sin preocuparse de que pueda ser reasignada de forma no intencionada.
