//
//  HomeScreen.swift
//  iosApp
//
//  Created by Darren on 2025-10-12.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared
import TipKit

struct HomeScreen: View {
    @State private var selection: String? = nil
    @State private var postId: String = ""
    @State private var eventId: String = ""
    @State private var ticketmasterId: String = ""
    @State private var timer: Timer?
    @State private var showAddPopup = false
    @ObservedObject var viewModel: HomeViewModel
    private var ratingManager: RatingManager = RatingManager()
    let bottomBarTip = BottomBarTip()
    let feedbackTip = FeedbackTip()
    let mapTip = MapTip()
    
    init() {
        viewModel = HomeViewModel()
    }
    
    var body: some View {
        ZStack(alignment: .top) {
            Color.background.ignoresSafeArea()
            
            NavigationLink(destination: ProfilScreen(userID: viewModel.idUserSession,yourProfil: true),tag: "Profil", selection: $selection){
                EmptyView()
            }
            NavigationLink(destination: ParameterScreen(), tag: "Parameter", selection: $selection) {
                EmptyView()
            }
            NavigationLink(destination: CameraScreen(latitudeValue: 0.0, longitudeValue: 0.0,titleValue: "",descriptionValue: ""),tag: "Camera", selection: $selection){
                EmptyView()
            }
            
            TopBar(selection: $selection)

            Text("Welcome to [Name App]")
                .font(.title3)
                .padding(.top, 16)

            Divider()
                .background(Color.gray)
                .frame(height: 1)
                .padding(.vertical, 8)

            ScrollView(.horizontal, showsIndicators: false) {
                HStack(alignment: .center, spacing: 16) {
                    ForEach(0..<6, id: \.self) { _ in
                        VStack(alignment: .center) {
                            Circle()
                                .fill(Color.gray)
                                .frame(width: 60, height: 60)

                            Text("Test")
                                .font(.body)
                        }
                    }
                }
                .padding(14)
            }

            Divider()
                .background(Color.gray)
                .frame(height: 1)
                .padding(.vertical, 8)

            VStack(alignment: .leading, spacing: 16) {
                ForEach(0..<2, id: \.self) { _ in
                    HStack(alignment: .center, spacing: 16) {
                        Circle()
                            .fill(Color.gray)
                            .frame(width: 60, height: 60)

                        VStack(alignment: .leading, spacing: 4) {
                            Text("Test")
                                .font(.body)
                                .foregroundColor(.blue)

                            Text("Topic : this is the topic")
                                .font(.subheadline)
                                .foregroundColor(.primary)
                        }
                    }
                    .padding(.vertical, 8)
                }
            }
            .padding(16)

            
            Survey(onFeedbackClick: {
                if #available(iOS 17.0, *) {
                    feedbackTip.invalidate(reason: .actionPerformed)
                }
                guard let url = URL(string: "https://forms.gle/gPNMZ7NcommuQLT4A") else { return }
                UIApplication.shared.open(url)
            })
            
            VStack {
                Spacer()
                BottomBar(
                    selection: $selection,
                    showingAddPopup: $showAddPopup
                )
            }
            
        }
        .onAppear(perform: {
            ratingManager.checkAndAskForReview()
            AnalyticsManager.manager.logEvent(name: "HomeView_Appear")
            AnalyticsManager.manager.setUserId(userId: viewModel.idUserSession)
        })
        .onDisappear{
            AnalyticsManager.manager.logEvent(name: "HomeView_Disappear")
        }.navigationBarBackButtonHidden(true)
    }
}
