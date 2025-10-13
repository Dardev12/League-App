//
//  AuthSignUpViewModel.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

extension AuthSignUpScreen{
    @MainActor class AuthSignUpViewModel: ObservableObject {
        private var sessionCache = AppStorageSessionCache()
        
        /*func onValidateEmail(emailValue:String) -> ValidateResult {
            return ValidateResult(true)
        }

        func onValidatePassword(passwordValue:String) -> ValidateResult {
            return ValidateResult(true)
        }

        func onValidateRepeatPassword(passwordValue:String,repeatedPasswordValue:String) -> ValidateResult {
            return ValidateResult(true)
        }*/
        
        /*func enrollToLandApp(signUpData:LandSignUpData, completion: @escaping (String?) -> Void) {
            DispatchQueue.main.async {
                self.authService.createAccountLand(landSignUpData: signUpData){ result, error in
                    
                    if let result = result {
                        self.sessionCache.saveSession(session: result)
                        
                        scheduleBackgroundRefresh()
                        
                        completion(IosStringResources(id:SharedRes.strings().enroll_success_message,args:[]))
                    } else {
                        completion(IosStringResources(id:SharedRes.strings().enroll_error_validation_message,args:[]))
                    }
                }
            }
        }
        
        func enrollGoogleToLandApp(signUpData:LandSignUpGoogleData, completion: @escaping (String?) -> Void) {
            DispatchQueue.main.async {
                self.authGoogleService.createAccountLand(landSignUpData: signUpData){ result, error in
                    
                    if let result = result {
                        self.sessionCache.saveSession(session: result)
                        
                        scheduleBackgroundRefresh()
                        
                        completion(IosStringResources(id:SharedRes.strings().enroll_success_message,args:[]))
                    } else {
                        completion(IosStringResources(id:SharedRes.strings().enroll_error_validation_message,args:[]))
                    }
                }
            }
        }*/
    }
}
