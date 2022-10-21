package com.javatpoint.controller;
import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.passay.DigestDictionaryRule.ERROR_CODE;

@RestController
public class HelloWorldController {
        public String generatePassayPassword() {
            PasswordGenerator gen = new PasswordGenerator();
            CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
            CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
            lowerCaseRule.setNumberOfCharacters(2);

            CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
            CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
            upperCaseRule.setNumberOfCharacters(2);

            CharacterData digitChars = EnglishCharacterData.Digit;
            CharacterRule digitRule = new CharacterRule(digitChars);
            digitRule.setNumberOfCharacters(2);

            CharacterData specialChars = new CharacterData() {
                public String getErrorCode() {
                    return ERROR_CODE;
                }

                public String getCharacters() {
                    return "!@#$%^&*()_+[]-/.,<>";
                }
            };
            CharacterRule splCharRule = new CharacterRule(specialChars);
            splCharRule.setNumberOfCharacters(2);

            String password = gen.generatePassword(15, splCharRule, lowerCaseRule,
                    upperCaseRule, digitRule);
            return password;
        }

        @RequestMapping("/")
        public String hello() {
            return "Hello world!";
        }

        @RequestMapping("/generate")
        public String generate() {
            return "<style>\n" +
                    ".center {\n" +
                    "position: absolute;\n" +
                    "  top: 50%; right: 50%;\n" +
                    "  transform: translate(50%,-50%);  " +
                    "}\n" +
                    "</style>" +
                    "<h1 class='center'>" + generatePassayPassword() + "</h1> ";
        }

    }

