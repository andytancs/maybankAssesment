package com.maybank.maybankassesment.service;

import com.maybank.maybankassesment.dto.UserProfileCreationDto;
import com.maybank.maybankassesment.dto.UserProfileSavingWithdrawDto;
import com.maybank.maybankassesment.entity.UserProfile;
import com.maybank.maybankassesment.repo.UserProfileRepo;
import com.maybank.maybankassesment.util.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    EncryptionUtil encryptionUtil;

    @Autowired
    private UserProfileRepo userProfileRepo;

    @Override
    public boolean creation(UserProfileCreationDto userProfileCreationDto) {
        try {
            UserProfile userProfile = new UserProfile();
            userProfile.setName(userProfileCreationDto.getName());
            userProfile.setDob(userProfileCreationDto.getDob());
            userProfile.setHashpassword(encryptionUtil.sha256(userProfileCreationDto.getPassword()));
            userProfile.setBalance(BigDecimal.valueOf(0.00));
            userProfileRepo.save(userProfile);
        }catch (Exception e){
            return false;
        }
        return true;

    }

    @Override
    public String saving(UserProfileSavingWithdrawDto userProfileSavingDto) {
        try {
            StringBuilder message = new StringBuilder();
           UserProfile userProfile =  userProfileRepo.findByName(userProfileSavingDto.getName());
               if(userProfile!=null) {
                   String passwordHashing = encryptionUtil.sha256(userProfileSavingDto.getPassword());
                   if (passwordHashing.matches(userProfile.getHashpassword())) {
                       userProfile.setBalance(userProfileSavingDto.getAmount());
                       userProfileRepo.save(userProfile);
                       message.append("Successful Save");
                   } else {
                       message.append("Wrong password");
                   }
               }else{
                   message.append("Unable locate user");
               }
           return message.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @Override
    public String withdraw(UserProfileSavingWithdrawDto userProfileWithdrawDto) {
        StringBuilder message = new StringBuilder();
        try {
            UserProfile userProfile = userProfileRepo.findByName(userProfileWithdrawDto.getName());
            String passwordHashing = encryptionUtil.sha256(userProfileWithdrawDto.getPassword());
            if (passwordHashing.matches(userProfile.getHashpassword())) {
                if (userProfileWithdrawDto.getAmount().compareTo(userProfile.getBalance()) == 1) {
                    message.append("Insufficient amount");
                } else {
                    userProfile.setBalance(userProfile.getBalance().subtract(userProfileWithdrawDto.getAmount()));
                    userProfileRepo.save(userProfile);
                    message.append("Successful Withdraw");
                }
            }else message.append("Wrong password");
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        return message.toString();
    }


    }
