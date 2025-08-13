# Usar imagen de OpenJDK para compilar
FROM eclipse-temurin:17-jdk AS build

# Crear directorio de trabajo
WORKDIR /app

# Copiar todos los archivos del proyecto
COPY . .

# Compilar el proyecto usando Maven
RUN ./mvnw clean package -DskipTests

# Usar una imagen ligera para ejecutar
FROM eclipse-temurin:17-jre

# Directorio de trabajo en la imagen final
WORKDIR /app

# Copiar el JAR generado desde la etapa de compilación
COPY --from=build /app/target/*.jar app.jar

# Puerto dinámico
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
