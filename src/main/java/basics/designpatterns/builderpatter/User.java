package basics.designpatterns.builderpatter;

public class User {
    private String name;
    private String email;
    private String phone;
    private String major;

    public User(UserBuilder userBuilder){
        this.name =  userBuilder.getName();
        this.email = userBuilder.getEmail();
        this.phone = userBuilder.getPhone();
        this.major = userBuilder.getMajor();
    }


    private static class UserBuilder{
        private String name;
        private String email;
        private String phone;
        private String major;

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public String getMajor() {
            return major;
        }

        public UserBuilder (String name, String email){
            this.name=name;
            this.email=email;
        }

        public UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public UserBuilder email(String email){
            this.email = email;
            return this;
        }
        public UserBuilder phone(String phone){
            this.phone= phone;
            return this;
        }
        public UserBuilder major(String major){
            this.major = major;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

}
