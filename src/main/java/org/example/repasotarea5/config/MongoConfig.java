package org.example.repasotarea5.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.example.repasotarea5.exceptions.ConnectionsDbExcepcion;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Esta anotación indica que esta clase es una clase de configuración de Spring
public class MongoConfig {

    @Value("mongodb://localhost:27017/musicaEsteban") // Esta anotación se utiliza para inyectar valores en campos, métodos o constructores
    private String mongoUri; // Se declara una variable de tipo String llamada mongoUri

    @Bean // Esta anotación se utiliza para indicar que un método de un objeto de configuración debe ser tratado como un método de inicialización de bean
    public MongoClient mongoClient() {
        try {
            return MongoClients.create(mongoUri); // Se crea un cliente de MongoDB con la URI especificada
        } catch (Exception e) {
            throw new ConnectionsDbExcepcion("Error al conectarse a la base de mongo"); // Se lanza una excepción si ocurre un error al conectarse a la base de datos
        }
    }
}
