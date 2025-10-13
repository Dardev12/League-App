//
//  ProfilViewModel.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import BackgroundTasks
import FirebaseStorage
import Foundation
import shared

extension ProfilScreen {
    @MainActor class ProfilViewModel: ObservableObject {
        private var sessionCache = AppStorageSessionCache()

        @Published var user: User = User(UserId: "", Email: "", ProfilPicture: "")
        @Published var isYourProfil: Bool = false
        @Published var isSameUserId: Bool = false
        @Published var idUser: String = ""
        @Published var imageURL = URL(string: "")
        @Published var activeUserId: String = ""
        @Published var followerCount: Int64 = 0
        @Published var followingCount: Int64 = 0
        @Published var isLoadingFollower: Bool = false
        @Published var isLoadingFollowing: Bool = false
        @Published var isLoading: Bool = false
        @Published var isRequestFollowSend: Bool = false
        @Published var isFollow: Bool = false
        @Published var isBlockPopUpOpen: Bool = false
        @Published var isReportPopUpOpen: Bool = false

        init(userID: String, yourProfil: Bool) {
            isYourProfil = sessionCache.getActiveSession()?.currentUserGuid == userID
            idUser = userID
        }

        func signOut() async {
            /*sessionCache.clearSession()
            try! await authService.signOut()

            BGTaskScheduler.shared.cancel(taskRequestWithIdentifier: "land.refreshSession")*/
        }
    }
}
