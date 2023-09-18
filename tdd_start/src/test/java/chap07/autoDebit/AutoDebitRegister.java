package chap07.autoDebit;

import java.time.LocalDateTime;

public class AutoDebitRegister {
    private CardNumberValidator validator;
    private AutoDebitInfoRepository repository;

    public AutoDebitRegister(CardNumberValidator validator, AutoDebitInfoRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }
    public RegisterResult register(AutoDebitReq req){
        CardValidity validity = validator.validate(req.getCardNumber());
        if(validity != CardValidity.VALID){
            return RegisterResult.error(validity);
        }
        AutoDebitInfo info = repository.findOne(req.getUserId());
        if(info != null){
            info.changeCardNumber(req.getCardNumber());
        }else {
            AutoDebitInfo newinfo =
                    new AutoDebitInfo(req.getUserId(), req.getCardNumber(),
                            LocalDateTime.now());
            repository.save(newinfo);
        }
        return RegisterResult.success();
    }
}
