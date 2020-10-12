package br.com.nedramdev.covid19api;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderUtil {

    public static void main(String[] args){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("doc123"));
    }
}
