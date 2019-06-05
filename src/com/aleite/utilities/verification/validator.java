package com.aleite.utilities.verification;

import java.util.regex.Pattern;

public class validator {
    protected Pattern pattern;

    public validator(String regexp) {
        this.pattern= Pattern.compile(regexp);
    }


    protected boolean validate(String input){
        if((input!=null)&&(input.length()>0)){
            if(this.pattern.split(input).length==0){

                return true;
            }
        }
        return false;
    }
}
