//
//  ProfilScreen.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import FirebaseStorage
import shared
import SwiftUI

struct ProfilScreen: View {
    @State private var selection: String? = nil
    @State private var postArgument: String = ""
    @State private var showDialogFollower = false
    @State private var showDialogFollowing = false
    @ObservedObject var viewModel: ProfilViewModel
    let feedbackTip = FeedbackTip()

    init(userID: String, yourProfil: Bool) {
        viewModel = ProfilViewModel(userID: userID, yourProfil: yourProfil)
    }

    var body: some View {
        ZStack {
            VStack(spacing: 0) {
                NavigationLink(destination: ParameterScreen(), tag: "Parameter", selection: $selection) {
                    EmptyView()
                }
                NavigationLink(destination: HomeScreen(), tag: "Home", selection: $selection) {
                    EmptyView()
                }
                NavigationLink(destination: AuthMenuScreen(), tag: "AuthMenu", selection: $selection) {
                    EmptyView()
                }

                ZStack(alignment: .top) {
                    Color.background
                        .ignoresSafeArea()
                    RoundedRectCorner(radius: 50, corners: [.bottomLeft, .bottomRight])
                        .frame(maxWidth: .infinity)
                        .frame(height: 300)
                        .foregroundColor(Color.topBarBackground)
                        .shadow(color: Color.black.opacity(0.5), radius: 2, x: 0, y: 2)
                    VStack {
                        // Top Bar
                        // User Info

                    }
                }.frame(height: 280)
                    .edgesIgnoringSafeArea(.top)
                // Slider
                
                Survey(onFeedbackClick: {
                    if #available(iOS 17.0, *) {
                        feedbackTip.invalidate(reason: .actionPerformed)
                    }
                    guard let url = URL(string: "https://apple.com") else { return }
                    UIApplication.shared.open(url)
                })
                Spacer()
                
            }.background(
                Color.background
                    .ignoresSafeArea()
            ).navigationBarBackButtonHidden(true)
        }.onAppear(perform: {
            
        })
        .onDisappear(perform: {
            
        })
    }
}
