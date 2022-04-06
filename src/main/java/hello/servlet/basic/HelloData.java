package hello.servlet.basic;

//Json에서 java property 접근법이라 해서 자동적으로 해당 개체에 접근한다.

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HelloData {

    private String username;
    private int age;
}


//Legacy
//Json에서 java property 접근법이라 해서 자동적으로 해당 개체에 접근한다.
//
//public class HelloData {
//
//    private String username;
//    private int age;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
