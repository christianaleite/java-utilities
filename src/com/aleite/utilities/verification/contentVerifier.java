package com.aleite.utilities.verification;

public class contentVerifier {
    public final static int EMAIL_VERIFICATION= 0;
    public final static int AMOUNT_VERIFICATION= 1;
    public final static int TEXT_VERIFICATION= 2;
    public final static int TELEPHONE_VERIFICATION= 3;
    public final static int PASSWORD_VERIFICATION= 4;
    public final static int ADDRESS_VERIFICATION= 5;
    public final static int DATE_VERIFICATION= 6;
    public final static int TIME_VERIFICATION= 7;
    public final static int NUMBER_VERIFICATION= 8;
    public final static int TIMER_VERIFICATION= 9;


    private String emailRegExp= "^[a-zA-Z0-9]+((\\.|_|-)[a-zA-Z0-9]+)*@[a-zA-Z0-9]+((\\.|-)[a-zA-Z0-9]+)?\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2}?)?$";
    private String amountRegExp= "^[0-9]{1,13}(\\.[0-9]{1,2})?$";
    private String textRegExp= "^[^(\\&|\\<|\\>|\\;|\\!|\\'|\\||\\=|\\{|\\}|\\|)]*$";

    private String phoneRegExp= "^[0-9]{8}$";
    private String passwordRegExp= "^[^(\\&|\\<|\\>|\\;|\\!|\\'|\\||\\=|\\{|\\}|\\[|\\|)]{4,30}$";
    private String addressRegExp= "^[^(\\&|\\<|\\>|\\;|\\!|\\'|\\||\\=|\\{|\\}|\\[|\\|)]*$";
    private String dateRegExp= "^[0-9]{4}\\-[0-1]?[0-9]{1}\\-[0-3]?[0-9]{1}$";
    private String timeRegExp= "^[0-2]{1}[0-9]{1}\\:[0-5]{1}[0-9]{1}\\:[0-5]{1}[0-9]{1}$";
    private String timestampRegExp= "^[0-9]{4}\\-[0-1]?[0-9]{1}\\-[0-3]?[0-9]{1}T[0-2]{1}[0-9]{1}\\:[0-5]{1}[0-9]{1}\\:[0-5]{1}[0-9]{1}$";
    private String numberRegExp= "^[0-9]+$";
    private String timerRegExp= "^[0-9]{2}\\:[0-5]{1}[0-9]{1}\\:[0-5]{1}[0-9]{1}$";

    private String base64RegExp= "^[^(\\&|\\<|\\>|\\;|\\!|\\'|\\||\\{|\\}|\\[|\\|)]*$";

    private String dolarcurrencyRegExp= "^\\${1}([0-9]{1,3},([0-9]{3},)*[0-9]{3}|[0-9]+)(.[0-9][0-9])?$";

    private validator emailValidator;
    private validator amountValidator;
    private validator textValidator;
    private validator phoneValidator;
    private validator passwordValidator;
    private validator addressValidator;
    private validator dateValidator;
    private validator timeValidator;
    private validator timestampValidator;
    private validator timerValidator;
    private validator numberValidator;
    private validator base64Validator;
    private validator dolarcurrencyValidator;



    public contentVerifier() {
    }

    public boolean verify(String data, int verificationType) {

        boolean status= false;

        switch(verificationType){
            case EMAIL_VERIFICATION:        status= this.emailIsValid(data);
                break;
            case AMOUNT_VERIFICATION:       status= this.amountIsValid(data);
                break;
            case TEXT_VERIFICATION:         status= this.textIsValid(data);
                break;
            case TELEPHONE_VERIFICATION:    status= this.phoneIsValid(data);
                break;
            case PASSWORD_VERIFICATION:     status= this.passwordIsValid(data);
                break;
            case ADDRESS_VERIFICATION:      status= this.addressIsValid(data);
                break;
            case DATE_VERIFICATION:         status= this.dateIsValid(data);
                break;
            case TIME_VERIFICATION:         status= this.timeIsValid(data);
                break;
            case NUMBER_VERIFICATION:       status= this.numberIsValid(data);
                break;
            case TIMER_VERIFICATION:        status= this.timerIsValid(data);
                break;
        }

        return status;
    }

    public boolean base64IsValid(String base64){
        if(this.base64Validator==null){
            this.base64Validator= new validator(this.base64RegExp);
        }

        return this.base64Validator.validate(base64);
    }

    public boolean numberIsValid(String number){
        if(this.numberValidator==null){
            this.numberValidator= new validator(this.numberRegExp);
        }

        return this.numberValidator.validate(number);
    }

    public boolean dateIsValid(String date){
        if(this.dateValidator==null){
            this.dateValidator= new validator(this.dateRegExp);
        }

        return this.dateValidator.validate(date);
    }

    public boolean timeIsValid(String time){
        if(this.timeValidator==null){
            this.timeValidator= new validator(this.timeRegExp);
        }

        return this.timeValidator.validate(time);
    }

    public boolean timestampIsValid(String timestamp){
        if(this.timestampValidator==null){
            this.timestampValidator= new validator(this.timestampRegExp);
        }

        return this.timestampValidator.validate(timestamp);
    }

    public boolean timerIsValid(String timer){
        if(this.timerValidator==null){
            this.timerValidator= new validator(this.timerRegExp);
        }

        return this.timerValidator.validate(timer);
    }

    public boolean addressIsValid(String address){
        if(this.addressValidator==null){
            this.addressValidator= new validator(this.addressRegExp);
        }

        return this.addressValidator.validate(address);
    }

    public boolean passwordIsValid(String password){
        if(this.passwordValidator==null){
            this.passwordValidator= new validator(this.passwordRegExp);
        }

        return this.passwordValidator.validate(password);
    }

    public boolean phoneIsValid(String phone){
        if(this.phoneValidator==null){
            this.phoneValidator= new validator(this.phoneRegExp);
        }

        return this.phoneValidator.validate(phone);
    }

    public boolean textIsValid(String text){
        if(this.textValidator==null){
            this.textValidator= new validator(this.textRegExp);
        }

        return this.textValidator.validate(text);
    }

    public boolean emailIsValid(String email){
        if(this.emailValidator==null){
            this.emailValidator= new validator(this.emailRegExp);
        }

        return this.emailValidator.validate(email);

    }

    public boolean amountIsValid(String amount){
        if(this.amountValidator==null){
            this.amountValidator= new validator(this.amountRegExp);
        }

        return this.amountValidator.validate(amount);
    }

    public boolean dolarcurrencyIsValid(String dolarcurrency){
        if(this.dolarcurrencyValidator==null){
            this.dolarcurrencyValidator= new validator(this.dolarcurrencyRegExp);
        }

        return this.dolarcurrencyValidator.validate(dolarcurrency);
    }

}
