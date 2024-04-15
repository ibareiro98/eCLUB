# eCLUB
Api de prueba para Desarrollador Backend

Pruebas Unitarias
Las pruebas se realizan automaticamente al ejecutar el mvn package, no arrojando errores. Esta configurado asi en el pom.xml

Pasos de Instalacion
1. Se deben descargar JAVA 17, Maven igual o superior al del proyecto (3.2.4) para hacer el empaquetado
2. Se debe descargar el servidor de RabbitMQ, y su plugin para el gestor grafico
3. Se debe descargar Postgresql, junto a pgAdmin 4(lo utilice yo por preferencia)

Pasos de configuracion y valores
1. Para RabbitMQ nada mas se debe instalar, el proyecto utiliza las credenciales por defecto, al igual que el puerto, asumiendo este en localhost. Una vez instalado y abierto el gestor grafico, en el apartado de colas crear una llamada stock, mas nada
2. Para Postgresql, lo mismo, pero la contrasena se debe setear segun el que tengan, lo dejare vacio. Tambien deben crear un esquema llamado "produccion", mas nada por el lado de la DB
