//
//  AuthSignInViewModel.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

extension AuthSignInScreen{
    @MainActor class AuthSignInViewModel: ObservableObject {
        private var sessionCache = AppStorageSessionCache()
        
        /*func onValidateEmail(emailValue:String) -> ValidateResult {
            return LandSignIn.scanEmailField(value: emailValue)
        }

        func onValidatePassword(passwordValue:String) -> ValidateResult {
            return LandSignIn.scanPasswordField(value: passwordValue)
        }
        
        func connectToLandApp(signInData: LandSignInData, completion: @escaping (String?) -> Void) {
            DispatchQueue.main.async {
                self.authService.connectToLandAccount(landSignInData: signInData){ result, error in
                    
                    if let result = result {
                        self.sessionCache.saveSession(session: result)
                        
                        scheduleBackgroundRefresh()
                        
                        completion(IosStringResources(id:SharedRes.strings().connexion_success_message,args:[]))
                    } else {
                        completion(IosStringResources(id:SharedRes.strings().connexion_error_data_message,args:[]))
                    }
                }
            }
        }
        
        func connectGoogleToLandApp(signInData: LandSignInGoogleData, completion: @escaping (String?) -> Void) {
            DispatchQueue.main.async {
                self.authGoogleService.connectToLandAccount(landSignInData: signInData){ result, error in
                    
                    if let result = result {
                        self.sessionCache.saveSession(session: result)
                        
                        scheduleBackgroundRefresh()
                        
                        completion(IosStringResources(id:SharedRes.strings().connexion_success_message,args:[]))
                    } else {
                        completion(IosStringResources(id:SharedRes.strings().connexion_error_data_message,args:[]))
                    }
                }
            }
        }*/
    }
}
