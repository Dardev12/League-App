//
//  ParameterViewModel.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared

extension ParameterScreen {
    @MainActor class ParameterViewModel: ObservableObject {
        private var sessionCache = AppStorageSessionCache()
        @Published var userId: String = ""
        @Published var isRemovePopUpOpen: Bool = false

        init() {
            userId = sessionCache.getActiveSession()!.currentUserGuid
            /*if let userGuid = sessionCache.getActiveSession()?.currentUserGuid {
                userId = userGuid
                print(userId)
            }*/
        }

    }
}
