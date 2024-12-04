package org.example.vncpit252;


import java.io.Serializable;

public class SaveInfo implements Serializable {
    private String name= null;
    
    private String gender;
    private Badge badge=null;

    private String country;
    private int age;
    private String intrest;

    // Constructor that uses the SaveInfoBuilder to initialize fields
    public SaveInfo(SaveInfoBuilder saveInfoBuilder) {
        ;
        this.name = saveInfoBuilder.name;
        this.country = saveInfoBuilder.country;
        this.gender = saveInfoBuilder.gender;
        this.age = saveInfoBuilder.age;
        this.intrest = saveInfoBuilder.intrest;
        this.badge = new Badge(); // Creates a default Badge
    }
    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SaveInfoBuilder{" +
                "name='" + name + '\'' +
                
                ", gender='" + gender + '\'' +
                ", country='" + country + '\'' +
                ", age=" + age +
                ", intrest='" + intrest + '\'' +
                '}';
    }

    // Nested Builder class
    public static class SaveInfoBuilder {
        private String name=null;
        
        private String gender;



        private String country;
        private int age;
        private String intrest;

        // Builder constructor with required fields
        public SaveInfoBuilder(String name, String gender) {
            this.name = name;
           
            this.gender = gender;
        }

        // Methods to set optional fields
        public SaveInfoBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public SaveInfoBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public SaveInfoBuilder withIntrest(String intrest) {
            this.intrest = intrest;
            return this;
        }

        // Build method to create a SaveInfo instance
        public SaveInfo build() {
            return new SaveInfo(this);
        }
    }
}