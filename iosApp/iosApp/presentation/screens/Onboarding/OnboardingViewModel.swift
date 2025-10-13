//
//  OnboardingViewModel.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation

extension OnboardingScreen {
    @MainActor class OnboardingViewModel: ObservableObject {
        private var sessionCache = AppStorageSessionCache()
        
        func onBoardingNavigationValidate(){
            sessionCache.saveOnboarding(hasSeenOnboarding: true)
        }
    }
}
