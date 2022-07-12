package com.maybank.maybankassesment.controller;


import com.maybank.maybankassesment.dto.UserProfileCreationDto;
import com.maybank.maybankassesment.dto.UserProfileSavingWithdrawDto;
import com.maybank.maybankassesment.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaybankService {

    @Autowired
    UserProfileService userProfileService;

    @PostMapping("/profileCreation")
    public ResponseEntity<Object>profileCreation (@RequestBody UserProfileCreationDto userProfile){
        StringBuilder message = new StringBuilder();
        message.append(userProfileService.creation(userProfile) ? "Successful Created": "Failed Please Check");
        return ResponseEntity.ok().body(message);
    }

    @PostMapping("/saving")
    public ResponseEntity<Object>input(@RequestBody UserProfileSavingWithdrawDto userProfileSavingDto){
    return ResponseEntity.ok().body(userProfileService.saving(userProfileSavingDto));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Object>withdraw(@RequestBody UserProfileSavingWithdrawDto userProfileWithdrawDto){
        return ResponseEntity.ok().body(userProfileService.withdraw(userProfileWithdrawDto));
    }


}
