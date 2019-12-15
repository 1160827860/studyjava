package com.darksouls.annotation;


    @Table("user")
    public class Filter {
        @Column("user_name")
        String name;
        @Column("user_password")
        String password;
        @Column("user_mail")
        String mail;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }
    }


