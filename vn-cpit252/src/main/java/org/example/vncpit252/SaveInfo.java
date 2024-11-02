package org.example.vncpit252;


import java.io.Serializable;

public class SaveInfo implements Serializable {
    private String name;
    private String mail;
    private String gender;
    private Badge badge;

    private String country;
    private int age;
    private String intrest;

    public SaveInfo(SaveInfoBuilder saveInfoBuilder) {
        this.mail = saveInfoBuilder.mail;
        this.name = saveInfoBuilder.name;
        this.country = saveInfoBuilder.country;
        this.gender = saveInfoBuilder.gender;
        this.age = saveInfoBuilder.age;
        this.intrest = saveInfoBuilder.intrest;
        this.badge = new Badge();
    }



    public static class SaveInfoBuilder {
        private String name;
        private String mail;
        private String gender;

        private String country;
        private int age;
        private String intrest;

        public SaveInfoBuilder(String name, String mail, String gender) {
            this.name = name;
            this.mail = mail;
            this.gender = gender;
        }
        public void withCountry(String country){
            this.country=country;
        }
        public void withAge(int age){
            this.age=age;

        }
        public void withIntrest(String intrest){
            this.intrest=intrest;
        }

        public SaveInfo build(){
            return new SaveInfo(this);
        }
    }

}

