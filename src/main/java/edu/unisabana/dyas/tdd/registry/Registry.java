package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

public class Registry {

    //Se guarda los IDs de las personas registradas
    private Set<Integer> registeredIds = new HashSet<>();

    public RegisterResult registerVoter(Person p) {

        
         // Verificar si la persona esta muerta.
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }
        
     // Verificar si la edad es inválida (negativa, igual a 0 o mayor de 150 años )
        if (p.getAge() <= 0 || p.getAge()>150) {
            return RegisterResult.INVALID_AGE;
         }


        // Verificar si la persona es menor de edad
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }

        // Verificar si el ID ya está registrado
        if (registeredIds.contains(p.getId())) {
            return RegisterResult.DUPLICATED;
        }

        // Si pasa todas las validaciones, registrar al votante
        registeredIds.add(p.getId());
        return RegisterResult.VALID;
    }
       
    }
