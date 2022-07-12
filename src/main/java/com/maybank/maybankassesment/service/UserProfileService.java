package com.maybank.maybankassesment.service;

import com.maybank.maybankassesment.dto.UserProfileCreationDto;
import com.maybank.maybankassesment.dto.UserProfileSavingWithdrawDto;

public interface UserProfileService {

  boolean creation(UserProfileCreationDto userProfileCreationDto);
  String saving(UserProfileSavingWithdrawDto userProfileSavingWithdrawDto);
  String withdraw(UserProfileSavingWithdrawDto userProfileSavingWithdrawDto);

}
