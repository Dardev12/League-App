//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared

extension HomeScreen{
    @MainActor class HomeViewModel: ObservableObject {
        private var sessionCache = AppStorageSessionCache()
        
        @Published var idUserSession: String = ""
        @Published var isNotified: Bool = false
        
        init(){
            /*guard let activeSession = sessionCache.getActiveSession() else {
                // Gérer le cas où activeSession est nil
                return 
            }
            idUserSession = activeSession.currentUserGuid*/
        }
        
    }
}
