//
//  OnboardingScreen.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct OnboardingScreen: View {
    @State private var selection: String? = nil
    @State var currentScreen = 1
    @ObservedObject var viewModel: OnboardingViewModel
    
    init() {
        viewModel = OnboardingViewModel()
        AnalyticsManager.manager.logEvent(name: "Start_Process_Onboarding_Page_1")
    }
    
    var body: some View {
        VStack{
            NavigationLink(destination: AuthMenuScreen(), tag: "Menu", selection: $selection) {
                EmptyView()
            }
            switch currentScreen {
            case 1:
                PageOneIntroduction {
                    currentScreen = 2
                    AnalyticsManager.manager.logEvent(name: "Navigate_To_Onboard_Page_2")
                }
            case 2:
                PageTwoUseCase {
                    currentScreen = 3
                    AnalyticsManager.manager.logEvent(name: "Navigate_To_Onboard_Page_3")
                }
            case 3:
                PageSwipy {
                    currentScreen = 4
                    AnalyticsManager.manager.logEvent(name: "Navigate_To_Onboard_Page_4")
                }
            case 4:
                PageThreeMap {
                    currentScreen = 5
                    AnalyticsManager.manager.logEvent(name: "Navigate_To_Onboard_Page_5")
                }
            case 5:
                PageFiveCommunity {
                    viewModel.onBoardingNavigationValidate()
                    AnalyticsManager.manager.logEvent(name: "Completed_the_Onboarding_Process")
                    selection = "Menu"
                }
            default:
                PageOneIntroduction {
                    currentScreen = 2
                    AnalyticsManager.manager.logEvent(name: "Navigate_To_Onboard_Page_2")
                }
            }
        }.navigationBarBackButtonHidden(true)
    }
}

#Preview {
    OnboardingScreen()
}
