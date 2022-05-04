# RETO JAVA - POD 2

## Empresa venta de máquinas para la confección



Proyecto del curso – Empresa venta de máquinas para la confección
Una empresa colombiana que se dedica a la compra y venta de máquinas industriales
para la confección quiere implementar su sistema que le permita realizar la
gestión de diferentes puntos de su negocio:
1. Inventario
2. Ventas
3. Compras
4. Gastos
5. Facturación Electrónica
6. Recursos humanos
7. Estados financieros por mes
Requisitos no funcionales generales:
1. El sistema debe tener la capacidad de uso para 500 empleados de la
compañía, cada uno con diferentes roles.
2. El sistema debe estar alojado en la nube
3. Los servicios web expuestos deben contar con seguridad mediante token
4. El sistema debe permitir enviar notificaciones por correo electrónico.
5. Los tiempos de respuesta deben ser bajos, específicamente para las ventas.
6. El sistema debe tener un diseño amigable.
7. Los empleados deben identificarse en el sistema a partir de un usuario
8. En caso de fallas el sistema debe presentar mensajes amigables al usuario.
9. El sistema debe contar con por lo menos 3 roles, y cada rol debe poder ver
información diferente.
10.Cada registro del inventario debe contar con un número único de
identificación.
11.Los usuarios del sistema deben contar con un número único de
identificación.
Requisitos funcionales generales:
1. Debe contar con administración de usuarios
2. El sistema debe contar con un chat en línea que permita comunicación con
usuarios que tengan inquietudes relacionadas con la compra y venta de
máquinas de coser.
3. El sistema debe tener una página de inicio donde se le presente al empleado
información relevante de su día a día, además de su información de
empleado, y debe tener la posibilidad de modificar su pérfil, agregar foto
de perfil y vincular con redes sociales.
4. El sistema debe contar con administración de perfiles de usuario.
Módulo de seguridad transversal a todos los módulos.
El módulo estará formado por: Deberá configurar el acceso, las cuales estarán
gestionadas por el servidor de aplicaciones. El sistema contendrá una pantalla de
ingreso con login y password (debidamente encriptado en la base de datos).
Este módulo realizará la integración de los demás módulos del sistema garantizando
que los roles de los usuarios se ajusten a las distintas opciones de cada menú o
formulario. Se contempla la identificación y desarrollo de los casos de uso
relacionados con la seguridad, así como el análisis de requisitos y el diseño del
módulo.
Dentro del alcance de dicho sistema se deben incluir los siguientes módulos:
1. Inventario:
Este módulo permite registrar las diferentes máquinas que se van comprando en el
día a día de ejecución del negocio.
Cada empleado debe tener un usuario y una contraseña que le permita ingresar al
sistema.
Se definen los siguientes requerimientos:
 RF1. Alta de empleados con sus perfiles asociados.
 RF2. Modificación de datos personales de empleados.
 RF3. Registro de inventario.
 RF4. Se debe poder registrar diferentes tipos de máquinas en el inventario y
categorizarlos según su estado(Nueva, Segunda).
 RF5. Se debe tener por lo menos los siguientes campos: Marca, modelo, ubicación
(punto de venta), precio de compra, recibo de compra, fecha de creación, fecha de
venta, vendedor (Puede ser un empleado o un tercero, los terceros no tienen acceso
a la plataforma).
 RF6. Generación de reportes de inventario disponible por mes.
 RF7. Envío automático de reportes de inventario por mes, al administrador del
punto de venta.
2. Ventas:
Este módulo permite realizar la gestión de las ventas realizadas en el día a día.
Se debe poder utilizar dispositivos móviles o computadores.
Cada empleado debe tener un usuario y una contraseña que le permita ingresar al
sistema.
Se definen los siguientes requerimientos:
 RF1. Alta de empleados con sus perfiles asociados.
 RF2. Modificación de datos personales de empleados.
 RF3. Facturación electrónica de las ventas.
 RF4. Actualización de inventario de las ventas.
 RF5. Actualización estado financiero del mes.
 RF6. Se debe poder enviar notificaciones con las ventas semanales al
administrador del punto de venta.
3. Compras:
Este módulo permite realizar el registro de las diferentes compras de máquinas que
se realizan día a día.
Cada empleado debe tener un usuario y una contraseña que le permita ingresar al
sistema.
Se definen los siguientes requerimientos:
 RF1. Alta de empleados y proveedores.
 RF2. Modificación de datos personales de empleados.
 RF3. Registro de la compra.
 RF4. Actualización del inventario.
 RF5. Envío correo al encargado del inventario del punto de venta.
 RF6. Check list que certifique el estado de la máquina al momento de la compra.
4. Recursos humanos:
Este módulo permite realizar la gestión de los empleados de la compañía.
Cada empleado debe tener un usuario y una contraseña que le permita ingresar al
sistema.
Se definen los siguientes requerimientos:
 RF1. Alta de empleados.
 RF2. Modificación de datos personales de empleados.
 RF3. Registro de empleados nuevos y creación de usuarios.
 RF4. Registro datos básicos del empleado.
 RF5. Registro datos del contrato del empleado.
 RF6. Registro del rendimiento del empleado y las evaluaciones de rendimiento
realizadas a este.
Restricciones técnicas
El sistema debe estar alojado en la nube AWS
Nota aclaratoria: los requerimientos funcionales y no funcionales pueden ampliarse
o proponer unos nuevos.
