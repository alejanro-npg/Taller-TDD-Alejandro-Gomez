package edu.unisabana.dyas.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResultForValidPerson() {
        //La primera es válida y las siguiente no.
        Person person = new Person("Alice", 12345, 30, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);

        Person person2 = new Person("Joan", 12378, -90, Gender.FEMALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.VALID, result2);

      
    }

    @Test
    public void validateRegistryResultForDeadPerson() {

        //La primera persona validara que esta muerta y la siguiente no

        Person person = new Person("Bob", 54321, 40, Gender.MALE, false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);

        Person person2 = new Person("David", 12398, 40, Gender.FEMALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DEAD, result2);
    }

    @Test
    public void validateRegistryResultForUnderagePerson() {

        //La primera persona validara que es menor, la segunda no.

        Person person = new Person("Charlie", 67890, 16, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);

        Person person2 = new Person("Pepe", 13378, 80, Gender.FEMALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.UNDERAGE, result2);

 
    }

    @Test
    public void validateRegistryResultForInvalidAgePersonNegative() {

        //La primera persona validara que la edad es inválida, la segunda tendrá una edad válida.
        Person person = new Person("David", 98765, -25, Gender.MALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);

        Person person2 = new Person("Theo", 23378, 1, Gender.FEMALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result2);

    
    }

    @Test
    public void validateRegistryResultForInvalidAgePersonOld() {

        ///La primera persona validara que la edad es inválida, la segunda tendrá una edad válida.
        Person person = new Person("Eve", 19283, 250, Gender.FEMALE, true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);

        Person person2 = new Person("Tano", 63378, 70, Gender.FEMALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result2);

    }

    @Test
    public void validateRegistryResultForDuplicatedPerson() {
        
        //Primera pesona se guardara en el registro, segunda tendra el mismo ID, y la tercera persona tendra un ID diferente

        Person person1 = new Person("Frank", 11111, 35, Gender.MALE, true);
        RegisterResult result1 = registry.registerVoter(person1);
        Assert.assertEquals(RegisterResult.VALID, result1);

        Person person2 = new Person("George", 11111, 40, Gender.MALE, true);
        RegisterResult result2 = registry.registerVoter(person2);
        Assert.assertEquals(RegisterResult.DUPLICATED, result2);

        Person person3 = new Person("Catha", 11110, 80, Gender.FEMALE, true);
        RegisterResult result3 = registry.registerVoter(person3);
        Assert.assertEquals(RegisterResult.DUPLICATED, result3);
    }
}
